package swsales.handler.vMgr;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.ClientSaleDao;
import swsales.dao.SWSaleDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.ClientSale;
import swsales.model.SWSale;
import swsales.mvc.CommandHandler;

public class SWSaleSelectByPNameHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("post")) {
			Connection conn = null;
			
			try {
				String swSearch = req.getParameter("swSearch");
				conn = JDBCUtil.getConnection();
				SWSaleDao dao = SWSaleDao.getInstance();
				SWSale selectSW = new SWSale(swSearch);
				List<SWSale> list = dao.selectSWSaleByPName(conn, selectSW);
				
				req.setAttribute("list", list);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
		}
		return "/WEB-INF/view/vMgr/swSaleList.jsp";
	}

}
