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
import swsales.jdbc.JDBCUtil;
import swsales.model.Category;
import swsales.model.Product;
import swsales.model.Supplier;
import swsales.mvc.CommandHandler;

public class ProductUpdateHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			int pNo = Integer.parseInt(req.getParameter("pNo"));
			
			Connection conn = null;
			try {
				conn = JDBCUtil.getConnection();
				ProductDao dao = ProductDao.getInstance();
				Product pro = dao.selectProductByNo(conn, pNo);
				req.setAttribute("product", pro);
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
			return "/WEB-INF/view/product/productModForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")) {
			
			String uploadPath = req.getRealPath("productIMG");
			File dir = new File(uploadPath);
			
			if(dir.exists() == false) {
				dir.mkdir();
			}
			
			int size = 1024*1024*10;
			MultipartRequest multi = new MultipartRequest(req, uploadPath, size, "UTF-8", new DefaultFileRenamePolicy());
			
			int pNo = Integer.parseInt(multi.getParameter("no"));
			Category pCate = new Category(Integer.parseInt(multi.getParameter("pCate")));
			String pName = multi.getParameter("pName");
			int pCost = Integer.parseInt(multi.getParameter("pCost"));
			int pPrice = Integer.parseInt(multi.getParameter("pPrice"));
			
			
			Supplier pSno = new Supplier(Integer.parseInt(multi.getParameter("pSno")));
			
			int pQty = Integer.parseInt(multi.getParameter("pQty"));
			
			String sDate = multi.getParameter("pDate");
			SimpleDateFormat dt = new SimpleDateFormat("yyyyy-MM-dd");
			Date pDate = dt.parse(sDate);
			
			String pPicPath = multi.getFilesystemName("pPic");
			System.out.println(pNo); //96
			System.out.println(pCate); //
			System.out.println(pName); //96
			System.out.println(pCost); //96
			System.out.println(pPrice); //96
			System.out.println(pSno); //96
			System.out.println(pQty); //96
			System.out.println(pDate); //96
			System.out.println(pPicPath); //96
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				ProductDao dao = ProductDao.getInstance();
				Product product = new Product(pNo, pCate, pName, pCost, pPrice, pSno, pQty, pDate, pPicPath);
				dao.updateProduct(conn, product);
				res.sendRedirect(req.getContextPath()+"/product/productList2.do");
				return null;
			} catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}
