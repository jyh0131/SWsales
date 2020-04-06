package swsales.handler.product;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.ProductDao;
import swsales.dao.SupplierOrderDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Product;
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
		}
		return null;
	}

}
