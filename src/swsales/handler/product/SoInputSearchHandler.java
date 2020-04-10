package swsales.handler.product;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.jdbc.JDBCUtil;
import swsales.mvc.CommandHandler;

public class SoInputSearchHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("post")) {
			int pNo = Integer.parseInt(req.getParameter("soPname"));
			
			Connection conn = null;
			
			try {
				
				return "/WEB-INF/view/order/supplierOrderRegForm1.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}