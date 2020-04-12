package swsales.handler.order;

import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import swsales.dao.ClientDeliveryDao;
import swsales.dao.OrderDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.ClientDelivery;
import swsales.model.Order;
import swsales.mvc.CommandHandler;

public class OrderNYListHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			Connection conn = null;
			try {
				conn = JDBCUtil.getConnection();
				OrderDao dao = OrderDao.getInstance();
				List<Order> list = dao.selectOrderByAll(conn);
				req.setAttribute("list", list);
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
			return "/WEB-INF/view/order/orderNYList.jsp";
			
		}else if(req.getMethod().equalsIgnoreCase("post")) {
			String [] checkedNo = req.getParameterValues("checkedBox");
			String [] uncheckedNo = req.getParameterValues("uncheckedBox");
			
			Connection conn = null;
			try {
				conn = JDBCUtil.getConnection();
				OrderDao dao = OrderDao.getInstance();
				ClientDeliveryDao cDao = ClientDeliveryDao.getInstance();
				//check되면 주문완료가 Y로 바뀌며 출고테이블에 자동저장
				for(int i=0;i<checkedNo.length;i++) {
					int no = Integer.parseInt(checkedNo[i]);
					Order order = dao.selectOrderByNo(conn, no);
					if(order.getoDps()==0) {
						dao.updateOrderDps1(conn, order);
						ClientDelivery cd = new ClientDelivery(order, new Date());
						cDao.insertClientDelivery(conn, cd);
					}
				}
				//check 해제되면 주문완료가 N으로 바뀌며 출고테이블에서 삭제됨
				for(int j=0;j<uncheckedNo.length;j++) {
					int no = Integer.parseInt(uncheckedNo[j]);
					Order order = dao.selectOrderByNo(conn, no);
					if(order.getoOk() == 1) {
						dao.updateOrderDps0(conn, order);
						ClientDelivery cd = new ClientDelivery(order, new Date());
						cDao.deleteClientDeliveryByOno(conn, cd);
					}
				}
				Map<String, String> map = new HashMap<>();
				map.put("result", "success");
				
				ObjectMapper om = new ObjectMapper();
				String json = om.writeValueAsString(map);
				
				res.setContentType("application/json;charset=UTF-8");
				PrintWriter pw = res.getWriter();
				pw.print(json);
				pw.flush();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
		
	}

}
