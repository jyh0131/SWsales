package swsales.handler.vMgr;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.CustomerOrderDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.CustomerOrder;
import swsales.mvc.CommandHandler;

public class CustomerOrderGraphHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {

		Connection conn = null;
	
		try {
			conn = JDBCUtil.getConnection();
			CustomerOrderDao dao = CustomerOrderDao.getInstance();
			List<CustomerOrder> cName = dao.selectCustomerOrderByCName(conn);
			List<CustomerOrder> pPrice = dao.selectCustomerOrderByPPrice(conn);
			req.setAttribute("cName", cName);
			req.setAttribute("pPrice", pPrice);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}
		return "/WEB-INF/view/vMgr/customerOrderGraph.jsp";
	
	}
}
