package swsales.handler.client;

import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.SupplierDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Paging;
import swsales.model.Supplier;
import swsales.mvc.CommandHandler;

@SuppressWarnings("serial")
@WebServlet("/supplierList.do")
public class SupplierPagingHandler extends HttpServlet implements CommandHandler{
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection conn = null;
		
		try {
			conn = JDBCUtil.getConnection();
			SupplierDao dao = SupplierDao.getInstance();
			
			int page = 1;

			if (req.getParameter("page") != null) {
				page = Integer.parseInt(req.getParameter("page"));
			}
			List<Supplier> last = dao.selectSupplierByAll(conn);
	
			Paging paging = new Paging();
			paging.setPage(page);
			paging.setTotalCount(last.size());

			List<Supplier> list = dao.selectSupplierPaging(conn, page);
			req.setAttribute("list", list);
			req.setAttribute("paging", paging);

			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/client/supplierList.jsp");
			dispatcher.forward(req, res);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}
		return null;
	}
}
