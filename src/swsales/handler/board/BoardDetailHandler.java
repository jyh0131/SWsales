package swsales.handler.board;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.BoardDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Board;
import swsales.mvc.CommandHandler;

public class BoardDetailHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			BoardDao dao = BoardDao.getInstance();
			int bNo = Integer.parseInt(req.getParameter("no")); 
			int bReadCnt = Integer.parseInt(req.getParameter("readCnt"))+1;
			Board boa = new Board(bNo, null, null, null, null, null, bReadCnt, null);
			dao.updateBoardReadCnt(conn, boa);
			Board board = dao.selectBoardByNo(conn, boa);
			req.setAttribute("board", board);
			
			return "/WEB-INF/view/board/boardDetail.jsp";
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn);
		}
		return null;
	}

}
