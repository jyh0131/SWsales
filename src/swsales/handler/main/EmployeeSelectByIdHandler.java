package swsales.handler.main;

import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import swsales.dao.EmployeeDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Employee;
import swsales.mvc.CommandHandler;

public class EmployeeSelectByIdHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			Connection conn = null;
			String empId = req.getParameter("empId");
			Employee emp = new Employee(empId);
			try {
				conn = JDBCUtil.getConnection();
				EmployeeDao dao = EmployeeDao.getInstance();
				Employee employee = dao.selectEmployeeByID(conn, emp);
				if(employee != null) {
					Map<String, String> map = new HashMap<String, String>();
					map.put("result", "duplicate");
					
					ObjectMapper om = new ObjectMapper();
					String json = om.writeValueAsString(map);
					
					res.setContentType("application/json;charset=UTF-8");
					PrintWriter pw = res.getWriter();
					pw.print(json);
					pw.flush();
				}else {
					Map<String, String> map = new HashMap<>();
					map.put("result", "empty");
					
					ObjectMapper om = new ObjectMapper();
					String json = om.writeValueAsString(map);
					
					res.setContentType("application/json;charset=UTF-8");
					PrintWriter pw = res.getWriter();
					pw.print(json);
					pw.flush();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}
