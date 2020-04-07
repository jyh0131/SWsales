package swsales.handler.product;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.SupplierOrderDao;
import swsales.dao.SupplierPurchaseDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.SupplierOrder;
import swsales.model.SupplierPurchase;
import swsales.mvc.CommandHandler;

public class SupplierOrder2InsertHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			Connection conn = null;
			try {
				conn = JDBCUtil.getConnection();
				SupplierPurchaseDao dao = SupplierPurchaseDao.getInstance();
				
				SupplierPurchase lastNo = dao.selectSupplierPurchaseLastDate(conn);
				req.setAttribute("SupplierPurchase", lastNo);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}				
			return "/WEB-INF/view/product/supplierOrderRegForm2.jsp";
		}
		return null;
	}

}
