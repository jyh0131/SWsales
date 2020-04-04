package swsales.handler.product;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.ClientDeliveryDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.ClientDelivery;
import swsales.mvc.CommandHandler;

public class ClientDeliveryListHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			ClientDeliveryDao dao = ClientDeliveryDao.getInstance();
			List<ClientDelivery> list = dao.selectClientDeliveryByAll(conn);
			req.setAttribute("list", list);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn);
		}
		return "/WEB-INF/view/product/clientDeliveryList.jsp";

}
}
