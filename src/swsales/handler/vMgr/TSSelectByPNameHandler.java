package swsales.handler.vMgr;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.TSDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.TransactionStatement;
import swsales.mvc.CommandHandler;

public class TSSelectByPNameHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("post")) {
			Connection conn = null;
			
			try {
				String tsSearch = req.getParameter("tsSearch");
				conn = JDBCUtil.getConnection();
				TSDao dao = TSDao.getInstance();
				TransactionStatement selectSWTotal = new TransactionStatement(tsSearch);
				List<TransactionStatement> list = dao.selectTSByPName(conn, selectSWTotal);
				
				req.setAttribute("list", list);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
		}
		return "/WEB-INF/view/vMgr/tsList.jsp";
	}

}
