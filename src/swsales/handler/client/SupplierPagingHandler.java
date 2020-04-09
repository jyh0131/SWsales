package swsales.handler.client;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.SupplierDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Paging;
import swsales.model.Supplier;

@SuppressWarnings("serial")
@WebServlet("${pageContext.request.contextPath}/client/supplierList.do")
public class SupplierPagingHandler extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Connection conn = null;
		
		try {
			conn = JDBCUtil.getConnection();
			SupplierDao dao = SupplierDao.getInstance();
			
			int page = 1;

			if (req.getParameter("page") != null) {
				page = Integer.parseInt(req.getParameter("page"));
			}
			
			Paging paging = new Paging();
			paging.setPage(page);
			paging.setTotalCount(351);

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
	}
}
