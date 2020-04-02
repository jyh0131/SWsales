package swsales.handler.client;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.SupplierDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Supplier;
import swsales.mvc.CommandHandler;

public class SupplierSelectHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("post")) {
			String selSearch = req.getParameter("selSearch");
			String search = req.getParameter("search");
			
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				SupplierDao dao = SupplierDao.getInstance();
				if(selSearch.equals("sName")) {
					Supplier selectSupplier = new Supplier(search, null, null);
					List<Supplier> list = dao.selectSupplierListByName(conn, selectSupplier);
					req.setAttribute("list", list);
				}else if(selSearch.equals("sBln")) {
					Supplier selectSupplier = new Supplier(null, search, null);
					List<Supplier> list = dao.selectSupplierListByBln(conn, selectSupplier);
					req.setAttribute("list", list);
				}else if(selSearch.equals("sTel")) {
					Supplier selectSupplier = new Supplier(null, null, search);
					List<Supplier> list = dao.selectSupplierListByTel(conn, selectSupplier);
					req.setAttribute("list", list);
				}
				return "/WEB-INF/view/client/supplierList.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}
