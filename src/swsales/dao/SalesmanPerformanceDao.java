package swsales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import swsales.jdbc.JDBCUtil;
import swsales.model.SalesmanPerformance;

public class SalesmanPerformanceDao {
	private static final SalesmanPerformanceDao dao = new SalesmanPerformanceDao();

	public static SalesmanPerformanceDao getInstance() {
		return dao;
	}

	private SalesmanPerformanceDao() {
	}
	
	public List<SalesmanPerformance> selectEmployeeChart(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select e.e_name, sum(p.p_price* o.o_qty)/(select sum(p.p_price* o.o_qty) from `order` o left join product p on o.o_pno = p.p_no left join employee e on o.o_eno =e.e_no " + 
					" where DATE(o_date) between '2020-03-01' and '2020-03-31' and e.e_dept between 4 and 6)*100 " + 
					"			from `order` o " + 
					"		               left join product p on o.o_pno =p.p_no left join employee e " + 
					"					   on o.o_eno =e.e_no where DATE(o_date) between '2020-03-01' and '2020-03-31' " + 
					"		               and e.e_dept between 4 and 6 group by e.e_name order by sum(p.p_price* o.o_qty) " + 
					"					   desc limit 10;";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<SalesmanPerformance> list = new ArrayList<SalesmanPerformance>();
			
			while(rs.next()) {
				SalesmanPerformance eChart = new SalesmanPerformance();
				eChart.setE_name(rs.getString(1));
				eChart.setSalesMoney(rs.getDouble(2));
				list.add(eChart);
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	public List<SalesmanPerformance> selectEmployeeChart(Connection conn, SalesmanPerformance sp) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select e.e_name, sum(p.p_price* o.o_qty)/(select sum(p.p_price* o.o_qty) from `order` o left join product p on o.o_pno = p.p_no left join employee e on o.o_eno =e.e_no " + 
					" where DATE(o_date) between ? and ? and e.e_dept between 4 and 6)*100 " + 
					"			from `order` o " + 
					"		               left join product p on o.o_pno =p.p_no left join employee e " + 
					"					   on o.o_eno =e.e_no where DATE(o_date) between ? and ? " + 
					"		               and e.e_dept between 4 and 6 group by e.e_name order by sum(p.p_price* o.o_qty) " + 
					"					   desc limit 10";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, sp.getStart_o_date());
			pstmt.setDate(2, sp.getEnd_o_date());
			pstmt.setDate(3, sp.getStart_o_date());
			pstmt.setDate(4, sp.getEnd_o_date());
			rs = pstmt.executeQuery();
			List<SalesmanPerformance> list = new ArrayList<SalesmanPerformance>();
			
			while(rs.next()) {
				SalesmanPerformance eChart = new SalesmanPerformance();
				eChart.setE_name(rs.getString(1));
				eChart.setSalesMoney(rs.getDouble(2));
				list.add(eChart);
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
	
	public List<SalesmanPerformance> selectSalesmanByEName(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select e.e_name from `order` o " + 
					"		left join product p on o.o_pno =p.p_no left join employee e " + 
					"		 on o.o_eno =e.e_no " + 
					"		 and e.e_dept between 4 and 6 group by e.e_name order by sum(p.p_price* o.o_qty) " + 
					"		 desc limit 10";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<SalesmanPerformance> list = new ArrayList<SalesmanPerformance>();
			while(rs.next()) {
				SalesmanPerformance salesman = new SalesmanPerformance();
				salesman.setE_name(rs.getString(1));
				
				list.add(salesman);
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
	
//	public List<SalesmanPerformance> selectSalesmanBySalesMoney(Connection conn) throws SQLException {
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			String sql = "select sum(p.p_price* o.o_qty) from `order` o " + 
//					"		left join product p on o.o_pno =p.p_no left join employee e " + 
//					"		 on o.o_eno =e.e_no " + 
//					"		 and e.e_dept between 4 and 6 group by e.e_name order by sum(p.p_price* o.o_qty) " + 
//					"		 desc limit 10";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			List<SalesmanPerformance> list = new ArrayList<SalesmanPerformance>();
//			while(rs.next()) {
//				SalesmanPerformance salesman = new SalesmanPerformance();
//				salesman.setSalesMoney(rs.getDouble(1));
//				
//				list.add(salesman);
//			}
//			return list;
//		} finally {
//			JDBCUtil.close(rs);
//			JDBCUtil.close(pstmt);
//		}
//	}
	
	public List<SalesmanPerformance> selectSalesmanBySalesMoney(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select sum(p.p_price* o.o_qty)/(select sum(p.p_price* o.o_qty) from `order` o left join product p on o.o_pno = p.p_no left join employee e on o.o_eno =e.e_no " + 
					" 		where DATE(o_date) between '2020-03-01' and '2020-03-31' and e.e_dept between 4 and 6)*100 " + 
					"			from `order` o " + 
					"		               left join product p on o.o_pno =p.p_no left join employee e " + 
					"					   on o.o_eno =e.e_no where DATE(o_date) between '2020-03-01' and '2020-03-31' " + 
					"		               and e.e_dept between 4 and 6 group by e.e_name order by sum(p.p_price* o.o_qty) " + 
					"					   desc limit 10";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<SalesmanPerformance> list = new ArrayList<SalesmanPerformance>();
			while(rs.next()) {
				SalesmanPerformance salesman = new SalesmanPerformance();
				salesman.setSalesMoney(rs.getDouble(1));
				
				list.add(salesman);
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
	
//	public List<SalesmanPerformance> TotalSalesMoney(Connection conn) throws SQLException {
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			String sql = "select sum(p.p_price* o.o_qty) from `order` o left join product p on o.o_pno = p.p_no left join employee e on o.o_eno =e.e_no\r\n" + 
//					" where DATE(o_date) between '2020-03-01' and '2020-03-31' and e.e_dept between 4 and 6";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			List<SalesmanPerformance> list = new ArrayList<SalesmanPerformance>();
//			while(rs.next()) {
//				SalesmanPerformance salesman = new SalesmanPerformance();
//				salesman.setSalesMoney(rs.getDouble(1));
//				
//				list.add(salesman);
//			}
//			return list;
//		} finally {
//			JDBCUtil.close(rs);
//			JDBCUtil.close(pstmt);
//		}
//		
//	}
	
}
