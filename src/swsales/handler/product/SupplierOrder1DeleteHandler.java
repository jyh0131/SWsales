package swsales.handler.product;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.SupplierOrderDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.SupplierOrder;
import swsales.mvc.CommandHandler;

public class SupplierOrder1DeleteHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		int soNo = Integer.parseInt(req.getParameter("no"));
		Connection conn = null;
		
		try {
			conn = JDBCUtil.getConnection();
			SupplierOrderDao dao = SupplierOrderDao.getInstance();
			SupplierOrder so = new SupplierOrder(soNo);
			dao.deleteSupplierOrder(conn, so);
			res.sendRedirect(req.getContextPath()+"/product/supplierOrderList1.do");
			return null;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}
		return null;
	}

}