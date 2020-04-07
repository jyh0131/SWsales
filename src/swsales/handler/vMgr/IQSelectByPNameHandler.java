package swsales.handler.vMgr;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.IQEvaluationDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.IQEvaluation;
import swsales.mvc.CommandHandler;

public class IQSelectByPNameHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection conn = null;
		
		try {
			String iqSearch = req.getParameter("iqSearch");
			conn = JDBCUtil.getConnection();
			IQEvaluationDao dao = IQEvaluationDao.getInstance();
			IQEvaluation selectIQ = new IQEvaluation(iqSearch);
			List<IQEvaluation> list = dao.selectIQEvaluationByPName(conn, selectIQ);
			
			req.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}
		return "/WEB-INF/view/vMgr/iqList.jsp";
	}

}
