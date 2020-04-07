package swsales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import swsales.jdbc.JDBCUtil;
import swsales.model.SWSale;

public class SWSaleDao {
	private static final SWSaleDao dao = new SWSaleDao();

	public static SWSaleDao getInstance() {
		return dao;
	}

	private SWSaleDao() {
	}

	public List<SWSale> selectSWSaleByAll(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select	p.p_name as 품목명, " + 
					"		cate.cate_name as 분류, " + 
					"		s.s_name as 공급회사명, " + 
					"		o.o_qty*p.p_cost as 공급금액, " + 
					"		o.o_qty*p.p_price as 판매금액, " + 
					"		(case when (o.o_qty >= 50 and o.o_qty < 100) then o.o_qty*p.p_price*0.1 " + 
					"			  when o.o_qty >= 100 then o.o_qty*p.p_price*0.15 " + 
					"		 else '0'	end) as 할인금액, " + 
					"		(case when (o.o_qty >= 50 and o.o_qty < 100) then o.o_qty*p.p_price*0.9-(o.o_qty*p.p_cost) " + 
					"			  when o.o_qty >= 100 then o.o_qty*p.p_price*0.85-(o.o_qty*p.p_cost) " + 
					"		 else (o.o_qty*p.p_price)-(o.o_qty*p.p_cost)	end) as 판매이윤 " + 
					"  from product p natural join `order` o natural join supplier s natural join category cate " + 
					" where p.p_no = o.o_pno and cate.cate_no = p.p_cate and s.s_no = p.p_sno;";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<SWSale> list = new ArrayList<SWSale>();
			while(rs.next()) {
				SWSale swSale = new SWSale();
				swSale.setP_name(rs.getString(1));
				swSale.setCate_name(rs.getString(2));
				swSale.setS_name(rs.getString(3));
				swSale.setSupplyAmount(rs.getInt(4));
				swSale.setSalesAmount(rs.getInt(5));
				swSale.setDiscount(rs.getInt(6));
				swSale.setSalesProfit(rs.getInt(7));
				
				list.add(swSale);
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	public List<SWSale> selectSWSaleByPName(Connection conn, SWSale sw) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select	p.p_name as 품목명, " + 
					"			cate.cate_name as 분류, " + 
					"			s.s_name as 공급회사명, " + 
					"			o.o_qty*p.p_cost as 공급금액, " + 
					"			o.o_qty*p.p_price as 판매금액, " + 
					"			(case when (o.o_qty >= 50 and o.o_qty < 100) then o.o_qty*p.p_price*0.1 " + 
					"				  when o.o_qty >= 100 then o.o_qty*p.p_price*0.15 " + 
					"			 else '0'	end) as 할인금액, " + 
					"			(case when (o.o_qty >= 50 and o.o_qty < 100) then o.o_qty*p.p_price*0.9-(o.o_qty*p.p_cost) " + 
					"				  when o.o_qty >= 100 then o.o_qty*p.p_price*0.85-(o.o_qty*p.p_cost) " + 
					"			 else (o.o_qty*p.p_price)-(o.o_qty*p.p_cost)	end) as 판매이윤 " + 
					" 	 from product p natural join `order` o natural join supplier s natural join category cate " + 
					"	 where p.p_no = o.o_pno and cate.cate_no = p.p_cate and s.s_no = p.p_sno and p.p_name = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, sw.getP_name());
			rs = pstmt.executeQuery();
			List<SWSale> list = new ArrayList<SWSale>();
			while(rs.next()) {
				SWSale swSale = new SWSale();
				swSale.setP_name(rs.getString(1));
				swSale.setCate_name(rs.getString(2));
				swSale.setS_name(rs.getString(3));
				swSale.setSupplyAmount(rs.getInt(4));
				swSale.setSalesAmount(rs.getInt(5));
				swSale.setDiscount(rs.getInt(6));
				swSale.setSalesProfit(rs.getInt(7));
				
				list.add(swSale);
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
}
