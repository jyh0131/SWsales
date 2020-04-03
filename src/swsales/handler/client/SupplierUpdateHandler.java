package swsales.handler.client;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.SupplierDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Supplier;
import swsales.mvc.CommandHandler;

public class SupplierUpdateHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			int sNo = Integer.parseInt(req.getParameter("no"));
			
			Connection conn = null;
			try {
				conn = JDBCUtil.getConnection();
				SupplierDao dao = SupplierDao.getInstance();
				Supplier supplier = new Supplier(sNo);
				Supplier sup = dao.selectSupplierByNo(conn, supplier);
				req.setAttribute("supplier", sup);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn);
			}
			return "/WEB-INF/view/client/supplierModForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")) {
			int sNo = Integer.parseInt(req.getParameter("sNo"));
			String sName = req.getParameter("sName");
			String sBln = req.getParameter("sBln");
			String sAddress = req.getParameter("sAddress");
			String sTel = req.getParameter("sTel");
			String sFax = req.getParameter("sFax");
			
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				SupplierDao dao = SupplierDao.getInstance();
				Supplier supplier = new Supplier(sNo, sName, sBln, sAddress, sTel, sFax);
				dao.updateSupplier(conn, supplier);
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
