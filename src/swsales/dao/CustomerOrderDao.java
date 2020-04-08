package swsales.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import swsales.jdbc.JDBCUtil;
import swsales.model.CustomerOrder;

public class CustomerOrderDao {
	private static final CustomerOrderDao dao = new CustomerOrderDao();

	public static CustomerOrderDao getInstance() {
		return dao;
	}

	private CustomerOrderDao() {
	}

	public List<CustomerOrder> procedureClientChart(Connection conn, CustomerOrder cChart) throws SQLException {
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "{call clientChart(?)}";
			cstmt = conn.prepareCall(sql);
			cstmt.setDate(1, (Date) cChart.getO_date());
			rs = cstmt.executeQuery();
			List<CustomerOrder> list = new ArrayList<CustomerOrder>();
			while(rs.next()) {
				CustomerOrder chart = new CustomerOrder();
				chart.setC_name(rs.getString(1));
				chart.setP_price(rs.getInt(2));
				chart.setO_date(rs.getDate(3));
				
				list.add(chart);
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(cstmt);
		}
	}

	public List<CustomerOrder> selectClientChartTest(Connection conn, CustomerOrder co) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select  c.c_name, o.o_qty*p.p_price as 판매금액, o.o_date " + 
					"  from `order` o natural join client c natural join product p " + 
					" where o.o_cno = c.c_no and p.p_no = o.o_pno and ? <= o.o_date and o.o_date <= ?" + 
					" order by o.o_qty*p.p_price desc limit 10";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, co.getStart_o_date());
			pstmt.setDate(2, co.getEnd_o_date());
			rs = pstmt.executeQuery();
			List<CustomerOrder> list = new ArrayList<CustomerOrder>();
			while(rs.next()) {
				CustomerOrder customerOrder = new CustomerOrder();
				customerOrder.setC_name(rs.getString(1));
				customerOrder.setP_price(rs.getInt(2));
				customerOrder.setO_date(rs.getDate(3));
				
				list.add(customerOrder);
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

}
