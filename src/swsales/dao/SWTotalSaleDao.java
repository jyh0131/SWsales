package swsales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import swsales.jdbc.JDBCUtil;
import swsales.model.SWTotalSale;

public class SWTotalSaleDao {
	private static final SWTotalSaleDao dao = new SWTotalSaleDao();

	public static SWTotalSaleDao getInstance() {
		return dao;
	}

	private SWTotalSaleDao() {
	}

	public List<SWTotalSale> selectSWTotalSaleByAll(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select	MID(o.o_date , 1, 7) as 날짜, " + 
					"		cate.cate_name as 분류, " + 
					"		p.p_name as 품목명, " + 
					"		o.o_no as 주문번호, " + 
					"		o.o_qty as 주문수량, " + 
					"		o.o_qty*p.p_price as 판매금액 " + 
					"  from `order` o natural join product p natural join category cate " + 
					" where p.p_no  = o.o_pno and cate.cate_no = p.p_cate " + 
					"group by 날짜, 분류, 품목명, 주문번호";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<SWTotalSale> list = new ArrayList<SWTotalSale>();
			while(rs.next()) {
				SWTotalSale swTotal = new SWTotalSale();
				swTotal.setO_date(rs.getString(1));
				swTotal.setCate_name(rs.getString(2));
				swTotal.setP_name(rs.getString(3));
				swTotal.setO_no(rs.getInt(4));
				swTotal.setO_qty(rs.getInt(5));
				swTotal.setSalesAmount(rs.getInt(6));
				
				list.add(swTotal);
			}
			return list;
			
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
}
