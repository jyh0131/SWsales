package swsales.handler.main;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import swsales.dao.EmployeeDao;
import swsales.jdbc.JDBCUtil;
import swsales.model.Employee;
import swsales.mvc.CommandHandler;

public class JoinHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			Connection conn = null;
			try {
				conn = JDBCUtil.getConnection();
				EmployeeDao dao = EmployeeDao.getInstance();
				Employee emp = dao.selectEmployeebyLastNo(conn);
				if(emp.getEmpNo()+1 < 10) {
					req.setAttribute("empNo", "EE000"+(emp.getEmpNo()+1));
				}else if(emp.getEmpNo()+1 > 9 && emp.getEmpNo() < 100) {
					req.setAttribute("empNo", "EE00"+(emp.getEmpNo()+1));
				}
				return "/WEB-INF/view/main/joinForm.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}
