package swsales.handler.main;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.EmployeeDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Employee;
import swsales.mvc.CommandHandler;

public class SearchIdHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			req.setAttribute("error", 0);
			return "/WEB-INF/view/main/searchIdForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")) {
			String no = req.getParameter("empNo");
			String empName = req.getParameter("empName");
			int empNo = Integer.parseInt(no.substring(2));
			
			Connection conn = null;
			
			try {
				conn = JDBCUtil.getConnection();
				EmployeeDao dao = EmployeeDao.getInstance();
				Employee emp = new Employee(empNo, empName);
				Employee employee = dao.selectEmployeeByID2(conn, emp);
				if(employee == null) {
					req.setAttribute("error", 1);
					
					return "/WEB-INF/view/main/searchIdForm.jsp"; 
				}
				req.setAttribute("emp", employee);
				req.setAttribute("error", 0);
				return "/WEB-INF/view/main/searchPwForm.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}
