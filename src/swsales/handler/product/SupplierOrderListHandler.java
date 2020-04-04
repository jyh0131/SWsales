package swsales.handler.product;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.SupplierOrderDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.SupplierOrder;
import swsales.mvc.CommandHandler;

public class SupplierOrderListHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			SupplierOrderDao dao = SupplierOrderDao.getInstance();
			List<SupplierOrder> list = dao.selectSupplierOrderByAll(conn);
			req.setAttribute("list", list);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn);
		}
		return "/WEB-INF/view/product/supplierOrderList.jsp";
	}

}
