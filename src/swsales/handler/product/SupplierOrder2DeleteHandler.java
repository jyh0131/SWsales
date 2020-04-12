package swsales.handler.product;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.IQDao;
import swsales.dao.SupplierPurchaseDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.InventoryQuantity;
import swsales.model.Product;
import swsales.model.SupplierPurchase;
import swsales.mvc.CommandHandler;

public class SupplierOrder2DeleteHandler implements CommandHandler{
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		int spNo = Integer.parseInt(req.getParameter("no"));
		//System.out.println(spNo);
		Connection conn = null;
		
		try {
			conn = JDBCUtil.getConnection();
			SupplierPurchaseDao dao = SupplierPurchaseDao.getInstance();
			
			SupplierPurchase searchSp = dao.selectSupplierPurchaseByNo(conn, spNo);
			int pNo = searchSp.getSpPno().getpNo();
			int delQty = searchSp.getSpQty();
			
			//System.out.println(pNo);
			//System.out.println(delQty);
			
			
			SupplierPurchase sp = new SupplierPurchase(spNo);
			dao.deleteSupplierPurchase(conn, sp);
			
			//매입이력 삭제와 동시에 재고수량도 수정
			IQDao dao2 = IQDao.getInstance();
			InventoryQuantity allIq = dao2.selectIqQtyByPno(conn, pNo);
			int allQty = allIq.getIqQty();
			
			Product upPno = new Product(pNo);
			int total = allQty - delQty;
			InventoryQuantity upiq = new InventoryQuantity(upPno, total);
			dao2.updateIQ(conn, upiq);
			
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