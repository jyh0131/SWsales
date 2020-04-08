package swsales.handler.main;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.DepartmentDao;
import swsales.dao.EmployeeDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Department;
import swsales.model.Employee;
import swsales.mvc.CommandHandler;

public class ProfileHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			String empId = req.getParameter("id");
			
			Connection conn = null;
			try {
				conn = JDBCUtil.getConnection();
				EmployeeDao dao = EmployeeDao.getInstance();				
				Employee emp = dao.selectEmployeeProfile(conn, empId);
				
				req.setAttribute("emp", emp);
				return "/WEB-INF/view/main/profileForm.jsp";
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn);
			}
		}else if(req.getMethod().equalsIgnoreCase("post")) {
			int empNo = Integer.parseInt(req.getParameter("no"));
			String empName = req.getParameter("empName");
			String deptName = req.getParameter("deptName");
			String empTitle = req.getParameter("empTitle");
			String empId = req.getParameter("empId");
			String empPass = req.getParameter("password");
			String empMail = req.getParameter("empMail");
			
			Connection conn = null;
			try {
				conn = JDBCUtil.getConnection();
				EmployeeDao dao = EmployeeDao.getInstance();
				DepartmentDao dDao = DepartmentDao.getInstance();
				Department dept = new Department(deptName);
				Department dNo = dDao.selectDepartmentByName(conn, dept);
				
				if(empTitle.equals("부장")||empTitle.equals("차장")||empTitle.equals("과장")) {
					int empManager = 1;
					Employee employee = new Employee(empName, dNo, empTitle, empManager, empId, empPass, empMail);
					employee.setEmpNo(empNo);
					dao.updateEmployee(conn, employee);
					res.sendRedirect(req.getContextPath()+"/main/main.do");
					
				}else if(empTitle.equals("대리")||empTitle.equals("사원")||empTitle.equals("인턴")){
					int empManager = 2;
					Employee employee = new Employee(empName, dNo, empTitle, empManager, empId, empPass, empMail);
					employee.setEmpNo(empNo);
					dao.updateEmployee(conn, employee);
					res.sendRedirect(req.getContextPath()+"/main/main.do");
				}
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}
