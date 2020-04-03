package swsales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import swsales.jdbc.JDBCUtil;
import swsales.model.Department;
import swsales.model.Employee;


public class EmployeeDao {
	/*** SINGLETON PATTERN *****************************************************************************************/
	private static final EmployeeDao dao = new EmployeeDao();

	public static EmployeeDao getInstance() {
		return dao;
	}

	private EmployeeDao() {
	}
	
	/*** GET *****************************************************************************************/
	//getEmployee
	private Employee getEmployee(ResultSet rs) throws SQLException {
		int empNo = rs.getInt("e_no");
		String empName = rs.getString("e_name");
		Department dNo = new Department(rs.getInt("e_dept"));
		String empTitle = rs.getString("e_title");
		int empManager = rs.getInt("e_manager");
		String empId = rs.getString("e_id");
		String empPass = rs.getString("e_pw");
		String empMail = rs.getString("e_mail");
		return new Employee(empNo, empName, dNo, empTitle, empManager, empId, empPass, empMail);
	}
	
	//getEmployeeJoin
	private Employee getEmployeeJoin(ResultSet rs) throws SQLException {
		int empNo = rs.getInt("e_no");
		String empName = rs.getString("e_name");
		Department dNo = new Department(rs.getInt("d_no"), rs.getString("d_name"), rs.getInt("d_floor"));
		String empTitle = rs.getString("e_title");
		int empManager = rs.getInt("e_manager");
		String empId = rs.getString("e_id");
		String empPass = rs.getString("e_pw");
		String empMail = rs.getString("e_mail");
		return new Employee(empNo, empName, dNo, empTitle, empManager, empId, empPass, empMail);
	}
	
	//getEmpNo
	private Employee getEmpNo(ResultSet rs) throws SQLException {
		int empNo = rs.getInt("e_no");
		return new Employee(empNo);
	}
	
	//getEmpID
	private Employee getEmpID(ResultSet rs) throws SQLException {
		String empID = rs.getString("e_id");
		return new Employee(empID);
	}
	
	//getEmp
	private Employee getEmp(ResultSet rs) throws SQLException {
		int empNo = rs.getInt("e_no");
		String empName = rs.getString("e_name");
		String empTitle = rs.getString("e_title");
		int empManager = rs.getInt("e_manager");
		String empMail = rs.getString("e_mail");
		return new Employee(empNo, empName, empTitle, empManager, empMail);
	}


	//getEmpMail
	private Employee getEmpMail(ResultSet rs) throws SQLException {
		int empNo = rs.getInt("e_no");
		String empName = rs.getString("e_name");
		String empId = rs.getString("e_id");
		String empMail = rs.getString("e_mail");
		return new Employee(empNo, empName, empId, empMail);
	}

	//getEmpInfo
	private String getEmpInfo(ResultSet rs) throws SQLException {
		int no = rs.getInt("e_no");
		String empNo = String.format("EE%04d", no);
		Department dNo = new Department(rs.getInt("d_no"), rs.getString("d_name"));
		String dept = String.format("%s", dNo.getDeptName());
		String empTitle = rs.getString("e_title");
		String total = "("+empNo+")-"+dept+"("+empTitle+")";
		return total;
	}

	
	/***QUERY [select]*****************************************************************************************/
	
	
	//검색 : (기본)all

	public List<Employee> selectEmployeeByAll(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select e.e_no, e.e_name,  e.e_title, e.e_dept, d.d_no, d.d_name, d.d_floor, e.e_manager, e.e_id, e.e_pw, e.e_mail from employee e left join department d on e.e_dept  = d.d_no";
			 pstmt = conn.prepareStatement(sql);
			 rs = pstmt.executeQuery();
			 List<Employee> list = new ArrayList<>();
				while(rs.next()) {
					list.add(getEmployeeJoin(rs));
				}
				return list;
				
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
	
	
	//검색:부서명

	public List<Employee> selectEmployeeListByDeptName(Connection conn, Department dept) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select e.e_no , e.e_name , e.e_title , e.e_manager , e.e_mail from employee e "
		               + "left join department d on e.e_dept = d.d_no where d.d_name =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept.getDeptName());
			rs = pstmt.executeQuery();
			List<Employee> list = new ArrayList<Employee>();
			while(rs.next()) {
				list.add(getEmp(rs));
			}
			return list;
			
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
	
	
	//검색 : 번호

	public Employee selectEmployeeByNo(Connection conn, Employee emp) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select e.e_no, e.e_name,  e.e_title, e.e_dept, d.d_no, d.d_name, d.d_floor, e.e_manager, e.e_id, e.e_pw, e.e_mail from employee e left join department d on e.e_dept  = d.d_no where e.e_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmpNo());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return getEmployeeJoin(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
	
	//검색 : 부서명

	public Employee selectEmployeeByDept(Connection conn, Employee emp) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select e.e_no, e.e_name,  e.e_title, e.e_dept, d.d_no, d.d_name, d.d_floor, e.e_manager, e.e_id, e.e_pw, e.e_mail from employee e left join department d on e.e_dept  = d.d_no where d.d_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getdNo().getDeptName());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return getEmployee(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	//검색 : 마지막번호

	public Employee selectEmployeebyLastNo(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select e_no from employee order by e_no desc limit 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return getEmpNo(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
	
	//로그인

	public Employee loginEmployee(Connection conn, Employee emp) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select e.e_no, e.e_name, e.e_title, e.e_dept, d.d_no, d.d_name, d.d_floor, e.e_manager, e.e_id, e.e_pw, e.e_mail from employee e left join department d on e.e_dept  = d.d_no where e.e_id = ? and e.e_pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getEmpId());
			pstmt.setString(2, emp.getEmpPass());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return getEmployeeJoin(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	//검색 : 아이디

	public Employee selectEmployeeByID(Connection conn, Employee emp) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select e_id from employee where e_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getEmpId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return getEmpID(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}


	
	//검색 : ID찾기

	public Employee selectEmployeeByID2(Connection conn, Employee emp) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select e_id from employee where e_no=? and e_name =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmpNo());
			pstmt.setString(2, emp.getEmpName());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return getEmpID(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	//검색 : 메일일치

	public Employee selectEmployeeByMail(Connection conn, Employee emp) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select e_no, e_name, e_id, e_mail from employee where e_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getEmpId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return getEmpMail(rs);
			}
			return null;
			
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
	
	//검색 : 이름

	public String selectEmployeeName(Connection conn, String name) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select e.e_no, e.e_title, e.e_dept, d.d_no, d.d_name from employee e left join department d on e.e_dept = d.d_no where e.e_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return getEmpInfo(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
	
	//검색 : 번호
	
	public int selectEmployeeNo(Connection conn, String name) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select e_no from employee where e_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
	
	/***QUERY [insert/update/delete]****************************************************************************************/
	
	//insert

	public void insertEmployee(Connection conn, Employee emp) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into employee (e_no, e_name, e_dept, e_title, e_manager, e_id, e_pw, e_mail) value (null,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getEmpName());
			pstmt.setInt(2, emp.getdNo().getDeptNo());
			pstmt.setString(3, emp.getEmpTitle());
			pstmt.setInt(4, emp.getEmpManager());
			pstmt.setString(5, emp.getEmpId());
			pstmt.setString(6, emp.getEmpPass());
			pstmt.setString(7, emp.getEmpMail());
			pstmt.executeUpdate();
			
		} finally {
			JDBCUtil.close(pstmt);
		}
	}

	//update

	public void updateEmployee(Connection conn, Employee emp) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update employee set e_name = ?, e_dept = ?, e_title = ?, e_manager = ?, e_id = ?, e_pw = ?, e_mail = ? where e_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getEmpName());
			pstmt.setInt(2, emp.getdNo().getDeptNo());
			pstmt.setString(3, emp.getEmpTitle());
			pstmt.setInt(4, emp.getEmpManager());
			pstmt.setString(5, emp.getEmpId());
			pstmt.setString(6, emp.getEmpPass());
			pstmt.setString(7, emp.getEmpMail());
			pstmt.setInt(8, emp.getEmpNo());
			pstmt.executeUpdate();
			
		} finally {
			JDBCUtil.close(pstmt);
		}
	}
	
	//update2

	public void updateEmpPassword(Connection conn, Employee emp) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update employee set e_pw = ? where e_no = ? and e_name = ? and e_id = ? and e_mail = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getEmpPass());
			pstmt.setInt(2, emp.getEmpNo());
			pstmt.setString(3, emp.getEmpName());
			pstmt.setString(4, emp.getEmpId());
			pstmt.setString(5, emp.getEmpMail());
			pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}

	//delete

	public void deleteEmployee(Connection conn, Employee emp) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from employee where e_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmpNo());
			pstmt.executeUpdate();
			
		} finally {
			JDBCUtil.close(pstmt);
		}
	}

}
