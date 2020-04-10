package swsales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import swsales.jdbc.JDBCUtil;
import swsales.model.Board;

public class BoardDao {
	private static final BoardDao dao = new BoardDao();

	public static BoardDao getInstance() {
		return dao;
	}

	private BoardDao() {
	}

	//insertBoard
	public void insertBoard(Connection conn, Board board) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into board values(null,?,?,?,?,?,0,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getbId());
			pstmt.setString(2, board.getbName());
			pstmt.setString(3, board.getbTitle());
			pstmt.setTimestamp(4, new Timestamp(board.getbRegDate().getTime()));
			pstmt.setTimestamp(5, new Timestamp(board.getbModDate().getTime()));
			pstmt.setString(6, board.getbDept());
			pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}
	//insertBoardContent
	public void insertBoardContent(Connection conn, Board board) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into board_content values(last_insert_id(),?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getContent());
			pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}
	//listBoard
	public List<Board> listBoard(Connection conn) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from board order by b_no desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ArrayList<Board> list = new ArrayList<>();
			while(rs.next()) {
				Board board = new Board(rs.getInt(1), 
									    rs.getString(2), 
									    rs.getString(3), 
									    rs.getString(4), 
									    rs.getTimestamp(5), 
									    rs.getTimestamp(6), 
									    rs.getInt(7),
									    rs.getString(8));
				list.add(board);
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
	//listBoard(Paging)
		public List<Board> listBoardPaging(Connection conn, int page) throws SQLException{
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			int startNum = (page-1)*10+1;
			int endNum = page*10;
			
			try {
				String sql = "SELECT * from (SELECT @rownum:=@rownum+1 rnum, b.* from board b , (SELECT @ROWNUM := 0) R where 1=1 " 
						   + "order by b_no desc) list WHERE rnum >= ? AND rnum <=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startNum);
				pstmt.setInt(2, endNum);
				rs = pstmt.executeQuery();
				ArrayList<Board> list = new ArrayList<>();
				while(rs.next()) {
					Board board = new Board(rs.getInt("b_no"), 
										    rs.getString("b_id"), 
										    rs.getString("b_name"), 
										    rs.getString("b_title"), 
										    rs.getTimestamp("b_regdate"), 
										    rs.getTimestamp("b_moddate"), 
										    rs.getInt("b_read_cnt"),
										    rs.getString("b_dept"));
					list.add(board);
				}
				return list;
			} finally {
				JDBCUtil.close(rs);
				JDBCUtil.close(pstmt);
			}
		}
	//listBoard
		public List<Board> searchBoardList(Connection conn, String search) throws SQLException{
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				String sql = "select * from board where b_title like concat ('%', ?, '%') order by b_no desc";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, search);
				rs = pstmt.executeQuery();
				ArrayList<Board> list = new ArrayList<>();
				while(rs.next()) {
					Board board = new Board(rs.getInt(1), 
										    rs.getString(2), 
										    rs.getString(3), 
										    rs.getString(4), 
										    rs.getTimestamp(5), 
										    rs.getTimestamp(6), 
										    rs.getInt(7),
										    rs.getString(8));
					list.add(board);
				}
				return list;
			} finally {
				JDBCUtil.close(rs);
				JDBCUtil.close(pstmt);
			}
		}
	//updateBoard(title, moddate, read_cnt)만 수정
	public void updateBoard(Connection conn, Board board) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update board set b_title=?, b_moddate=?, b_read_cnt=? where b_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getbTitle());
			pstmt.setTimestamp(2, new Timestamp(board.getbModDate().getTime()));
			pstmt.setInt(3, board.getbReadCnt());
			pstmt.setInt(4, board.getbNo());
			pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}
	//updateBoardContent(content만 수정)
	public void updateBoardContent(Connection conn, Board board) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update board_content set bc_content=? where bc_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getContent());
			pstmt.setInt(2, board.getbNo());
			pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}
	//updateBoardReadCnt(read_cnt)만 수정
	public void updateBoardReadCnt(Connection conn, Board board) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			String sql = "update board set b_read_cnt=? where b_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getbReadCnt());
			pstmt.setInt(2, board.getbNo());
			pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}
	//deleteBoard
	public int deleteBoard(Connection conn, Board board) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from board where b_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getbNo());
			return pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}
	//deleteBoardContent
	public int deleteBoardContent(Connection conn, Board board) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from board_content where bc_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getbNo());
			return pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}
	//selectBoardByNo
	public Board selectBoardByNo(Connection conn, Board boa) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from board b join board_content c on b.b_no = c.bc_no where b.b_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boa.getbNo());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Board board = new Board(rs.getInt(1), 
											  rs.getString(2), 
											  rs.getString(3), 
											  rs.getString(4), 
											  rs.getTimestamp(5), 
											  rs.getTimestamp(6), 
											  rs.getInt(7),
											  rs.getString(8),
											  rs.getString(10));
				return board;
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
}
