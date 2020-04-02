package swsales.handler.client;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.SupplierDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Supplier;
import swsales.mvc.CommandHandler;

public class SupplierInsertHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			Connection conn = null;
			try {
				conn = JDBCUtil.getConnection();
				SupplierDao dao = SupplierDao.getInstance();
				Supplier supplier = dao.selectSuppplierLastData(conn);
				req.setAttribute("supplier", supplier);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
			return "/WEB-INF/view/client/supplierRegForm.jsp";
		}
		return null;
	}

}
