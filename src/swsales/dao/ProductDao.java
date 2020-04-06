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
import swsales.model.Category;
import swsales.model.Order;
import swsales.model.Product;
import swsales.model.Supplier;

public class ProductDao {
	private static final ProductDao dao = new ProductDao();

	public static ProductDao getInstance() {
		return dao;
	}

	private ProductDao() {
	}

	public List<Product> selectProductByAll(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql ="select p_no, c. cate_no, c.cate_name, p_name, p_cost, p_price, s.s_no, s.s_name, p_qty, p_date, p_picpath from product p "
					  + "left join category c on p.p_cate = c.cate_no "
					  + "left join supplier s on p.p_sno = s.s_no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Product> list = new ArrayList<Product>();
			while(rs.next()) {
				list.add(getProductJoin(rs));
			}
			return list;
			
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	public List<Product> selectProductListByName(Connection conn, Product product) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql ="select p_no, c.cate_no, c.cate_name, p_name, p_cost, p_price, s.s_no, s.s_name, p_qty, p_date, p_picpath from product p "
					  + "left join category c on p.p_cate = c.cate_no "
					  + "left join supplier s on p.p_sno = s.s_no where p_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getpName());
			rs = pstmt.executeQuery();
			List<Product> list = new ArrayList<>();
			while(rs.next()) {
				list.add(getProductJoin(rs));
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
	
	public List<Product> selectProductListByCate(Connection conn, Product product) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql ="select p_no, c.cate_no, c.cate_name, p_name, p_cost, p_price, s.s_no, s.s_name, p_qty, p_date, p_picpath from product p "
					  + "left join category c on p.p_cate = c.cate_no "
					  + "left join supplier s on p.p_sno = s.s_no where cate_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getpCate().getCateName());
			rs = pstmt.executeQuery();
			List<Product> list = new ArrayList<>();
			while(rs.next()) {
				list.add(getProductJoin(rs));
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
	
	public List<Product> selectProductListBySupp(Connection conn, Product product) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql ="select p_no, c.cate_no, c.cate_name, p_name, p_cost, p_price, s.s_no, s.s_name, p_qty, p_date, p_picpath from product p "
					  + "left join category c on p.p_cate = c.cate_no "
					  + "left join supplier s on p.p_sno = s.s_no where s_name=?";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Product> list = new ArrayList<>();
			while(rs.next()) {
				list.add(getProductJoin(rs));
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
	
	private Product getProductJoin(ResultSet rs) throws SQLException {
		int pNo = rs.getInt("p_no");
		Category pCate = new Category(rs.getInt("cate_no"), rs.getString("cate_name"));
		String pName = rs.getString("p_name");
		int pCost = rs.getInt("p_cost");
		int pPrice = rs.getInt("p_price");
		Supplier pSno = new Supplier(rs.getInt("s_no"));
		pSno.setsName(rs.getString("s_name"));
		int pQty = rs.getInt("p_qty");
		Date pDate = rs.getTimestamp("p_date");
		String pPicPath = rs.getString("p_picpath");
		return new Product(pNo, pCate, pName, pCost, pPrice, pSno, pQty, pDate, pPicPath);
	}

	public void insertProduct(Connection conn, Product product) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into product(p_no, p_cate, p_name, p_cost, p_price, p_sno, p_qty, p_date, p_pic, p_picpath) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product.getpNo());
			pstmt.setInt(2, product.getpCate().getCateNo());
			pstmt.setString(3, product.getpName());
			pstmt.setInt(4, product.getpCost());
			pstmt.setInt(5, product.getpPrice());
			pstmt.setInt(6, product.getpSno().getsNo());
			pstmt.setInt(7, product.getpQty());
			pstmt.setTimestamp(8, new Timestamp(product.getpDate().getTime()));
			pstmt.setBytes(9, product.getpPic());
			pstmt.setString(10, product.getpPicPath());
			pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}

	public void updateProduct(Connection conn, Product product) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			StringBuilder sql = new StringBuilder("update product set p_cate=?, p_name=?, p_cost=?, p_price=?, p_sno=?, p_qty=?, p_date=?, ");
			if(product.getpPic()!=null) sql.append("p_pic=?, ");
			if(product.getpPicPath()!=null) sql.append("p_picpath=?, ");
			sql.replace(sql.lastIndexOf(","), sql.length(), " ");
			sql.append("where p_no=?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, product.getpCate().getCateNo());
			pstmt.setString(2, product.getpName());
			pstmt.setInt(3, product.getpCost());
			pstmt.setInt(4, product.getpPrice());
			pstmt.setInt(5, product.getpSno().getsNo());
			pstmt.setInt(6, product.getpQty());
			pstmt.setTimestamp(7, new Timestamp(product.getpDate().getTime()));
			int argCnt = 8;
			if(product.getpPic()!=null) {
				pstmt.setBytes(argCnt++, product.getpPic());
				pstmt.setString(argCnt++, product.getpPicPath());
			}
			pstmt.setInt(argCnt++, product.getpNo());
			pstmt.executeUpdate();
			
		} finally {
			JDBCUtil.close(pstmt);
		}
	}

	public void deleteProduct(Connection conn, Product product) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from product where p_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product.getpNo());
			pstmt.executeUpdate();
			
		} finally {
			JDBCUtil.close(pstmt);
		}
	}

	public Product selectProductLastData(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select p_no from product order by p_no desc limit 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return getPNo(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private Product getPNo(ResultSet rs) throws SQLException {
		int pNo = rs.getInt("p_no");
		return new Product(pNo);
	}

	public Product selectProductByName(Connection conn, Product Product) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select p_no, p_name, p_cost, p_price, p_qty from product where p_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Product.getpName());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return getProduct(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private Product getProduct(ResultSet rs) throws SQLException {
		int pNo = rs.getInt("p_no");
		String pName = rs.getString("p_name");
		return new Product(pNo, pName);
	}

	public String selectSupplierByPName(Connection conn, Product product) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select s.s_name from product p left join supplier s on p.p_sno = s.s_no where p.p_name =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getpName());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return getSupName(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private String getSupName(ResultSet rs) throws SQLException {
		String supName = rs.getString("s_name");
		return supName;
	}

	public int selectProductCost(Connection conn, Product product) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select p.p_cost from product p left join supplier s on p.p_sno = s.s_no where p.p_name =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getpName());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return getpCost(rs);
			}
			return 0;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private int getpCost(ResultSet rs) throws SQLException {
		int pCost = rs.getInt("p_cost");
		return pCost;
	}

	public int selectProductNo(Connection conn, Product product) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select p_no from product where p_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getpName());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return getProductNo(rs);
			}
			return 0;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private int getProductNo(ResultSet rs) throws SQLException {
		int Pno = rs.getInt("p_no");
		return Pno;
	}

	public byte[] selectProductPic(Connection conn, Product product) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select p_pic from product where p_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getpName());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return getProductPic(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private byte[] getProductPic(ResultSet rs) throws SQLException {
		byte[] pic = rs.getBytes("p_pic");
		return pic;
	}

	public Product selectProductSummary(Connection conn, Product product) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select p_no, p_name, p_cost, p_price, p_qty from product where p_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getpName());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return getProductSum(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private Product getProductSum(ResultSet rs) throws SQLException {
		int pNo = rs.getInt("p_no");
		String pName = rs.getString("p_name");
		int pCost = rs.getInt("p_cost");
		int pPrice = rs.getInt("p_price");
		int pQty = rs.getInt("p_qty");
		return new Product(pNo, pName, pCost, pPrice, pQty);
	}

	public void subProductQty(Connection conn, Product subProduct, int sub) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update product set p_qty=? where p_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sub);
			pstmt.setString(2, subProduct.getpName());
			pstmt.executeUpdate();
			
		} finally {
			JDBCUtil.close(pstmt);
		}
	}
	
	public void updateOrder(Connection conn, Order order) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update `order` set o_date=?, o_cno=?, o_pno=?, o_qty=?, o_memo=?, o_dps=?, o_ok=?, o_eno=? where o_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setTimestamp(1, new Timestamp(order.getoDate().getTime()));
			pstmt.setInt(2, order.getoCname().getcNo()+1);
			pstmt.setInt(3, order.getoPname().getpNo()+1);
			pstmt.setInt(4, order.getoQty());
			pstmt.setString(5, order.getoMemo());
			pstmt.setInt(6, order.getoDps());
			pstmt.setInt(7, order.getoOk());
			pstmt.setInt(8, order.getoEname().getEmpNo()+1);
			pstmt.setInt(9, order.getoNo());
			pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}

	//아름 추가
	public Product selectProductByNo(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from product p left join category c on p.p_cate = c.cate_no left join supplier s on p.p_sno = s.s_no where p.p_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int pNo = rs.getInt("p_no");
				Category pCate = new Category(rs.getInt("cate_no"), rs.getString("cate_name"));
				String pName = rs.getString("p_name");
				int pCost = rs.getInt("p_cost");
				int pPrice = rs.getInt("p_price");
				Supplier pSno = new Supplier(rs.getInt("s_no"), rs.getString("s_name"), rs.getString("s_bln"), rs.getString("s_address"), rs.getString("s_tel"), rs.getString("s_fax"));
				int pQty = rs.getInt("p_qty");
				Date pDate = rs.getTimestamp("p_date");
				String pPicPath = rs.getString("p_picpath");
				return new Product(pNo, pCate, pName, pCost, pPrice, pSno, pQty, pDate, pPicPath);
			}
			return null;
		}finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
}
