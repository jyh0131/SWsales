package swsales.handler.product;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.ProductDao;
import swsales.dao.SupplierDao;
import swsales.dao.SupplierOrderDao;
import swsales.dao.SupplierPurchaseDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Product;
import swsales.model.Supplier;
import swsales.model.SupplierOrder;
import swsales.model.SupplierPurchase;
import swsales.mvc.CommandHandler;

public class SupplierOrder2InsertHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			Connection conn = null;
			try {
				conn = JDBCUtil.getConnection();
				SupplierPurchaseDao dao = SupplierPurchaseDao.getInstance();
				
				SupplierPurchase lastNo = dao.selectSupplierPurchaseLastDate(conn);
				req.setAttribute("SupplierPurchase", lastNo);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}				
			return "/WEB-INF/view/product/supplierOrderRegForm2.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")) {
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				
				SupplierPurchaseDao dao = SupplierPurchaseDao.getInstance();
				
				//품목명 - 번호
				Product pName = new Product(req.getParameter("spPname"));
				ProductDao dao2 = ProductDao.getInstance();
				Product pNo = dao2.selectProductByName(conn, pName);
				int no1 = pNo.getpNo();
				String name1 = pNo.getpName();
				Product spPname = new Product(no1, name1);
				
				//System.out.println(pName); //인텔리제이
				//System.out.println(pNo); // 인텔리제이
				//System.out.println(no1); // 93
				//System.out.println(soPname);//인텔리제이

				//회사명 - 번호
				Supplier sName = new Supplier(req.getParameter("spSname"));
				SupplierDao dao3 = SupplierDao.getInstance();
				Supplier sNo = dao3.selectSupplierByName(conn, sName);
				int no2 = sNo.getsNo();
				Supplier spSname = new Supplier(no2);
				
				Product spPcost = new Product(Integer.parseInt(req.getParameter("spPcost")));
				int spQty = Integer.parseInt((req.getParameter("spQty")));
				
				String sDate = req.getParameter("spDate");
				SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
				Date spDate = dt.parse(sDate);
				
				

				SupplierPurchase sp = new SupplierPurchase(0, spPname, spSname, spPcost, spQty, spDate);// 번호오토, 번호, 번호, 가격, 수량, 날짜
				dao.insertSupplierPurchase(conn, sp);
				res.sendRedirect(req.getContextPath()+"/product/supplierOrderList2.do");
				return null;
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}
