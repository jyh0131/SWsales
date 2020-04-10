package swsales.handler.product;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.ProductDao;
import swsales.dao.SupplierPurchaseDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Product;
import swsales.model.SupplierPurchase;
import swsales.mvc.CommandHandler;

public class SupplierOrder2UpdateHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			int spNo = Integer.parseInt(req.getParameter("spNo"));
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				SupplierPurchaseDao dao = SupplierPurchaseDao.getInstance();
				SupplierPurchase sp = dao.selectSupplierPurchaseByNo(conn, spNo);
				req.setAttribute("SupplierPurchase", sp);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
			return "/WEB-INF/view/product/supplierOrderModForm2.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")) {
			Connection conn = null;
						
			try {
				conn = JDBCUtil.getConnection();
				
				int spNo = Integer.parseInt(req.getParameter("no"));
				
				Product pName = new Product(req.getParameter("spPname"));
				ProductDao dao2 = ProductDao.getInstance();
				Product spPno = dao2.selectProductByName(conn, pName);
				
				int spQty = Integer.parseInt((req.getParameter("spQty")));
				
				String sDate = req.getParameter("spDate");
				SimpleDateFormat dt = new SimpleDateFormat("yyyyy-MM-dd");
				Date spDate = dt.parse(sDate);
				
				SupplierPurchaseDao dao = SupplierPurchaseDao.getInstance();
				SupplierPurchase supplierpurchase = new SupplierPurchase(spNo, spPno, spQty, spDate);
				dao.updateSupplierPurchase(conn, supplierpurchase);
				res.sendRedirect(req.getContextPath()+"/product/supplierOrderList2.do");
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}