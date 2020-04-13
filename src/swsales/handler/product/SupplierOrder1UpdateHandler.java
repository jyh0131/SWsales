package swsales.handler.product;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.ProductDao;
import swsales.dao.SupplierOrderDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Product;
import swsales.model.SupplierOrder;
import swsales.mvc.CommandHandler;

public class SupplierOrder1UpdateHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			int soNo = Integer.parseInt(req.getParameter("soNo"));
			
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				SupplierOrderDao dao = SupplierOrderDao.getInstance();
				SupplierOrder so = dao.selectSupplierOrderByNo(conn, soNo);
				req.setAttribute("SupplierOrder", so);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
			return "/WEB-INF/view/product/supplierOrderModForm1.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")) {
			Connection conn = null;
						
			try {
				conn = JDBCUtil.getConnection();
				
				int soNo = Integer.parseInt(req.getParameter("soNo"));
				
				Product pName = new Product(req.getParameter("soPname"));
				ProductDao dao2 = ProductDao.getInstance();
				Product soPno = dao2.selectProductByName(conn, pName);
				
				int soQty = Integer.parseInt((req.getParameter("soQty")));
				
				String sDate = req.getParameter("soDate");
				SimpleDateFormat dt = new SimpleDateFormat("yyyyy-MM-dd");
				Date soDate = dt.parse(sDate);
				
				SupplierOrderDao dao = SupplierOrderDao.getInstance();
				SupplierOrder supplierorder = new SupplierOrder(soNo, soPno, soQty, soDate);
				dao.updateSupplierOrder(conn, supplierorder);
				res.sendRedirect(req.getContextPath()+"/product/supplierOrderList1.do");
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}
