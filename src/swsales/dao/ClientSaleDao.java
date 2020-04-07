package swsales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import swsales.jdbc.JDBCUtil;
import swsales.model.ClientSale;

public class ClientSaleDao {
	private static final ClientSaleDao dao = new ClientSaleDao();

	public static ClientSaleDao getInstance() {
		return dao;
	}

	private ClientSaleDao() {
	}

	public List<ClientSale> selectClientSaleByAll(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select	c.c_name as 고객상호명, " + 
					"		p.p_name as 품목명, " + 
					"		o.o_qty as 주문수량, " + 
					"		(case o.o_dps when '0' then '미입금' when '1' then '완료'	end) as 입금여부, " + 
					"		p.p_price as 판매가격, " + 
					"		o.o_qty*p.p_price as 매출금, " + 
					"		(case o.o_dps when '0' then o.o_qty*p.p_price when '1' then '0' end) as 미수금 " + 
					"  from client c natural join `order` o natural join product p " + 
					" where c.c_no = o.o_cno and p.p_no = o.o_pno";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<ClientSale> list = new ArrayList<ClientSale>();
			while(rs.next()) {
				ClientSale clientSale = new ClientSale();
				clientSale.setC_name(rs.getString(1));
				clientSale.setP_name(rs.getString(2));
				clientSale.setO_qty(rs.getInt(3));
				clientSale.setO_dps(rs.getString(4));
				clientSale.setP_price(rs.getInt(5));
				clientSale.setSalesMoney(rs.getInt(6));
				clientSale.setUncollected(rs.getInt(7));
				
				list.add(clientSale);
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	public List<ClientSale> selectClientSaleByCName(Connection conn, ClientSale cs) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select	c.c_name as 고객상호명, " + 
					"		p.p_name as 품목명, " + 
					"		o.o_qty as 주문수량, " + 
					"		(case o.o_dps when '0' then '미입금' when '1' then '완료'	end) as 입금여부, " + 
					"		p.p_price as 판매가격, " + 
					"		o.o_qty*p.p_price as 매출금, " + 
					"		(case o.o_dps when '0' then o.o_qty*p.p_price when '1' then '0' end) as 미수금 " + 
					"  from client c natural join `order` o natural join product p " + 
					" where c.c_no = o.o_cno and p.p_no = o.o_pno and c.c_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cs.getC_name());
			rs = pstmt.executeQuery();
			List<ClientSale> list = new ArrayList<ClientSale>();
			while(rs.next()) {
				ClientSale clientSale = new ClientSale();
				clientSale.setC_name(rs.getString(1));
				clientSale.setP_name(rs.getString(2));
				clientSale.setO_qty(rs.getInt(3));
				clientSale.setO_dps(rs.getString(4));
				clientSale.setP_price(rs.getInt(5));
				clientSale.setSalesMoney(rs.getInt(6));
				clientSale.setUncollected(rs.getInt(7));
				
				list.add(clientSale);
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
}
