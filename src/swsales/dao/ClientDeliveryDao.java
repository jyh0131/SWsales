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
import swsales.model.Client;
import swsales.model.ClientDelivery;
import swsales.model.Order;
import swsales.model.Product;

public class ClientDeliveryDao {
	private static final ClientDeliveryDao dao = new ClientDeliveryDao();

	public static ClientDeliveryDao getInstance() {
		return dao;
	}

	private ClientDeliveryDao() {
	}
	
	//출고번호, 고객상호명, 품목명, 출고수량, 출고일자
	private ClientDelivery getClientDelivery(ResultSet rs) throws SQLException {
		int cdNo = rs.getInt("cd_no");
		Order cdSno = new Order(rs.getInt("o_no"), new Client(rs.getInt("c_no")),rs.getInt("o_qty"));
		Product pName = new Product(rs.getString("p_name"));
		Date cdDate = rs.getTimestamp("cd_date");
		Client cName = new Client(rs.getString("c_name"));
		return new ClientDelivery(cdNo, cdSno, cName, pName, cdDate);
	}
	
	//마지막 다음 번호
	private ClientDelivery getClientDeliveryNo(ResultSet rs) throws SQLException {
		int cdNo = rs.getInt("cd_no");
		return new ClientDelivery(cdNo);
	}

	//출고이력관리이용

	public List<ClientDelivery> selectClientDeliveryByAll(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select cd_no, c_name, p_name, o_qty, cd_date, c_no, o_no from client_delivery cd "
					+ "left join `order` o on cd.cd_sno = o.o_no "
					+ "left join product p on o.o_pno = p.p_no "
					+ "left join client c on o.o_cno = c.c_no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<ClientDelivery> list = new ArrayList<>();
			while(rs.next()) {
				list.add(getClientDelivery(rs));
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}



	//마지막번호

	public ClientDelivery selectClientDeliveryLastNo(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select cd_no from client_delivery order by cd_no desc limit 1";
			 pstmt = conn.prepareStatement(sql);
			 rs = pstmt.executeQuery();
			 if(rs.next()) {
					return getClientDeliveryNo(rs);
				}
			 return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	public void insertClientDelivery(Connection conn, ClientDelivery cd) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into client_delivery (cd_sno, cd_date) value( ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cd.getCdSno().getoNo());
			pstmt.setTimestamp(2, new Timestamp(cd.getCdDate().getTime()));
			pstmt.executeUpdate();
			
		} finally {
			JDBCUtil.close(pstmt);
		}
	}


	public void updateClientDelivery(Connection conn, ClientDelivery cd) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update client_delivery set cd_date = ? where cd_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setTimestamp(1, new Timestamp(cd.getCdDate().getTime()));
			pstmt.setInt(2, cd.getCdNo());
			pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}


	public void deleteClientDelivery(Connection conn, ClientDelivery cd) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from client_delivery where cd_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cd.getCdNo());
			pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}


	public ClientDelivery selectClientDeliveryByOno(Connection conn, Order order) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select cd_sno from client_delivery cd where cd_sno = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order.getoNo());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return getCD(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private ClientDelivery getCD(ResultSet rs) throws SQLException {
		int cdSno = rs.getInt("cd_sno"); 
		return new ClientDelivery(cdSno);
	}

	public void deleteClientDeliveryByOno(Connection conn, ClientDelivery cd) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from client_delivery where cd_sno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cd.getCdSno().getoNo());
			pstmt.executeUpdate();
			
		} finally {
			JDBCUtil.close(pstmt);
		}
	}

	public ClientDelivery selectClientDeliveryByNo(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select cd_no, c_name, p_name, o_qty, cd_date, c_no, o_no from client_delivery cd left join `order` o on cd.cd_sno = o.o_no left join product p on o.o_pno = p.p_no left join client c on o.o_cno = c.c_no where cd.cd_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {				
				return getClientDelivery(rs);
			}
			return null;
		}finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

}
