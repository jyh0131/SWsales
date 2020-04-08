package swsales.handler.vMgr;

import java.sql.Connection;
import java.text.SimpleDateFormat;
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
		if(req.getMethod().equalsIgnoreCase("get")) {
			Connection conn = null;
			
			try {
				String startDate = req.getParameter("startDate");
				String endDate = req.getParameter("endDate");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date start = sdf.parse(startDate);
				java.util.Date end = sdf2.parse(endDate);
				java.sql.Date s1 = new java.sql.Date(start.getTime());
				java.sql.Date s2 = new java.sql.Date(end.getTime());
				conn = JDBCUtil.getConnection();
				DateSaleDao dao = DateSaleDao.getInstance();
				DateSale selectDate = new DateSale(s1, s2);
				List<DateSale> list = dao.selectDateSaleByDate(conn, selectDate);
				
				req.setAttribute("list", list);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
		}
		return "/WEB-INF/view/vMgr/dateSaleList.jsp";
	}

}
