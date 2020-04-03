package swsales.handler.client;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.SupplierDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Supplier;
import swsales.mvc.CommandHandler;

public class SupplierDeleteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		int sNo = Integer.parseInt(req.getParameter("no"));
		Connection conn = null;
		
		try {
			conn = JDBCUtil.getConnection();
			SupplierDao dao = SupplierDao.getInstance();
			Supplier supplier = new Supplier(sNo);
			dao.deleteSupplier(conn, supplier);
			res.sendRedirect(req.getContextPath()+"/client/supplierList.do");
			return null;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}
		return null;
	}

}
