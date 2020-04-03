package swsales.handler.client;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.ClientDao;
import swsales.dao.EmployeeDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Client;
import swsales.mvc.CommandHandler;

public class ClientUpdateHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			int cNo = Integer.parseInt(req.getParameter("no"));
			
			Connection conn = null;
			try {
				conn = JDBCUtil.getConnection();
				ClientDao dao = ClientDao.getInstance();
				Client client = new Client(cNo);
				Client cli = dao.selectClientByNo(conn, client);
				req.setAttribute("client", cli);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn);
			}
			return "/WEB-INF/view/client/clientModForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")) {
			int cNo = Integer.parseInt(req.getParameter("cNo"));
			String cName = req.getParameter("cName");
			String cCeo = req.getParameter("cCeo");
			String cAddress = req.getParameter("cAddress");
			String cTel = req.getParameter("cTel");
			String cSman = req.getParameter("cSman");
			
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				ClientDao dao = ClientDao.getInstance();
				EmployeeDao eDao = EmployeeDao.getInstance(); 
				int cSalesman = eDao.selectEmployeeNo(conn, cSman);
				Client client = new Client(cNo, cName);
				client.setcCeo(cCeo);
				client.setcAddress(cAddress);
				client.setcTel(cTel);
				client.setcSalesman(cSalesman);
				dao.updateClient(conn, client);
				res.sendRedirect(req.getContextPath()+"/client/clientList.do");
				
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}
