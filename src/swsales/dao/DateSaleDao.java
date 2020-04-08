package swsales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import swsales.jdbc.JDBCUtil;
import swsales.model.DateSale;

public class DateSaleDao {
	private static final DateSaleDao dao = new DateSaleDao();

	public static DateSaleDao getInstance() {
		return dao;
	}

	private DateSaleDao() {
	}

	public List<DateSale> selectDateSaleByAll(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select	o.o_no as 주문번호, " + 
					"		c.c_name as 고객상호명, " + 
					"		p.p_name as 품목명, " + 
					"		o.o_qty as 주문수량, " + 
					"		(case o.o_dps when '0' then '미입금'  when '1' then '완료'	end) as 입금여부, " + 
					"		o.o_date as 주문일자 " + 
					"  from `order` o natural join client c natural join product p " + 
					" where o.o_cno = c.c_no and p.p_no = o.o_pno";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<DateSale> list = new ArrayList<DateSale>();
			while(rs.next()) {
				DateSale dateSale = new DateSale();
				dateSale.setO_no(rs.getInt(1));
				dateSale.setC_name(rs.getString(2));
				dateSale.setP_name(rs.getString(3));
				dateSale.setO_qty(rs.getInt(4));
				dateSale.setO_dps(rs.getString(5));
				dateSale.setO_date(rs.getDate(6));
				
				list.add(dateSale);
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	public List<DateSale> selectDateSaleByDate(Connection conn, DateSale ds) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select	o.o_no as 주문번호, " + 
					"		c.c_name as 고객상호명, " + 
					"		p.p_name as 품목명, " + 
					"		o.o_qty as 주문수량, " + 
					"		(case o.o_dps when '0' then '미입금'  when '1' then '완료'	end) as 입금여부, " + 
					"		o.o_date as 주문일자 " + 
					"  from `order` o natural join client c natural join product p " + 
					" where o.o_cno = c.c_no and p.p_no = o.o_pno and DATE(o_date) between ? and ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setDate(1, ds.getStart_o_date());
			pstmt.setDate(2, ds.getEnd_o_date());
			rs = pstmt.executeQuery();
			List<DateSale> list = new ArrayList<DateSale>();
			while(rs.next()) {
				DateSale dateSale = new DateSale();
				dateSale.setO_no(rs.getInt(1));
				dateSale.setC_name(rs.getString(2));
				dateSale.setP_name(rs.getString(3));
				dateSale.setO_qty(rs.getInt(4));
				dateSale.setO_dps(rs.getString(5));
				dateSale.setO_date(rs.getDate(6));
				
				list.add(dateSale);
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
}
