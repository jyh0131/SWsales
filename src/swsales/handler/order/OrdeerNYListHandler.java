package swsales.handler.order;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.OrderDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Client;
import swsales.model.Order;
import swsales.mvc.CommandHandler;

public class OrdeerNYListHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			OrderDao dao = OrderDao.getInstance();
			List<Order> list = dao.selectOrderByAll(conn);
			req.setAttribute("list", list);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn);
		}
		return "/WEB-INF/view/order/orderNYList.jsp";
	}

}
