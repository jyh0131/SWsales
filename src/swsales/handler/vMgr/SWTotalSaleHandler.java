package swsales.handler.vMgr;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.SWTotalSaleDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.SWTotalSale;
import swsales.mvc.CommandHandler;

public class SWTotalSaleHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			SWTotalSaleDao dao = SWTotalSaleDao.getInstance();
			List<SWTotalSale> list = dao.selectSWTotalSaleByAll(conn);
			req.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}
		return "/WEB-INF/view/vMgr/SWTotalSale.jsp";
	}

}
