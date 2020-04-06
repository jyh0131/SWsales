package swsales.handler.board;

import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.BoardDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Board;
import swsales.mvc.CommandHandler;

public class BoardUpdateHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			Connection conn = null;
			int bNo = Integer.parseInt(req.getParameter("no"));
			try {
				conn = JDBCUtil.getConnection();
				BoardDao dao = BoardDao.getInstance();
				Board boa = new Board();
				boa.setbNo(bNo);
				Board board = dao.selectBoardByNo(conn, boa);
				req.setAttribute("board", board);
				return "/WEB-INF/view/board/boardModForm.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn);
			}
		}else if(req.getMethod().equalsIgnoreCase("post")) {
			String bTitle = req.getParameter("bTitle");
			String content = req.getParameter("bContent");
			int bReadCnt = Integer.parseInt(req.getParameter("bReadCnt"));
			Date bModDate = new Date();
			int bNo = Integer.parseInt(req.getParameter("bNo"));
			Connection conn = null;
			try {
				conn = JDBCUtil.getConnection();
				BoardDao dao = BoardDao.getInstance();
				Board board = new Board(bNo, null, null, bTitle, null, bModDate, bReadCnt, null, content);
				dao.updateBoard(conn, board);
				dao.updateBoardContent(conn, board);
				res.sendRedirect(req.getContextPath()+"/board/boardList.do");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}
