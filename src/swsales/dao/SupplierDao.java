package swsales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import swsales.jdbc.JDBCUtil;
import swsales.model.Supplier;

public class SupplierDao {
	private static final SupplierDao dao = new SupplierDao();

	public static SupplierDao getInstance() {
		return dao;
	}

	private SupplierDao() {
	}

	public Supplier selectSupplierByName(Connection conn,Supplier supplier) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select s_no, s_name, s_bln, s_address, s_tel, s_fax from supplier where s_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, supplier.getsName());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return getSupplier(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	public Supplier selectSupplierByNo(Connection conn,Supplier supplier) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select s_no, s_name, s_bln, s_address, s_tel, s_fax from supplier where s_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, supplier.getsNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return getSupplier(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private Supplier getSupplier(ResultSet rs) throws SQLException {
		int sNo = rs.getInt("s_no");
		String sName = rs.getString("s_name");
		String sBln = rs.getString("s_bln");
		String sAddress = rs.getString("s_address");
		String sTel = rs.getString("s_tel");
		String sFax = rs.getString("s_fax");
		return new Supplier(sNo, sName, sBln, sAddress, sTel, sFax);
	}


	public Supplier selectSuppplierLastData(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select s_no from supplier order by s_no desc limit 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return getSNo(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private Supplier getSNo(ResultSet rs) throws SQLException {
		int sNo = rs.getInt("s_no");
		return new Supplier(sNo);
	}


	public List<Supplier> selectSupplierListByName(Connection conn,Supplier selectSupplier) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select s_no, s_name, s_bln, s_address, s_tel, s_fax from supplier where s_name like concat ('%', ?, '%')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, selectSupplier.getsName());
			rs = pstmt.executeQuery();
			List<Supplier> list = new ArrayList<Supplier>();
			while (rs.next()) {
				list.add(getSupplier(rs));
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}

	}

	public List<Supplier> selectSupplierListByBln(Connection conn,Supplier selectSupplier) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select s_no, s_name, s_bln, s_address, s_tel, s_fax from supplier where s_bln like concat ('%', ?, '%')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, selectSupplier.getsBln());
			rs = pstmt.executeQuery();
			List<Supplier> list = new ArrayList<Supplier>();
			while (rs.next()) {
				list.add(getSupplier(rs));
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	public List<Supplier> selectSupplierListByTel(Connection conn,Supplier selectSupplier) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select s_no, s_name, s_bln, s_address, s_tel, s_fax from supplier where s_tel like concat ('%', ?, '%')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, selectSupplier.getsTel());
			rs = pstmt.executeQuery();
			List<Supplier> list = new ArrayList<Supplier>();
			while (rs.next()) {
				list.add(getSupplier(rs));
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	public List<Supplier> selectSupplierByAll(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select s_no, s_name, s_bln, s_address, s_tel, s_fax from supplier";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Supplier> list = new ArrayList<Supplier>();
			while (rs.next()) {
				list.add(getSupplier(rs));
			}
			return list;
			
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
	
	public List<Supplier> selectSupplierPaging(Connection conn, int page) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//1번 페이지 1~10
        //2번 페이지 11~20        
        int startNum = (page-1)*10+1;
        int endNum = page*10;
        
        try{
        	 String sql = "SELECT * from (SELECT @rownum:=@rownum+1 rnum, s.* from supplier s, " 
                     + "(SELECT @ROWNUM := 0) R where 1=1) list WHERE rnum >= ? AND rnum <=?";
        	List<Supplier> list = new ArrayList<Supplier>();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, startNum);
            pstmt.setInt(2, endNum);
            rs = pstmt.executeQuery();
            while(rs.next()){
            	Supplier sup = new Supplier(rs.getInt("s_no"), rs.getString("s_name"), 
            								rs.getString("s_bln"), rs.getString("s_address"), 
            								rs.getString("s_tel"), rs.getString("s_fax"));
                list.add(sup);
            }
            return list;
        }finally{
            JDBCUtil.close(rs);
            JDBCUtil.close(pstmt);
        }
	}
	
	public void insertSupplier(Connection conn,Supplier supplier) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into supplier values(?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, supplier.getsNo());
			pstmt.setString(2, supplier.getsName());
			pstmt.setString(3, supplier.getsBln());
			pstmt.setString(4, supplier.getsAddress());
			pstmt.setString(5, supplier.getsTel());
			pstmt.setString(6, supplier.getsFax());
			pstmt.executeUpdate();
			
		} finally {
			JDBCUtil.close(pstmt);
		}
	}


	public void updateSupplier(Connection conn,Supplier supplier) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			String sql = "update supplier set s_name=?, s_bln=?, s_address=?, s_tel=?, s_fax=? where s_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, supplier.getsName());
			pstmt.setString(2, supplier.getsBln());
			pstmt.setString(3, supplier.getsAddress());
			pstmt.setString(4, supplier.getsTel());
			pstmt.setString(5, supplier.getsFax());
			pstmt.setInt(6, supplier.getsNo());
			pstmt.executeUpdate();
			
		} finally {
			JDBCUtil.close(pstmt);
		}
	}


	public void deleteSupplier(Connection conn,Supplier supplier) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from supplier where s_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, supplier.getsNo());
			pstmt.executeUpdate();
			
		} finally {
			JDBCUtil.close(pstmt);
		}
	}
}
