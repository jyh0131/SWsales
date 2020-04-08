package swsales.handler.product;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.ProductDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Product;
import swsales.mvc.CommandHandler;

public class ProductDetailHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			String no = req.getParameter("pNo");
			int pNo = Integer.parseInt(no);
			
			String cate = req.getParameter("pCate");
			int pcate = Integer.parseInt(cate);
			
			Connection conn = null;
			try {
				conn = JDBCUtil.getConnection();
				ProductDao dao = ProductDao.getInstance();
				Product product1 = dao.selectProductByNo(conn, pNo);
				req.setAttribute("detail", product1);
				
				Product product2 = dao.selectProductByCate(conn, pcate);
				req.setAttribute("cate", product2);
				
				List<Product> list = dao.selectProductBytt(conn, pcate);
				req.setAttribute("list", list);
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}			
			return "/WEB-INF/view/product/productDetail.jsp";
		}
		return null;
	}

}
