package swsales.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	public static void close(PreparedStatement pstmt) {
		if(pstmt !=null) {
			try {
				pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(CallableStatement cstmt) {
		if(cstmt !=null) {
			try {
				cstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Statement stmt) {
		if(stmt !=null) {
			try {
				stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs) {
		if(rs !=null) {
			try {
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection conn) {
		if(conn !=null) {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Connection getConnection() throws SQLException{
		Connection conn = null;
		String jdbcDriver = "jdbc:apache:commons:dbcp:yi_java3st_1team";
	 	conn = DriverManager.getConnection(jdbcDriver);
	 	return conn;
	}
}
