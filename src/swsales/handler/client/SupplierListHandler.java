package swsales.handler.client;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.SupplierDao;
import swsales.jdbc.JDBCUtil;
import swsales.mvc.CommandHandler;

public class SupplierListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			SupplierDao dao = SupplierDao.getInstance();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
		return null;
	}

}
