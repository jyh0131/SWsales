package swsales.handler.product;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.ProductDao;
import swsales.dao.SupplierDao;
import swsales.dao.SupplierOrderDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Product;
import swsales.model.Supplier;
import swsales.model.SupplierOrder;
import swsales.mvc.CommandHandler;

public class SupplierOrder1InsertHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			Connection conn = null;
			try {
				conn = JDBCUtil.getConnection();
				SupplierOrderDao dao = SupplierOrderDao.getInstance();
				
				SupplierOrder lastNo = dao.selectSupplierOrderLastDate(conn);
				req.setAttribute("SupplierOrder", lastNo);
				
				//품목명 가져오기
				ProductDao dao2 = ProductDao.getInstance();
				List<Product> list = dao2.selectProductByAll(conn);
				req.setAttribute("list", list);
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}			
			return "/WEB-INF/view/product/supplierOrderRegForm1.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")) {
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				
				SupplierOrderDao dao = SupplierOrderDao.getInstance();
				
				//품목명
				Product pNo = new Product(req.getParameter("soPname"));

				//회사명 - 번호
				Supplier sName = new Supplier(req.getParameter("soSname"));
				SupplierDao dao3 = SupplierDao.getInstance();
				Supplier sNo = dao3.selectSupplierByName(conn, sName);
				
				Product soPcost = new Product(Integer.parseInt(req.getParameter("soPcost")));
				int soQty = Integer.parseInt((req.getParameter("soQty")));
				
				String sDate = req.getParameter("soDate");
				SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
				Date soDate = dt.parse(sDate);
				
				

				SupplierOrder so = new SupplierOrder(0, pNo, sNo, soPcost, soQty, soDate); // 번호오토, 번호, 번호, 가격, 수량, 날짜
				//System.out.println(so);
				dao.insertSupplierOrder(conn, so);
				res.sendRedirect(req.getContextPath()+"/product/supplierOrderList1.do");
				return null;
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}
