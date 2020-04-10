package swsales.handler.order;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.ClientDao;
import swsales.dao.ProductDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Client;
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
				ProductDao dao = ProductDao.getInstance();
				Product product = dao.selectProductByNo(conn, pNo);
				req.setAttribute("order", product);
				
				//고객 상호명 가져오기
				ClientDao dao2 = ClientDao.getInstance();
				List<Client> list = dao2.selectClientByAll(conn);
				req.setAttribute("list", list);
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
			return "/WEB-INF/view/order/orderRegForm.jsp";
		}
		return null;
	}

}
