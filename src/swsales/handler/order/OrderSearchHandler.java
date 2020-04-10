package swsales.handler.order;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.ProductDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Product;
import swsales.mvc.CommandHandler;

public class OrderSearchHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("post")) {
			String sinput = req.getParameter("sinput");
			System.out.println(sinput);
			
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				
				ProductDao dao = ProductDao.getInstance();
				Product pName = new Product(null, sinput, null);
				System.out.println(pName);
				List<Product> list = dao.selectProductListByName(conn, pName);
				req.setAttribute("list", list);

				return "/WEB-INF/view/order/orderList.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}