package swsales.handler.client;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.SupplierDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Supplier;
import swsales.mvc.CommandHandler;

public class SupplierListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			SupplierDao dao = SupplierDao.getInstance();
			List<Supplier> list = dao.selectSupplierByAll(conn);
			req.setAttribute("list", list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn);
		}
		return "/WEB-INF/view/client/supplyList.jsp";
	}

}
