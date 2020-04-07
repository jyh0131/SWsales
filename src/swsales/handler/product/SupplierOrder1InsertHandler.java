package swsales.handler.product;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.ProductDao;
import swsales.dao.SupplierDao;
import swsales.dao.SupplierOrderDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Product;
import swsales.model.Supplier;
import swsales.model.SupplierOrder;
import swsales.mvc.CommandHandler;

public class SupplierOrder1InsertHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			Connection conn = null;
			try {
				conn = JDBCUtil.getConnection();
				SupplierOrderDao dao = SupplierOrderDao.getInstance();
				
				SupplierOrder lastNo = dao.selectSupplierOrderLastDate(conn);
				req.setAttribute("SupplierOrder", lastNo);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}			
			return "/WEB-INF/view/product/supplierOrderRegForm1.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")) {
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				
				SupplierOrderDao dao = SupplierOrderDao.getInstance();
				
				//품목명 - 번호
				Product pName = new Product(req.getParameter("soPname"));
				ProductDao dao2 = ProductDao.getInstance();
				Product pNo = dao2.selectProductByName(conn, pName);
				int no1 = pNo.getpNo();
				String name1 = pNo.getpName();
				Product soPname = new Product(no1, name1);
				
				//System.out.println(pName); //인텔리제이
				//System.out.println(pNo); // 인텔리제이
				//System.out.println(no1); // 93
				//System.out.println(soPname);//인텔리제이

				//회사명 - 번호
				Supplier sName = new Supplier(req.getParameter("soSname"));
				SupplierDao dao3 = SupplierDao.getInstance();
				Supplier sNo = dao3.selectSupplierByName(conn, sName);
				int no2 = sNo.getsNo();
				Supplier soSname = new Supplier(no2);
				
				Product soPcost = new Product(Integer.parseInt(req.getParameter("soPcost")));
				int soQty = Integer.parseInt((req.getParameter("soQty")));
				
				String sDate = req.getParameter("soDate");
				SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
				Date soDate = dt.parse(sDate);
				
				

				SupplierOrder so = new SupplierOrder(0, soPname, soSname, soPcost, soQty, soDate); // 번호오토, 번호, 번호, 가격, 수량, 날짜
				//System.out.println(so);
				dao.insertSupplierOrder(conn, so);
				res.sendRedirect(req.getContextPath()+"/product/supplierOrderList1.do");
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
