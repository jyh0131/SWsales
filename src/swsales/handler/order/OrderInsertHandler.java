package swsales.handler.order;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.ClientDao;
import swsales.dao.EmployeeDao;
import swsales.dao.IQDao;
import swsales.dao.OrderDao;
import swsales.dao.ProductDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Client;
import swsales.model.Employee;
import swsales.model.InventoryQuantity;
import swsales.model.Order;
import swsales.model.Product;
import swsales.mvc.CommandHandler;

public class OrderInsertHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			String no = req.getParameter("pNo");
			int pNo = Integer.parseInt(no);
			
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				//주문 마지막번호
				OrderDao dao = OrderDao.getInstance();
				Order lastNo = dao.selectOrderLastDate(conn);
				req.setAttribute("order", lastNo);
				
				//상품정보
				ProductDao dao2 = ProductDao.getInstance();
				Product product = dao2.selectProductByNo(conn, pNo);
				req.setAttribute("product", product);
				
				//고객 상호명 가져오기
				ClientDao dao3 = ClientDao.getInstance();
				List<Client> list = dao3.selectClientByAll(conn);
				req.setAttribute("list", list);
				
				//재고수량 가져오기
				IQDao dao4 = IQDao.getInstance();
				InventoryQuantity qty = dao4.selectIqQtyByPno(conn, pNo);
				req.setAttribute("Qty", qty);
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
			return "/WEB-INF/view/order/orderRegForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")) {
			
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				
				OrderDao dao = OrderDao.getInstance();

				String date = req.getParameter("oDate");
				SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
				Date oDate = dt.parse(date);
				
				Client oCname = new Client(Integer.parseInt(req.getParameter("oCname")));
				
				Product oPname = new Product(Integer.parseInt(req.getParameter("pNo")));
				int oQty = Integer.parseInt(req.getParameter("oQty"));
				String oMemo = req.getParameter("oMemo");
				int oDps = 0;
				int oOk = 0;
				
				//등록과 동시에 재고수량에서 재고 빠지기
				IQDao dao2 = IQDao.getInstance();
				int allQty = Integer.parseInt(req.getParameter("Qty"));
				int total = allQty - oQty;
				InventoryQuantity upIq = new InventoryQuantity(oPname, total);
				dao2.updateIQ(conn, upIq);
				
				EmployeeDao edao = EmployeeDao.getInstance();
				Employee emp = new Employee(Integer.parseInt(req.getParameter("emp")));
				Employee oEname = edao.selectEmployeeByNo(conn, emp);
				
				Order order = new Order(0, oDate, oCname, oPname, oQty, oMemo, oDps, oOk, oEname);
				dao.insertOrder(conn, order);
				res.sendRedirect(req.getContextPath()+"/order/orderNYList.do");
				return null;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn);
		}			
		}
		return null;
	}

}
