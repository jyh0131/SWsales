package swsales.handler.client;

import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.ClientDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Client;
import swsales.model.Paging;
import swsales.mvc.CommandHandler;

@SuppressWarnings("serial")
@WebServlet("/clientList.do")
public class ClientPagingHandler extends HttpServlet implements CommandHandler{
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection conn = null;
		
		try {
			conn = JDBCUtil.getConnection();
			ClientDao dao = ClientDao.getInstance();
			
			int page = 1;

			if (req.getParameter("page") != null) {
				page = Integer.parseInt(req.getParameter("page"));
			}
			List<Client> last = dao.selectClientByAll(conn);
	
			Paging paging = new Paging();
			paging.setPage(page);
			paging.setTotalCount(last.size());

			List<Client> list = dao.selectClientPaging(conn, page);
			req.setAttribute("list", list);
			req.setAttribute("paging", paging);

			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/client/clientList.jsp");
			dispatcher.forward(req, res);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}
		return null;
	}
}
