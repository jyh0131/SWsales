package swsales.handler.product;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.ProductDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Product;
import swsales.mvc.CommandHandler;

public class ProductSearchHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("post")) {
			String selSearch = req.getParameter("selSearch");
			String search = req.getParameter("search");
			
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				ProductDao dao = ProductDao.getInstance();
				if(selSearch.equals("pName")) {
					Product selectProduct = new Product(null, search, null);
					//System.out.println(selectProduct); - 한글 2020
					List<Product> list = dao.selectProductListByName(conn, selectProduct);
					req.setAttribute("list", list);
				}/*else if(selSearch.equals("pCate")) {
					//Product selectProduct = new Product(search, null, null); 
					//List<Product> list = dao.selectProductListByCate(conn, selectProduct);
					//req.setAttribute("list", list);
				}else if(selSearch.equals("pSno")) {
					//Product selectProduct =  new Product(null, null, search);
					//List<Product> list = dao.selectProductListBySupp(conn, selectProduct);
					//req.setAttribute("list", list);
				}*/
				return "/WEB-INF/view/product/productList1.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}