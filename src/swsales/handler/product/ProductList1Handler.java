package swsales.handler.product;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.ProductDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Product;
import swsales.mvc.CommandHandler;

public class ProductList1Handler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			ProductDao dao = ProductDao.getInstance();
			List<Product> list = dao.selectProductByAll(conn);
			req.setAttribute("list", list);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn);
		}
		return "/WEB-INF/view/product/productList1.jsp";
	}
}
