package swsales.handler.order;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.ProductDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Product;
import swsales.mvc.CommandHandler;

public class OrderInsertHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			String no = req.getParameter("pNo");
			int pNo = Integer.parseInt(no);
			
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				ProductDao dao = ProductDao.getInstance();
				Product product = dao.selectProductByNo(conn, pNo);
				req.setAttribute("order", product);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
			return "/WEB-INF/view/order/orderRegForm.jsp";
		}
		return null;
	}

}
