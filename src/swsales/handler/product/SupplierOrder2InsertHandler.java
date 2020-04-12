package swsales.handler.product;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.IQDao;
import swsales.dao.ProductDao;
import swsales.dao.SupplierDao;
import swsales.dao.SupplierPurchaseDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.InventoryQuantity;
import swsales.model.Product;
import swsales.model.Supplier;
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
				
				//품목명 가져오기
				ProductDao dao2 = ProductDao.getInstance();
				List<Product> list = dao2.selectProductByAll(conn);
				req.setAttribute("list", list);
				
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
				
				//품목명
				String str = req.getParameter("pInfo");
				String[] arr = str.split("/");
				String no = arr[0];
				Product pNo = new Product(Integer.parseInt(no));

				//회사명 - 번호
				Supplier sName = new Supplier(req.getParameter("spSname"));
				SupplierDao dao3 = SupplierDao.getInstance();
				Supplier sNo = dao3.selectSupplierByName(conn, sName);
				
				
				Product spPcost = new Product(Integer.parseInt(req.getParameter("spPcost")));
				int spQty = Integer.parseInt((req.getParameter("spQty")));
				
				//매입이력등록시 재고수량테이블 자동증가 시켜야함!
				IQDao dao4 = IQDao.getInstance();
				InventoryQuantity iq = new InventoryQuantity(pNo, spQty);
				dao4.insertIQ(conn, iq);
				
				String sDate = req.getParameter("spDate");
				SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
				Date spDate = dt.parse(sDate);
				
				

				SupplierPurchase sp = new SupplierPurchase(0, pNo, sNo, spPcost, spQty, spDate);// 번호오토, 번호, 번호, 가격, 수량, 날짜
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
