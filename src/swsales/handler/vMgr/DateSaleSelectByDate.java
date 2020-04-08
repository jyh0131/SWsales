package swsales.handler.vMgr;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.DateSaleDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.DateSale;
import swsales.mvc.CommandHandler;

public class DateSaleSelectByDate implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("post")) {
			Connection conn = null;
			
			try {
				String startDate = req.getParameter("startDate");
				String endDate = req.getParameter("endDate");
				conn = JDBCUtil.getConnection();
				DateSaleDao dao = DateSaleDao.getInstance();
				DateSale selectDate = new DateSale(startDate, endDate);
//				DateSale selectEnd = new DateSale(endDate);
				List<DateSale> list = dao.selectDateSaleByDate(conn, selectDate);
				
				req.setAttribute("list", list);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
		}
		return "/WEB-INF/view/vMgr/clientSaleList.jsp";
	}

}
