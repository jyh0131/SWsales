package swsales.handler.product;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.ClientDeliveryDao;
import swsales.dao.OrderDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.ClientDelivery;
import swsales.model.Order;
import swsales.mvc.CommandHandler;

public class ClientDeliveryDeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int cdNo = Integer.parseInt(req.getParameter("cdNo"));
		
		Connection conn = null;
		
		try {
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);
			ClientDeliveryDao dao = ClientDeliveryDao.getInstance();
			ClientDelivery clientDeli = dao.selectClientDeliveryByNo(conn, cdNo);
			
			OrderDao oDao = OrderDao.getInstance();		
			Order order = new Order(clientDeli.getCdSno().getoNo());
			oDao.updateOrderDps0(conn, order);
			dao.deleteClientDelivery(conn, clientDeli);
			conn.commit();
			res.sendRedirect(req.getContextPath()+"/product/clientDeliveryList.do");
			
			return null;
			
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}
		return null;
	}

}
