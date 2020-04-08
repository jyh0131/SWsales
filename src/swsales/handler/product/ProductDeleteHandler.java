package swsales.handler.product;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.ProductDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Product;
import swsales.mvc.CommandHandler;

public class ProductDeleteHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int pNo = Integer.parseInt(req.getParameter("no"));
		
		Connection conn = null;
		
		try {
			conn = JDBCUtil.getConnection();
			ProductDao dao = ProductDao.getInstance();
			Product product = new Product(pNo);
			dao.deleteProduct(conn, product);
			res.sendRedirect(req.getContextPath()+"/product/productList2.do");
			return null;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn);
		}
		return null;
	}

}
