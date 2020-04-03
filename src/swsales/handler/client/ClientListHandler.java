package swsales.handler.client;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.ClientDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Client;
import swsales.mvc.CommandHandler;

public class ClientListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			ClientDao dao = ClientDao.getInstance();
			List<Client> list = dao.selectClientByAll(conn);
			req.setAttribute("list", list);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}
		return "/WEB-INF/view/client/clientList.jsp";
	}

}
