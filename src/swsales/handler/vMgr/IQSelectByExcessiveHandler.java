package swsales.handler.vMgr;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.IQEvaluationDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.IQEvaluation;
import swsales.mvc.CommandHandler;

public class IQSelectByExcessiveHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection conn = null;
		
		try {
			conn = JDBCUtil.getConnection();
			IQEvaluationDao dao = IQEvaluationDao.getInstance();
			List<IQEvaluation> list = dao.selectIQExcessiveByIQQty(conn);
			req.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}
		return "/WEB-INF/view/vMgr/iqList.jsp";
	}

}
