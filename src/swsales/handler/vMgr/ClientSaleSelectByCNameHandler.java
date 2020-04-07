package swsales.handler.vMgr;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.ClientSaleDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.ClientSale;
import swsales.mvc.CommandHandler;

public class ClientSaleSelectByCNameHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("post")) {
			Connection conn = null;
			
			try {
				String clientSearch = req.getParameter("clientSearch");
				conn = JDBCUtil.getConnection();
				ClientSaleDao dao = ClientSaleDao.getInstance();
				ClientSale selectClient = new ClientSale(clientSearch);
				List<ClientSale> list = dao.selectClientSaleByCName(conn, selectClient);
				
				req.setAttribute("list", list);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
		}
		return "/WEB-INF/view/vMgr/clientSaleList.jsp";
	}

}
