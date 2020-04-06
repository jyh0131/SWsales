package swsales.handler.vMgr;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.DateSaleDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.DateSale;
import swsales.mvc.CommandHandler;

public class DateSaleListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			DateSaleDao dao = DateSaleDao.getInstance();
			List<DateSale> list = dao.selectDateSaleByAll(conn);
			req.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}
		return "/WEB-INF/view/vMgr/dateSaleList.jsp";
	}

}
