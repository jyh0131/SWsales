package swsales.handler.vMgr;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.SWSaleDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.SWSale;
import swsales.mvc.CommandHandler;

public class SWSaleListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			SWSaleDao dao = SWSaleDao.getInstance();
			List<SWSale> list = dao.selectSWSaleByAll(conn);
			req.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}
		return "/WEB-INF/view/vMgr/swSaleList.jsp";
	}

}
