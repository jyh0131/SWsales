package swsales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import swsales.jdbc.JDBCUtil;
import swsales.model.InventoryQuantity;
import swsales.model.Product;
import swsales.model.Supplier;

public class IQDao {
	private static final IQDao dao = new IQDao();

	public static IQDao getInstance() {
		return dao;
	}

	private IQDao() {
	}
	
	public List<InventoryQuantity> selectInventoryQuantityByAll(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select p.p_name , s.s_name , iq.iq_qty , p.p_price , p.p_cost from inventory_quantity iq "
		               + "left join product p on iq.iq_pno = p.p_no left join supplier s on p.p_sno = s.s_no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<InventoryQuantity> list = new ArrayList<InventoryQuantity>();
			while(rs.next()) {
				list.add(getIQJoin(rs));
			}
			return list;
			
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private InventoryQuantity getIQJoin(ResultSet rs) throws SQLException {
		Product iqPname = new Product(rs.getString("p_name"), rs.getInt("p_cost"), rs.getInt("p_price"));
		Supplier iqSname = new Supplier(rs.getString("s_name"));
		Product iqPprice = new Product(rs.getString("p_name"), rs.getInt("p_cost"), rs.getInt("p_price"));
		Product iqPcost = new Product(rs.getString("p_name"), rs.getInt("p_cost"), rs.getInt("p_price"));
		int iqQty = rs.getInt("iq_qty");
		return new InventoryQuantity(iqPname, iqSname, iqPprice, iqPcost, iqQty);
	}


	public void insertIQ(Connection conn, InventoryQuantity iq) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into inventory_quantity (iq_no, iq_pno, iq_qty) values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, iq.getIqNo());
			pstmt.setInt(2, iq.getIqPno().getpNo());
			pstmt.setInt(3, iq.getIqQty());
			pstmt.executeUpdate();
			
		} finally {
			JDBCUtil.close(pstmt);
		}
	}

	public void updateIQ(Connection conn, InventoryQuantity iq) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update inventory_quantity set iq_qty=? where iq_pno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, iq.getIqQty());
			pstmt.setInt(2, iq.getIqPno().getpNo());
			pstmt.executeUpdate();
			
		} finally {
			JDBCUtil.close(pstmt);
		}
	}

	public void deleteIQ(Connection conn, InventoryQuantity iq) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from inventory_quantity where iq_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, iq.getIqNo());
			pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}


	public int selectIqQtyByPname(Connection conn, Product proSummary) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select iq_qty from inventory_quantity where iq_pno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, proSummary.getpNo());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return getIqQty(rs);
			}
			return 0;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private int getIqQty(ResultSet rs) throws SQLException {
		int qty = rs.getInt("iq_qty");
		return qty;
	}

	public void subIqQty(Connection conn, Product subProduct, int sub) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update inventory_quantity set iq_qty=? where iq_pno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sub);
			pstmt.setInt(2, subProduct.getpNo());
			pstmt.executeUpdate();
			
		} finally {
			JDBCUtil.close(pstmt);
		}
	}


	public InventoryQuantity selectIQLastDate(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select iq_no from inventory_quantity order by iq_no desc limit 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return getNo(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private InventoryQuantity getNo(ResultSet rs) throws SQLException {
		int iqNo = rs.getInt("iq_no");
		return new InventoryQuantity(iqNo);
	}

}
