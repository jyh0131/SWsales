package swsales.handler.main;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import swsales.dao.EmployeeDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Employee;
import swsales.mvc.CommandHandler;

public class LoginHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			return "/WEB-INF/view/main/loginForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")) {
			String id = req.getParameter("id");
			String password = req.getParameter("password");
			
			Connection conn = null;
			try {
				conn = JDBCUtil.getConnection();
				EmployeeDao dao = EmployeeDao.getInstance();
				Employee emp = new Employee(id, password);
				Employee employ = dao.selectEmployeeByPW(conn, emp); 
				
				if(employ == null) {
					req.setAttribute("error", 1);
					
					return "/WEB-INF/view/main/loginForm.jsp";
				}else if(!employ.getEmpPass().equals(password)) {
					req.setAttribute("error", 2);
					
					return "/WEB-INF/view/main/loginForm.jsp";
				}
				Employee employee = dao.loginEmployee(conn, emp);
				if(employee.getEmpManager() == 1) { //관리자 로그인
					HttpSession session = req.getSession();
					session.setAttribute("Auth", employee);
					
					res.sendRedirect(req.getContextPath()+"/main/main.do");
					return null;
				}else { // 일반직원 로그인
					HttpSession session = req.getSession();
					session.setAttribute("Auth", employee);
					
					res.sendRedirect(req.getContextPath()+"/main/main.do");
					return null;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn);
			}
			return null;
		}
		return null;
		
	}

}
