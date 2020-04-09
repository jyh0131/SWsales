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
				Supplier supplier = dao.selectSupplierLastData(conn);
				req.setAttribute("supplier", supplier);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
			return "/WEB-INF/view/client/supplierRegForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")) {
			String sName = req.getParameter("sName");
			String sBln = req.getParameter("sBln");
			String sAddress = req.getParameter("sAddress");
			String sTel = req.getParameter("sTel");
			String sFax = req.getParameter("sFax");
			
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				SupplierDao dao = SupplierDao.getInstance();
				Supplier supplier = new Supplier(0, sName, sBln, sAddress, sTel, sFax);
				dao.insertSupplier(conn, supplier);
				res.sendRedirect(req.getContextPath()+"/client/supplierList.do");
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}
