package swsales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import swsales.jdbc.JDBCUtil;
import swsales.model.Total;

public class TotalDao {
	private static final TotalDao dao = new TotalDao();

	public static TotalDao getInstance() {
		return dao;
	}

	private TotalDao() {
	}
	
	public Total selectTotalSales(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select SUM(o.o_qty * p.p_price) " + 
					"  from `order` o natural join product p " + 
					" where p.p_no = o.o_pno";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new Total(rs.getLong(1));
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	public Total selectTotalUncollected(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select SUM(o.o_qty * p.p_price)\r\n" + 
					"  from `order` o natural join product p\r\n" + 
					" where p.p_no = o.o_pno and o.o_dps = '0'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new Total(rs.getLong(1));
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	public Total selectSalesProfit(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select	SUM(case when (o.o_qty >= 50 and o.o_qty < 100) then o.o_qty*p.p_price*0.9-(o.o_qty*p.p_cost) " + 
					"			  when o.o_qty >= 100 then o.o_qty*p.p_price*0.85-(o.o_qty*p.p_cost) " + 
					"		 else (o.o_qty*p.p_price)-(o.o_qty*p.p_cost)	end) as 판매이윤 " + 
					"  from product p natural join `order` o " + 
					" where p.p_no = o.o_pno";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new Total(rs.getLong(1));
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
	
	public Total selectDeliveryAmount(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select SUM(o.o_qty*p.p_price+o.o_qty*p.p_price*0.1) " + 
					"  from `order` o natural join product p " + 
					" where p.p_no = o.o_pno";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new Total(rs.getLong(1));
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
}
