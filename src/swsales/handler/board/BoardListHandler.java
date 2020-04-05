package swsales.handler.board;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.BoardDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Board;
import swsales.mvc.CommandHandler;

public class BoardListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			BoardDao dao = BoardDao.getInstance();
			List<Board> list = dao.listBoard(conn);
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
