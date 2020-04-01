package swsales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import swsales.jdbc.JDBCUtil;
import swsales.model.ZipCode;


public class ZipCodeDao {
	private static final ZipCodeDao dao = new ZipCodeDao();

	public static ZipCodeDao getInstance() {
		return dao;
	}

	private ZipCodeDao() {
	}

	public List<ZipCode> selectZipCodeSearch(Connection conn, ZipCode zipcode) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from zip_code where z_doro=? and z_num1 = ? and z_num2= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, zipcode.getzDoro());
			pstmt.setInt(2, zipcode.getzNum1());
			pstmt.setInt(3, zipcode.getzNum2());
			rs = pstmt.executeQuery();
			List<ZipCode> list = new ArrayList<ZipCode>();
			while (rs.next()) {
				list.add(getZipCode(rs));
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private ZipCode getZipCode(ResultSet rs) throws SQLException {
		String zCode = rs.getString("z_code");
		String zSido = rs.getString("z_sido");
		String zSigungu = rs.getString("z_sigungu");
		String zDoro = rs.getString("z_doro");
		int zNum1 = rs.getInt("z_num1");
		int zNum2 = rs.getInt("z_num2");
		return new ZipCode(zCode, zSido, zSigungu, zDoro, zNum1, zNum2);
	}


	public ZipCode selectAddressSearchNumAll(Connection conn, ZipCode zipSearch) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select z_code, z_sido, z_sigungu, z_doro, z_num1, z_num2 from zip_code where z_sido=? and z_doro=? and z_num1=? and z_num2=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, zipSearch.getzSido());
			pstmt.setString(2, zipSearch.getzDoro());
			pstmt.setInt(3, zipSearch.getzNum1());
			pstmt.setInt(4, zipSearch.getzNum2());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return getZipCode(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	public ZipCode selectAddressSearchNumOne(Connection conn, ZipCode zipSearch) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select z_code, z_sido, z_sigungu, z_doro, z_num1, z_num2 from zip_code where z_sido=? and z_doro=? and z_num1=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, zipSearch.getzSido());
			pstmt.setString(2, zipSearch.getzDoro());
			pstmt.setInt(3, zipSearch.getzNum1());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return getZipCode(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

}