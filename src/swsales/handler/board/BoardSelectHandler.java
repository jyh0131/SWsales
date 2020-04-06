package swsales.handler.board;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.BoardDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Board;
import swsales.mvc.CommandHandler;

public class BoardSelectHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String search = req.getParameter("inpSearch");
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			BoardDao dao = BoardDao.getInstance();
			List<Board> list = dao.searchBoardList(conn, search);
			req.setAttribute("list", list);
			
			return "/WEB-INF/view/board/boardList.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}
		return null;
	}

}
