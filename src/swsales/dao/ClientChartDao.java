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
import swsales.model.ClientChart;

public class ClientChartDao {
	private static final ClientChartDao dao = new ClientChartDao();

	public static ClientChartDao getInstance() {
		return dao;
	}

	private ClientChartDao() {
	}

	public List<ClientChart> procedureClientChart(Connection conn, ClientChart cChart) throws SQLException {
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "{call clientChart(?)}";
			cstmt = conn.prepareCall(sql);
			cstmt.setDate(1, (Date) cChart.getO_date());
			rs = cstmt.executeQuery();
			List<ClientChart> list = new ArrayList<ClientChart>();
			while(rs.next()) {
				ClientChart chart = new ClientChart();
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

	public List<ClientChart> selectClientChartTest(Connection conn, String start, String end) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select  c.c_name, o.o_qty*p.p_price as 판매금액, o.o_date " + 
					"  from `order` o natural join client c natural join product p " + 
					" where o.o_cno = c.c_no and p.p_no = o.o_pno and ? <= o.o_date and o.o_date <= ?" + 
					" order by o.o_qty*p.p_price desc limit 10";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, start);
			pstmt.setString(2, end);
			rs = pstmt.executeQuery();
			List<ClientChart> list = new ArrayList<ClientChart>();
			while(rs.next()) {
				ClientChart cChart = new ClientChart();
				cChart.setC_name(rs.getString(1));
				cChart.setP_price(rs.getInt(2));

				list.add(cChart);
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

}
