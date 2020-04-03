package swsales.handler.client;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.ClientDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Client;
import swsales.mvc.CommandHandler;

public class ClientSelectHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("post")) {
			String selSearch = req.getParameter("selSearch");
			String search = req.getParameter("search");
			
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				ClientDao dao = ClientDao.getInstance();
				
				if(selSearch.equals("cName")) {
					Client selectClient = new Client(search);
					List<Client> list = dao.selectClientListByName(conn, selectClient);
					req.setAttribute("list", list);
				}else if(selSearch.equals("cCeo")) {
					Client selectClient = new Client();
					selectClient.setcCeo(search);
					List<Client> list = dao.selectClientListByCeo(conn, selectClient);
					req.setAttribute("list", list);
				}else if(selSearch.equals("cTel")) {
					Client selectClient = new Client();
					selectClient.setcTel(search);
					List<Client> list = dao.selectClientListByTel(conn, selectClient);
					req.setAttribute("list", list);
				}else if(selSearch.equals("cSman")) {
					int cSalesman = dao.selectClientsEmpNo(conn, search);
					Client selectClient = new Client();
					selectClient.setcSalesman(cSalesman);
					List<Client> list = dao.selectClientListBySalesman(conn, selectClient);
					req.setAttribute("list", list);
				}
				return "/WEB-INF/view/client/clientList.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}
