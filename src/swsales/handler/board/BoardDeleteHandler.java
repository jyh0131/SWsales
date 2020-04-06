package swsales.handler.board;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.BoardDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Board;
import swsales.mvc.CommandHandler;

public class BoardDeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			BoardDao dao = BoardDao.getInstance();
			int bNo = Integer.parseInt(req.getParameter("no"));
			Board board = new Board();
			board.setbNo(bNo);
			dao.deleteBoard(conn, board);
			dao.deleteBoardContent(conn, board);
			res.sendRedirect(req.getContextPath()+"/board/boardList.do");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}
		return null;
	}

}
