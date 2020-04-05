package swsales.handler.board;

import java.sql.Connection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.BoardDao;
import swsales.dao.EmployeeDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Board;
import swsales.model.Employee;
import swsales.mvc.CommandHandler;

public class BoardInsertHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			return "/WEB-INF/view/board/boardRegForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")) {
			String bTitle = req.getParameter("bTitle");
			String content = req.getParameter("bContent");
			String bId = req.getParameter("bId");
			String bName = req.getParameter("bName");
			
			Connection conn = null;
			try {
				conn = JDBCUtil.getConnection();
				conn.setAutoCommit(false);
				BoardDao dao = BoardDao.getInstance();
				EmployeeDao eDao = EmployeeDao.getInstance();
				Employee emp = new Employee();
				emp.setEmpName(bName);
				String bDept = eDao.selectDeptNameByEmpName(conn, emp);
				Board board = new Board(0, bId, bName, bTitle, new Date(), new Date(), 0, bDept, content);
				
				dao.insertBoard(conn, board);
				dao.insertBoardContent(conn, board);
				conn.commit();
				res.sendRedirect(req.getContextPath()+"/board/boardList.do");
				
				return null;
			} catch (Exception e) {
				conn.rollback();
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}
