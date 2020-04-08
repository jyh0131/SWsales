package swsales.handler.product;

import java.io.File;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import swsales.dao.ProductDao;
import swsales.dao.SupplierDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Category;
import swsales.model.Product;
import swsales.model.Supplier;
import swsales.mvc.CommandHandler;

public class ProductInsertHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			Connection conn = null;
			try {
				conn = JDBCUtil.getConnection();
				ProductDao dao = ProductDao.getInstance();
				
				Product lastNo = dao.selectProductLastData(conn);
				req.setAttribute("product", lastNo);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
			return "/WEB-INF/view/product/productRegForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")) {
			
			String uploadPath = req.getRealPath("productIMG");
			File dir = new File(uploadPath);
			
			if(dir.exists() == false) {
				dir.mkdir();
			}
			
			int size = 1024*1024*10;
			
			MultipartRequest multi = new MultipartRequest(req, uploadPath, size, "UTF-8", new DefaultFileRenamePolicy());
			
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();


				ProductDao dao = ProductDao.getInstance();
				
				int pNo = Integer.parseInt(multi.getParameter("pNo"));
				Category pCate = new Category(Integer.parseInt(multi.getParameter("pCate")));
				String pName = multi.getParameter("pName");
				int pCost = Integer.parseInt(multi.getParameter("pCost"));
				int pPrice = Integer.parseInt(multi.getParameter("pPrice"));
				
				Supplier sName = new Supplier(multi.getParameter("pSno"));
				SupplierDao dao1 = SupplierDao.getInstance();
				Supplier pSno = dao1.selectSupplierByName(conn, sName);

				
				int pQty = Integer.parseInt(multi.getParameter("pQty"));
				
				String sDate = multi.getParameter("pDate");
				SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
				Date pDate = dt.parse(sDate);
				
				String pPicPath = multi.getFilesystemName("pPic");
				


				Product product = new Product(pNo, pCate, pName, pCost, pPrice, pSno, pQty, pDate, pPicPath);
			
				dao.insertProduct(conn, product);
				res.sendRedirect(req.getContextPath()+"/product/productList2.do");
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
