package swsales.handler.client;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.ClientDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Client;
import swsales.mvc.CommandHandler;

public class ClientDeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int cNo = Integer.parseInt(req.getParameter("no"));
		Connection conn = null;
		
		try {
			conn = JDBCUtil.getConnection();
			ClientDao dao = ClientDao.getInstance();
			Client client = new Client(cNo);
			dao.deleteClient(conn, client);
			res.sendRedirect(req.getContextPath()+"/client/clientList.do");
			return null;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}
		return null;
	}

}
