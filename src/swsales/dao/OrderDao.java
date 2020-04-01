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
import swsales.model.Employee;
import swsales.model.MajorClient;
import swsales.model.Order;
import swsales.model.OrderRanking;
import swsales.model.Product;

public class OrderDao {
	private static final OrderDao dao = new OrderDao();

	public static OrderDao getInstance() {
		return dao;
	}

	private OrderDao() {
	}

	public Order selectOrderLastDate(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select o_no from `order` order by o_no desc limit 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return getONo(rs);
			}
			return null;
			
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private Order getONo(ResultSet rs) throws SQLException {
		int oNo = rs.getInt("o_no");
		return new Order(oNo);
	}


	public List<Order> selectOrderByAll(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select o_no, o_date, c.c_name, p.p_name, o_qty, o_memo, o_dps, o_ok, o_eno, e.e_name, e.e_no from `order` o "
					+ "left join client c on o.o_cno = c.c_no left join product p on o.o_pno = p.p_no "
					+ "left join employee e on o.o_eno = e.e_no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Order> list = new ArrayList<Order>();
			while (rs.next()) {
				list.add(getOrderJoin(rs));
			}
			return list;
			
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private Order getOrderJoin(ResultSet rs) throws SQLException {
		int oNo = rs.getInt("o_no");
		Date oDate = rs.getTimestamp("o_date");
		Client oCname = new Client(rs.getString("c_name"), null, null);
		Product oPname = new Product();
		oPname.setpName(rs.getString("p_name"));
		int oQty = rs.getInt("o_qty");
		String oMemo = rs.getString("o_memo");
		int oDps = rs.getInt("o_dps");
		int oOk = rs.getInt("o_ok");
		Employee oEname = new Employee();
		oEname.setEmpName(rs.getString("e_name"));
		Employee oEno = new Employee(rs.getInt("e_no"));
		return new Order(oNo, oDate, oCname, oPname, oQty, oMemo, oDps, oOk, oEname, oEno);
	}


	public void insertOrder(Connection conn, Order order) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into `order` (o_no, o_date, o_cno, o_pno, o_qty, o_memo, o_dps, o_ok, o_eno) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order.getoNo());
			pstmt.setTimestamp(2, new Timestamp(order.getoDate().getTime()));
			pstmt.setInt(3, order.getoCname().getcNo());
			pstmt.setInt(4, order.getoPname().getpNo());
			pstmt.setInt(5, order.getoQty());
			pstmt.setString(6, order.getoMemo());
			pstmt.setInt(7, order.getoDps());
			pstmt.setInt(8, order.getoOk());
			pstmt.setInt(9, order.getoEname().getEmpNo());
			pstmt.executeUpdate();
			
		} finally {
			JDBCUtil.close(pstmt);
		}
	}


	public void updateOrder(Connection conn, Order order) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update `order` set o_date=?, o_cno=?, o_pno=?, o_qty=?, o_memo=? where o_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setTimestamp(1, new Timestamp(order.getoDate().getTime()));
			pstmt.setInt(2, order.getoCname().getcNo());
			pstmt.setInt(3, order.getoPname().getpNo());
			pstmt.setInt(4, order.getoQty());
			pstmt.setString(5, order.getoMemo());
			pstmt.setInt(6, order.getoNo());
			pstmt.executeUpdate();
			
		} finally {
			JDBCUtil.close(pstmt);
		}
	}

	public void deleteOrder(Connection conn, Order order) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from `order` where o_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order.getoNo());
			pstmt.executeUpdate();
			
		} finally {
			JDBCUtil.close(pstmt);
		}
	}

	public List<Order> selectClientOrderList(Connection conn, Client info) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select o_no, o_date, o_cno, p.p_name, p.p_cost, p.p_price, o_qty, o_memo, o_dps, o_ok, o_eno from `order` o "
					+ "left join product p on o.o_pno =p.p_no where o_cno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, info.getcNo());
			rs = pstmt.executeQuery();
			List<Order> list = new ArrayList<Order>();
			while (rs.next()) {
				list.add(getOrder(rs));
			}
			return list;
			
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private Order getOrder(ResultSet rs) throws SQLException {
		int oNo = rs.getInt("o_no");
		Date oDate = rs.getTimestamp("o_date");
		Client oCname = new Client(rs.getInt("o_cno"));
		Product oPname = new Product(rs.getString("p_name"), rs.getInt("p_cost"), rs.getInt("p_price"));
		int oQty = rs.getInt("o_qty");
		String oMemo = rs.getString("o_memo");
		int oDps = rs.getInt("o_dps");
		int oOk = rs.getInt("o_ok");
		Employee oEname = new Employee(rs.getInt("o_eno"));
		return new Order(oNo, oDate, oCname, oPname, oQty, oMemo, oDps, oOk, oEname);
	}


	public List<Order> selectOrderListByCal(Connection conn, String startDate, String endDate, Client info) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select o_no, o_date, o_cno, p.p_name, p.p_cost, p.p_price, o_qty, o_memo, o_dps, o_ok, o_eno from `order` o "
					   + "left join product p on o.o_pno =p.p_no left join client c on o.o_cno = c.c_no where DATE(o_date) " 
					   + "between ? and ? and  c.c_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			pstmt.setInt(3, info.getcNo());
			rs = pstmt.executeQuery();
			List<Order> list = new ArrayList<Order>();
			while (rs.next()) {
				list.add(getOrder(rs));
			}
			return list;
			
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	public Order selectOrderByNo(Connection conn, int i) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select o_no, o_date, o_cno, p.p_name, p.p_price, p.p_cost, o_qty, o_memo, o_dps, o_ok, o_eno from `order` o "
					+ "left join product p on o.o_pno =p.p_no where o_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, i);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return getOrder2(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private Order getOrder2(ResultSet rs) throws SQLException {
		int oNo = rs.getInt("o_no");
		Date oDate = rs.getTimestamp("o_date");
		Client oCname = new Client(rs.getInt("o_cno"));
		Product oPname = new Product(rs.getString("p_name"), rs.getInt("p_cost"), rs.getInt("p_price"));
		int oQty = rs.getInt("o_qty");
		String oMemo = rs.getString("o_memo");
		return new Order(oNo, oDate, oCname, oPname, oQty, oMemo);
	}


	public void updateOrderDps1(Connection conn, Order order) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update `order` set o_dps=1, o_ok=1 where o_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order.getoNo());
			pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}


	public void updateOrderDps0(Connection conn, Order order) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update `order` set o_dps=0, o_ok=0 where o_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order.getoNo());
			pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}


	public int selectSalesMoney(Connection conn, String startDate, String endDate, int dept) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select sum(p.p_price * o.o_qty) from `order` o join product p on o.o_pno = p.p_no "
					   + "join employee e on o.o_eno = e.e_no where o.o_date between ? and ? and e.e_dept = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			pstmt.setInt(3, dept);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("sum(p.p_price * o.o_qty)");
			}
			return 0;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	public int selectOrderTotalMoney(Connection conn, String firstDate, String lastDate, Client info) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select sum(p.p_price * o.o_qty) from `order` o left join product p on o.o_pno =p.p_no " 
					   + "left join client c on o.o_cno = c.c_no where DATE(o_date) between ? and ? " 
					   + "and c.c_no = ? order by p.p_price * o.o_qty desc limit 5;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, firstDate);
			pstmt.setString(2, lastDate);
			pstmt.setInt(3, info.getcNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("sum(p.p_price * o.o_qty)");
			}
			return 0;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
	
	public List<OrderRanking> selectOrderMoney(Connection conn, String firstDate, String lastDate, Client info) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select o.o_no, p.p_name, (p.p_price * o_qty) from `order` o left join product p on o.o_pno =p.p_no "
					   + "left join client c on o.o_cno = c.c_no where DATE(o_date) between ? and ? "
					   + "and c.c_no = ? order by p.p_price * o.o_qty desc limit 5";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, firstDate);
			pstmt.setString(2, lastDate);
			pstmt.setInt(3, info.getcNo());
			rs = pstmt.executeQuery();
			List<OrderRanking> list = new ArrayList<OrderRanking>();
			while (rs.next()) {
				list.add(getMoney(rs));
			}
			return list; 
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private OrderRanking getMoney(ResultSet rs) throws SQLException {
		int orNo = rs.getInt("o_no");
		String orName = rs.getString("p_name");
		int orMoney = rs.getInt("(p.p_price * o_qty)");
		return new OrderRanking(orNo, orName, orMoney);
	}


	public List<MajorClient> selectMajorClientList(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select c.c_name, p.p_price * o.o_qty from `order` o "
					   + "join product p on o.o_pno = p.p_no join employee e on o.o_eno = e.e_no "
					   + "join client c on o.o_cno = c.c_no order by p.p_price * o.o_qty desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<MajorClient> list = new ArrayList<MajorClient>();
			while (rs.next()) {
				list.add(getMajorClient(rs));
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private MajorClient getMajorClient(ResultSet rs) throws SQLException {
		Client oCname = new Client(rs.getString("c_name"));
		int totalMoney = rs.getInt("p.p_price * o.o_qty");
		return new MajorClient(oCname, totalMoney);
	}
}
