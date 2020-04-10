package swsales.handler.product;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.ClientDeliveryDao;
import swsales.dao.OrderDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.ClientDelivery;
import swsales.model.Order;
import swsales.mvc.CommandHandler;

public class ClientDeliveryUpdateHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			int cdNo = Integer.parseInt(req.getParameter("cdNo"));
			
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				ClientDeliveryDao dao = ClientDeliveryDao.getInstance();
				ClientDelivery cd = dao.selectClientDeliveryByNo(conn, cdNo);
				req.setAttribute("clientDelivery", cd);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
			return "/WEB-INF/view/product/clientDeliveryModForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")) {
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				
				int cdNo = Integer.parseInt(req.getParameter("no"));
				System.out.println(cdNo);
/*				int oNo = Integer.parseInt(req.getParameter("oNo"));
				OrderDao dao2 = OrderDao.getInstance();
				Order cdSno = dao2.selectOrderByNo(conn, oNo);*/
				/*System.out.println(cdSno);*/
				String sDate = req.getParameter("cdDate");
				SimpleDateFormat dt = new SimpleDateFormat("yyyyy-MM-dd");
				Date cdDate = dt.parse(sDate);
				System.out.println(cdDate);
				ClientDeliveryDao dao = ClientDeliveryDao.getInstance();

				ClientDelivery clientdelivery = new ClientDelivery(cdNo,cdDate);
				dao.updateClientDelivery(conn, clientdelivery);
				res.sendRedirect(req.getContextPath()+"/product/clientDeliveryList.do");				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}
