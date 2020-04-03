package swsales.handler.client;

import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import swsales.dao.ClientDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Client;
import swsales.mvc.CommandHandler;

public class ClientSelectByNameHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			Connection conn = null;
			String cName = req.getParameter("cName");
			Client cli = new Client(cName);
			try {
				conn = JDBCUtil.getConnection();
				ClientDao dao = ClientDao.getInstance();
				Client client = dao.selectClientByName(conn, cli);
				if(client != null) {
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
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}
