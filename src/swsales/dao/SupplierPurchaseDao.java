package swsales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import swsales.jdbc.JDBCUtil;
import swsales.model.Product;
import swsales.model.Supplier;
import swsales.model.SupplierPurchase;

public class SupplierPurchaseDao {
	private static final SupplierPurchaseDao dao = new SupplierPurchaseDao();

	public static SupplierPurchaseDao getInstance() {
		return dao;
	}

	private SupplierPurchaseDao() {
	}

	public SupplierPurchase selectSupplierPurchaseLastDate(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select sp_no from supplier_purchase order by sp_no desc limit 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return getSPNo(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private SupplierPurchase getSPNo(ResultSet rs) throws SQLException {
		int spNo = rs.getInt("sp_no");
		return new SupplierPurchase(spNo);
	}

	public List<SupplierPurchase> selectSupplierPurchaseByAll(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select sp_no, sp_pno, p.p_name, s.s_name, p.p_cost, sp_qty, sp_date from supplier_purchase sp "
					   + "left join product p on sp.sp_pno = p.p_no left join supplier s on p.p_sno = s.s_no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<SupplierPurchase> list = new ArrayList<>();
			while(rs.next()) {
				list.add(getSPJoin(rs));
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private SupplierPurchase getSPJoin(ResultSet rs) throws SQLException {
		int spNo = rs.getInt("sp_no");
		Product spPno = new Product(rs.getInt("sp_pno"));
		Product spPname = new Product(rs.getString("p_name"), rs.getInt("p_cost"));
		Supplier spSname = new Supplier(rs.getString("s_name"));
		Product spPcost = new Product(rs.getString("p_name"), rs.getInt("p_cost"));
		Date spDate = rs.getTimestamp("sp_date");
		int spQty = rs.getInt("sp_qty");
		return new SupplierPurchase(spNo, spPno, spPname, spSname, spPcost, spQty, spDate);
	}

	public void insertSupplierPurchase(Connection conn, SupplierPurchase sp) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into supplier_purchase(sp_no, sp_pno, sp_qty, sp_date) values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sp.getSpNo());
			pstmt.setInt(2, sp.getSpPno().getpNo());
			pstmt.setInt(3, sp.getSpQty());
			pstmt.setTimestamp(4, new Timestamp(sp.getSpDate().getTime()));
			pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}

	public void updateSupplierPurchase(Connection conn, SupplierPurchase sp) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update supplier_purchase set sp_pno=?, sp_qty=?, sp_date=? where sp_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sp.getSpPno().getpNo());
			pstmt.setInt(2, sp.getSpQty());
			pstmt.setTimestamp(3, new Timestamp(sp.getSpDate().getTime()));
			pstmt.setInt(4, sp.getSpNo());
			pstmt.executeUpdate();
			
		} finally {
			JDBCUtil.close(pstmt);
		}
	}

	public void deleteSupplierPurchase(Connection conn, SupplierPurchase sp) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from supplier_purchase where sp_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sp.getSpNo());
			pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}

	public int selectSupplierPurchasePno(Connection conn, Product sp) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select p_no from product where p_name =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sp.getpName());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return getPno(rs);
			}
			return 0;
				
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private int getPno(ResultSet rs) throws SQLException {
		int spPno = rs.getInt("p_no");
		return spPno;
	}


}
