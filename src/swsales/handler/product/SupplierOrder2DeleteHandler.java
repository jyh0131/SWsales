package swsales.handler.product;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.SupplierPurchaseDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.SupplierPurchase;
import swsales.mvc.CommandHandler;

public class SupplierOrder2DeleteHandler implements CommandHandler{
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		int spNo = Integer.parseInt(req.getParameter("no"));
		Connection conn = null;
		
		try {
			conn = JDBCUtil.getConnection();
			SupplierPurchaseDao dao = SupplierPurchaseDao.getInstance();
			SupplierPurchase sp = new SupplierPurchase(spNo);
			dao.deleteSupplierPurchase(conn, sp);
			
			
			//매입이력 삭제와 동시에 재고수량도 삭제
/*			IQDao dao2 = IQDao.getInstance();
			InventoryQuantity iq = new InventoryQuantity(iqNo, iqPno, iqQty)
			dao2.deleteIQ(conn, iq);*/
			
			res.sendRedirect(req.getContextPath()+"/product/supplierOrderList2.do");
			return null;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(conn);
		}
		return null;
	}
}