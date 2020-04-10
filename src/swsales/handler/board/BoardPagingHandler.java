package swsales.handler.board;

import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.BoardDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Board;
import swsales.model.Paging;
import swsales.mvc.CommandHandler;

@SuppressWarnings("serial")
@WebServlet("/boardList.do")
public class BoardPagingHandler extends HttpServlet implements CommandHandler{
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection conn = null;
		
		try {
			conn = JDBCUtil.getConnection();
			BoardDao dao = BoardDao.getInstance();
			
			int page = 1;

			if (req.getParameter("page") != null) {
				page = Integer.parseInt(req.getParameter("page"));
			}
			List<Board> last = dao.listBoard(conn);
	
			Paging paging = new Paging();
			paging.setPage(page);
			paging.setTotalCount(last.size());

			List<Board> list = dao.listBoardPaging(conn, page);
			req.setAttribute("list", list);
			req.setAttribute("paging", paging);

			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/board/boardList.jsp");
			dispatcher.forward(req, res);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}
		return null;
	}
}
