package swsales.handler.product;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.SupplierOrderDao;
import swsales.dao.SupplierPurchaseDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.SupplierOrder;
import swsales.model.SupplierPurchase;
import swsales.mvc.CommandHandler;

public class SupplierOrder2ListHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			SupplierPurchaseDao dao = SupplierPurchaseDao.getInstance();
			List<SupplierPurchase> list = dao.selectSupplierPurchaseByAll(conn);
			req.setAttribute("list", list);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(conn);
		}
		return "/WEB-INF/view/product/supplierOrderList2.jsp";
	}

}