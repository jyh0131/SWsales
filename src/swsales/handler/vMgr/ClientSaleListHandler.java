package swsales.handler.vMgr;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.ClientSaleDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.ClientSale;
import swsales.mvc.CommandHandler;

public class ClientSaleListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection conn = null;
		
		try {
			conn = JDBCUtil.getConnection();
			ClientSaleDao dao = ClientSaleDao.getInstance();
			List<ClientSale> list = dao.selectClientSaleByAll(conn);
			req.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}
		return "/WEB-INF/view/vMgr/clientSaleList.jsp";
	}

}
