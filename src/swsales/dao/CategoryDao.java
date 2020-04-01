package swsales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import swsales.jdbc.JDBCUtil;
import swsales.model.Category;

public class CategoryDao {
	private static final CategoryDao dao = new CategoryDao();

	public static CategoryDao getInstance() {
		return dao;
	}

	private CategoryDao() {
	}


	public List<Category> selectCategoryByAll(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select cate_no, cate_name from category";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Category> list = new ArrayList<Category>();
			while(rs.next()) {
				list.add(getCategory(rs));
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private Category getCategory(ResultSet rs) throws SQLException {
		int cateNo = rs.getInt("cate_no");
		String cateName = rs.getString("cate_name");
		return new Category(cateNo, cateName);
	}

}
