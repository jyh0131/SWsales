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
import swsales.model.SupplierOrder;

public class SupplierOrderDao {
	private static final SupplierOrderDao dao = new SupplierOrderDao();

	public static SupplierOrderDao getInstance() {
		return dao;
	}

	private SupplierOrderDao() {
	}

	public SupplierOrder selectSupplierOrderLastDate(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select so_no from supplier_order order by so_no desc limit 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return getSONo(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private SupplierOrder getSONo(ResultSet rs) throws SQLException {
		int soNo = rs.getInt("so_no");
		return new SupplierOrder(soNo);
	}

	public List<SupplierOrder> selectSupplierOrderByAll(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select so_no, so_pno, p.p_name, s.s_no, s.s_name, p.p_cost, so_qty, so_date from supplier_order so "
					+ "left join product p on so.so_pno = p.p_no left join supplier s on p.p_sno = s.s_no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<SupplierOrder> list = new ArrayList<>();
			while (rs.next()) {
				list.add(getSOJoin(rs));
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private SupplierOrder getSOJoin(ResultSet rs) throws SQLException {
		int soNo = rs.getInt("so_no");
		Product soPno = new Product(rs.getInt("so_pno"));
		Product soPname = new Product(rs.getString("p_name"), rs.getInt("p_cost"));
		Supplier soSname = new Supplier(rs.getInt("s_no"), rs.getString("s_name"));
		Product soPcost = new Product(rs.getString("p_name"), rs.getInt("p_cost"));
		Date soDate = rs.getTimestamp("so_date");
		int soQty = rs.getInt("so_qty");
		return new SupplierOrder(soNo, soPno, soPname, soSname, soPcost, soQty, soDate);
	}

	public void insertSupplierOrder(Connection conn, SupplierOrder so) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into supplier_order(so_no, so_pno, so_qty, so_date) values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, so.getSoNo());
			pstmt.setInt(2, so.getSoPno().getpNo());
			pstmt.setInt(3, so.getSoQty());
			pstmt.setTimestamp(4, new Timestamp(so.getSoDate().getTime()));
			pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}

	public void updateSupplierOrder( Connection conn, SupplierOrder so) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update supplier_order set so_pno=?, so_qty=?, so_date=? where so_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, so.getSoPno().getpNo());
			pstmt.setInt(2, so.getSoQty());
			pstmt.setTimestamp(3, new Timestamp(so.getSoDate().getTime()));
			pstmt.setInt(4, so.getSoNo());
			pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}

	public void deleteSupplierOrder(Connection conn, SupplierOrder so) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from supplier_order where so_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, so.getSoNo());
			pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}

	public int selectSupplierOrderPno(Connection conn, Product soPname) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select p.p_no from supplier_order so right join product p on so.so_pno = p.p_no where p.p_name =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, soPname.getpName());
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
		int soPno = rs.getInt("p_no");
		return soPno;
	}

}
