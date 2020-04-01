package swsales.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import swsales.jdbc.JDBCUtil;
import swsales.model.IQEvaluation;

public class IQEvaluationDao {
	private static final IQEvaluationDao dao = new IQEvaluationDao();

	public static IQEvaluationDao getInstance() {
		return dao;
	}

	private IQEvaluationDao() {
	}

	public List<IQEvaluation> selectIQEvaluationByAll(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select	p.p_name as 품목명, " + 
					"		s.s_name as 공급회사명, " + 
					"		iq.iq_qty as 재고수량, " + 
					"		p.p_price as 판매가격, " + 
					"		p.p_cost as 공급가격, " + 
					"		(case when iq.iq_qty < 50 then '재고부족'	  when iq.iq_qty >= 50 and iq.iq_qty < 150 then '적정재고'	  when iq.iq_qty >= 150 then '재고과다'	end) as 재고평가 " + 
					"  from product p natural join supplier s natural join inventory_quantity iq " + 
					" where s.s_no = p.p_sno and p.p_no = iq.iq_pno;";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<IQEvaluation> list = new ArrayList<IQEvaluation>();
			while(rs.next()) {
				IQEvaluation iqEvaluation = new IQEvaluation();
				iqEvaluation.setP_name(rs.getString(1));
				iqEvaluation.setS_name(rs.getString(2));
				iqEvaluation.setIq_qty(rs.getInt(3));
				iqEvaluation.setP_price(rs.getInt(4));
				iqEvaluation.setP_cost(rs.getInt(5));
				iqEvaluation.setEvaluation(rs.getString(6));
				
				list.add(iqEvaluation);
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	public List<IQEvaluation> procedureIQEvaluationByPName(Connection conn, IQEvaluation iq) throws SQLException {
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "{call iq(?)}";
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, iq.getP_name());
			rs = cstmt.executeQuery();
			List<IQEvaluation> list = new ArrayList<IQEvaluation>();
			while(rs.next()) {
				IQEvaluation iqEvaluation = new IQEvaluation();
				iqEvaluation.setP_name(rs.getString(1));
				iqEvaluation.setS_name(rs.getString(2));
				iqEvaluation.setIq_qty(rs.getInt(3));
				iqEvaluation.setP_price(rs.getInt(4));
				iqEvaluation.setP_cost(rs.getInt(5));
				iqEvaluation.setEvaluation(rs.getString(6));
				
				list.add(iqEvaluation);
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(cstmt);
		}
	}

	public List<IQEvaluation> selectIQShortageByIQQty(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select	p.p_name as 품목명, " + 
					"		s.s_name as 공급회사명, " + 
					"		iq.iq_qty as 재고수량, " + 
					"		p.p_price as 판매가격, " + 
					"		p.p_cost as 공급가격, " + 
					"		'재고부족' as 재고평가 " + 
					"  from product p natural join supplier s natural join inventory_quantity iq " + 
					" where s.s_no = p.p_sno and p.p_no = iq.iq_pno and iq.iq_qty < '50'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<IQEvaluation> list = new ArrayList<IQEvaluation>();
			while(rs.next()) {
				IQEvaluation iqEvaluation = new IQEvaluation();
				iqEvaluation.setP_name(rs.getString(1));
				iqEvaluation.setS_name(rs.getString(2));
				iqEvaluation.setIq_qty(rs.getInt(3));
				iqEvaluation.setP_price(rs.getInt(4));
				iqEvaluation.setP_cost(rs.getInt(5));
				iqEvaluation.setEvaluation(rs.getString(6));
				
				list.add(iqEvaluation);
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	public List<IQEvaluation> selectIQModerateByIQQty(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select	p.p_name as 품목명, " + 
					"		s.s_name as 공급회사명, " + 
					"		iq.iq_qty as 재고수량, " + 
					"		p.p_price as 판매가격, " + 
					"		p.p_cost as 공급가격, " + 
					"		'적정재고' as 재고평가 " + 
					"  from product p natural join supplier s natural join inventory_quantity iq " + 
					" where s.s_no = p.p_sno and p.p_no = iq.iq_pno and '50' <= iq.iq_qty and iq.iq_qty < '150'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<IQEvaluation> list = new ArrayList<IQEvaluation>();
			while(rs.next()) {
				IQEvaluation iqEvaluation = new IQEvaluation();
				iqEvaluation.setP_name(rs.getString(1));
				iqEvaluation.setS_name(rs.getString(2));
				iqEvaluation.setIq_qty(rs.getInt(3));
				iqEvaluation.setP_price(rs.getInt(4));
				iqEvaluation.setP_cost(rs.getInt(5));
				iqEvaluation.setEvaluation(rs.getString(6));
				
				list.add(iqEvaluation);
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	public List<IQEvaluation> selectIQExcessiveByIQQty(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select	p.p_name as 품목명, " + 
					"		s.s_name as 공급회사명, " + 
					"		iq.iq_qty as 재고수량, " + 
					"		p.p_price as 판매가격, " + 
					"		p.p_cost as 공급가격, " + 
					"		'재고과다' as 재고평가 " + 
					"  from product p natural join supplier s natural join inventory_quantity iq " + 
					" where s.s_no = p.p_sno and p.p_no = iq.iq_pno and '150' <= iq.iq_qty";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<IQEvaluation> list = new ArrayList<IQEvaluation>();
			while(rs.next()) {
				IQEvaluation iqEvaluation = new IQEvaluation();
				iqEvaluation.setP_name(rs.getString(1));
				iqEvaluation.setS_name(rs.getString(2));
				iqEvaluation.setIq_qty(rs.getInt(3));
				iqEvaluation.setP_price(rs.getInt(4));
				iqEvaluation.setP_cost(rs.getInt(5));
				iqEvaluation.setEvaluation(rs.getString(6));
				
				list.add(iqEvaluation);
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

}
