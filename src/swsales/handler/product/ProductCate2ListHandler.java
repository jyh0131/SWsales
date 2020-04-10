package swsales.handler.product;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.ProductDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Product;
import swsales.mvc.CommandHandler;

public class ProductCate2ListHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int no = 2;
		
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			ProductDao dao = ProductDao.getInstance();
			List<Product> list = dao.selectProductListByCateNo(conn, no);
			req.setAttribute("list", list);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn);
		}
		return "/WEB-INF/view/product/productList2.jsp";
	}
}