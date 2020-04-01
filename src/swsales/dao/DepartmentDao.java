package swsales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import swsales.jdbc.JDBCUtil;
import swsales.model.Department;


public class DepartmentDao {
	/*** SINGLETON PATTERN *****************************************************************************************/
	private static final DepartmentDao dao = new DepartmentDao();

	public static DepartmentDao getInstance() {
		return dao;
	}

	private DepartmentDao() {
	}
	
	/*** GET *****************************************************************************************/
	//getDepartment
	private Department getDepartment(ResultSet rs) throws SQLException {
		int deptNo = rs.getInt("d_no");
		String deptName = rs.getString("d_name");
		int floor = rs.getInt("d_floor");
		return new Department(deptNo, deptName, floor);
	}

	
	/***QUERY [select] 
	 * @throws SQLException ****************************************************************************************/
	
	public List<Department> selectDepartmentByAll(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select d_no, d_name, d_floor from department";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Department> list = new ArrayList<>();
			while(rs.next()) {
				list.add(getDepartment(rs));
			}
			return list;
			
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	public Department selectDepartmentByNo(Connection conn, Department dept) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select d_no, d_name, d_floor from department where d_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getDeptNo());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return getDepartment(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
	
	/***QUERY [insert/update/delete] 
	 * @throws SQLException ****************************************************************************************/
	
	public void insertDepartment(Connection conn, Department dept) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into department (d_no, d_name, d_floor) value (null, ?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept.getDeptName());
			pstmt.setInt(2, dept.getFloor());
			pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}

	public void updateDepartment(Connection conn, Department dept) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update department set d_name = ?, d_floor = ? where d_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept.getDeptName());
			pstmt.setInt(2, dept.getFloor());
			pstmt.setInt(3, dept.getDeptNo());
			pstmt.executeUpdate();
			
		} finally {
			JDBCUtil.close(pstmt);
		}
	}

	public void deleteDepartment(Connection conn, Department dept) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from department where d_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dept.getDeptNo());
			pstmt.executeUpdate();
			
		} finally {
			JDBCUtil.close(pstmt);
		}
	}

}
