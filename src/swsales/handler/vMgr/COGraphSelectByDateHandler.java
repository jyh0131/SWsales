package swsales.handler.vMgr;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.CustomerOrderDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.CustomerOrder;
import swsales.mvc.CommandHandler;

public class COGraphSelectByDateHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("post")) {
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
				CustomerOrderDao dao = CustomerOrderDao.getInstance();
				CustomerOrder selectDate = new CustomerOrder(s1, s2);
				List<CustomerOrder> list = dao.selectClientChartTest(conn, selectDate);
				List<CustomerOrder> cName = dao.selectCustomerOrderByCNameDate(conn, selectDate);
				List<CustomerOrder> pPrice = dao.selectCustomerOrderByPPriceDate(conn, selectDate);
				
				req.setAttribute("list", list);
				req.setAttribute("cName", cName);
				req.setAttribute("pPrice", pPrice);
				
				req.setAttribute("dateText", "조회기간은 [ <span class='date'>" + startDate + "</span> ] 부터 [ <span class='date'>" + endDate + "</span> ] 까지 입니다.");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn);
			}
		}
		return "/WEB-INF/view/vMgr/customerOrderGraph.jsp";
	}

}
