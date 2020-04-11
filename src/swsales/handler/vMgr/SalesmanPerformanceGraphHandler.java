package swsales.handler.vMgr;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.SalesmanPerformanceDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.SalesmanPerformance;
import swsales.mvc.CommandHandler;

public class SalesmanPerformanceGraphHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		Connection conn = null;
		
		try {
			conn = JDBCUtil.getConnection();
			SalesmanPerformanceDao dao = SalesmanPerformanceDao.getInstance();
			List<SalesmanPerformance> list = dao.selectEmployeeChart(conn);
			List<SalesmanPerformance> eName = dao.selectSalesmanByEName(conn);
			List<SalesmanPerformance> salesMoney = dao.selectSalesmanBySalesMoney(conn);
			
			req.setAttribute("list", list);
			req.setAttribute("eName", eName);          
			req.setAttribute("salesMoney", salesMoney);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}
		return "/WEB-INF/view/vMgr/salesmanPerformanceGraph.jsp";
	}

}
