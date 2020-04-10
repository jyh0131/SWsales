package swsales.handler.vMgr;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.SWTotalSaleDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.SWTotalSale;
import swsales.mvc.CommandHandler;

public class SWTotalSaleSelectByPNameHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("post")) {
			Connection conn = null;
			
			try {
				String swTotalSearch = req.getParameter("swTotalSearch");
				conn = JDBCUtil.getConnection();
				SWTotalSaleDao dao = SWTotalSaleDao.getInstance();
				SWTotalSale selectSWTotal = new SWTotalSale(swTotalSearch);
				List<SWTotalSale> list = dao.selectSWTotalSaleByPName(conn, selectSWTotal);
				
				req.setAttribute("list", list);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
		}
		return "/WEB-INF/view/vMgr/swTotalSaleList.jsp";
	}
	
}
