package swsales.handler.product;

import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import swsales.dao.ProductDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Product;
import swsales.mvc.CommandHandler;

public class ProductSelectByNoHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			Connection conn = null;
			//int pNo = Integer.parseInt(req.getParameter("soPname"));
			String str = req.getParameter("pInfo");
			String[] arr = str.split("/");
			String no = arr[0];
			int pNo = Integer.parseInt(no);
			
			Product pro = new Product(pNo);
			
			try {
				conn = JDBCUtil.getConnection();
				ProductDao dao =ProductDao.getInstance();
				Product product = dao.selectProductByNo(conn, pNo);
				if(product != null) {
					Map<String, String> map = new HashMap<>();
					map.put("result", "success");
					
					ObjectMapper om = new ObjectMapper();
					String json = om.writeValueAsString(map);
					
					res.setContentType("application/json;charset=UTF-8");
					PrintWriter pw = res.getWriter();
					pw.print(json);
					pw.flush();
				}else {
					Map<String, String> map = new HashMap<>();
					map.put("result", "fail");
					
					ObjectMapper om = new ObjectMapper();
					String json = om.writeValueAsString(map);
					
					res.setContentType("application/json;charset=UTF-8");
					PrintWriter pw = res.getWriter();
					pw.print(json);
					pw.flush();
				}				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}
