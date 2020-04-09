package swsales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import swsales.jdbc.JDBCUtil;
import swsales.model.Client;

public class ClientDao {
	private static final ClientDao dao = new ClientDao();

	public static ClientDao getInstance() {
		return dao;
	}

	private ClientDao() {
	}

	public Client selectClientByNo(Connection conn, Client client) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select c_no, c_name, c_ceo, c_address, c_tel, c_id, c_mail, c_date, c_salesman, e.e_name from client c left join employee e on c.c_salesman = e.e_no where c_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, client.getcNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Client client1 = new Client(rs.getInt("c_no"), 
										   rs.getString("c_name"), 
										   rs.getString("c_ceo"), 
										   rs.getString("c_address"), 
										   rs.getString("c_tel"), 
										   rs.getString("c_id"), 
										   rs.getString("c_mail"), 
										   rs.getString("c_date"), 
										   rs.getInt("c_salesman"),
										   rs.getString("e_name"));
				return client1;
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
		
	}

	private Client getClient(ResultSet rs) throws SQLException {
		int cNo = rs.getInt("c_no");
		String cName = rs.getString("c_name");
		String cCeo = rs.getString("c_ceo");
		String cAddress = rs.getString("c_address");
		String cTel = rs.getString("c_tel");
		String cId = rs.getString("c_id");
		String cMail = rs.getString("c_mail");
		String cDate = rs.getString("c_date");
		int cSalesman = rs.getInt("c_salesman");
		String cSman = rs.getString("e_name");
		return new Client(cNo, cName, cCeo, cAddress, cTel, cId, cMail, cDate, cSalesman, cSman);
	}
	
	private Client getClient2(ResultSet rs) throws SQLException {
		int cNo = rs.getInt("c_no");
		String cName = rs.getString("c_name");
		String cCeo = rs.getString("c_ceo");
		String cAddress = rs.getString("c_address");
		String cTel = rs.getString("c_tel");
		String cId = rs.getString("c_id");
		String cPw = rs.getString("c_pw");
		String cMail = rs.getString("c_mail");
		String cDate = rs.getString("c_date");
		int cSalesman = rs.getInt("c_salesman");
		return new Client(cNo, cName, cCeo, cAddress, cTel, cId, cPw, cMail, cDate, cSalesman);
	}

	public List<Client> selectClientByAll(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select c_no, c_name, c_ceo, c_address, c_tel, c_id, c_mail, c_date, c_salesman, e.e_name from client c left join employee e on c.c_salesman = e.e_no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Client> list = new ArrayList<Client>();
			while (rs.next()) {
				list.add(getClient(rs));
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	public void insertClient(Connection conn, Client client) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into client values(?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, client.getcNo());
			pstmt.setString(2, client.getcName());
			pstmt.setString(3, client.getcCeo());
			pstmt.setString(4, client.getcAddress());
			pstmt.setString(5, client.getcTel());
			pstmt.setString(6, client.getcId());
			pstmt.setString(7, client.getcPw());
			pstmt.setString(8, client.getcMail());
			pstmt.setString(9, client.getcDate());
			pstmt.setInt(10, client.getcSalesman());
			pstmt.executeUpdate();
			
		} finally {
			JDBCUtil.close(pstmt);
		}
	}

	public void updateClient(Connection conn, Client client) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update client set c_name=?, c_ceo=?, c_address=?, c_tel=?, c_salesman=? where c_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, client.getcName());
			pstmt.setString(2, client.getcCeo());
			pstmt.setString(3, client.getcAddress());
			pstmt.setString(4, client.getcTel());
			pstmt.setInt(5, client.getcSalesman());
			pstmt.setInt(6, client.getcNo());
			pstmt.executeUpdate();
			
		} finally {
			JDBCUtil.close(pstmt);
		}
	}

	public void deleteClient(Connection conn, Client client) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "delete from client where c_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, client.getcNo());
			pstmt.executeUpdate();
			
		} finally {
			JDBCUtil.close(pstmt);
		}
	}

	public Client selectClientLastData(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select c_no from client order by c_no desc limit 1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return getCNo(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private Client getCNo(ResultSet rs) throws SQLException {
		int cNo = rs.getInt("c_no");
		return new Client(cNo);
	}

	public List<Client> selectClientListByName(Connection conn, Client selectClient) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select c_no, c_name, c_ceo, c_address, c_tel, c_salesman, e.e_name from client c left join employee e on c.c_salesman = e.e_no where c_name like concat ('%', ?, '%')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, selectClient.getcName());
			rs = pstmt.executeQuery();
			List<Client> list = new ArrayList<Client>();
			while (rs.next()) {
				list.add(getClient1(rs));
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	public List<Client> selectClientListByCeo(Connection conn, Client selectClient) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select c_no, c_name, c_ceo, c_address, c_tel, c_salesman, e.e_name from client c left join employee e on c.c_salesman = e.e_no where c_ceo like concat ('%', ?, '%')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, selectClient.getcCeo());
			rs = pstmt.executeQuery();
			List<Client> list = new ArrayList<Client>();
			while (rs.next()) {
				list.add(getClient1(rs));
			}
			return list;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	public List<Client> selectClientListByTel(Connection conn, Client selectClient) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select c_no, c_name, c_ceo, c_address, c_tel, c_salesman, e.e_name from client c left join employee e on c.c_salesman = e.e_no where c_tel like concat ('%', ?, '%')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, selectClient.getcTel());
			rs = pstmt.executeQuery();
			List<Client> list = new ArrayList<Client>();
			while (rs.next()) {
				list.add(getClient1(rs));
			}
			return list;
			
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	public List<Client> selectClientListBySalesman(Connection conn, Client selectClient) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select c_no, c_name, c_ceo, c_address, c_tel, c_salesman, e.e_name from client c left join employee e on c.c_salesman = e.e_no where c_salesman=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, selectClient.getcSalesman());
			rs = pstmt.executeQuery();
			List<Client> list = new ArrayList<Client>();
			while (rs.next()) {
				list.add(getClient1(rs));
			}
			return list;
			
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
	
	public List<Client> selectClientPaging(Connection conn, int page) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//1번 페이지 1~10
        //2번 페이지 11~20        
        int startNum = (page-1)*10+1;
        int endNum = page*10;
        
        try{
        	 String sql = "select c_no, c_name, c_ceo, c_address, c_tel, c_id, c_mail, c_date, c_salesman, e.e_name from " 
                        + "(SELECT @rownum:=@rownum+1 rnum, c.* from client c, (SELECT @ROWNUM := 0) R where 1=1) list left " 
        			    + "join employee e on e.e_no = c_salesman WHERE rnum >= ? AND rnum <= ?";
        	List<Client> list = new ArrayList<Client>();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, startNum);
            pstmt.setInt(2, endNum);
            rs = pstmt.executeQuery();
            while(rs.next()){
            	list.add(getClient(rs));
            }
            return list;
        }finally{
            JDBCUtil.close(rs);
            JDBCUtil.close(pstmt);
        }
	}

	public Client selectClientByName(Connection conn, Client client) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select c_no, c_name, c_ceo, c_address, c_tel, c_salesman, e.e_name from client c left join employee e on c.c_salesman = e.e_no where c_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, client.getcName());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return getClient1(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private Client getClient1(ResultSet rs) throws SQLException {
		int cNo = rs.getInt("c_no");
		String cName = rs.getString("c_name");
		String cCeo = rs.getString("c_ceo");
		String cAddress = rs.getString("c_address");
		String cTel = rs.getString("c_tel");
		int cSalesman = rs.getInt("c_salesman");
		String cSman = rs.getString("e_name");
		return new Client(cNo, cName, cCeo, cAddress, cTel, cSalesman, cSman);
	}

	public String selectClientsEmpName(Connection conn, Client client) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select e_name from employee e left join client c on e.e_no=c.c_salesman where c.c_salesman=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, client.getcSalesman());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return getEmpName(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private String getEmpName(ResultSet rs) throws SQLException {
		String empName = rs.getString("e_name");
		return empName;
	}

	public int selectClientsEmpNo(Connection conn, String empName) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select e_no from employee where e_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return getEmpNo(rs);
			}
			return 0;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private int getEmpNo(ResultSet rs) throws SQLException {
		int empNo = rs.getInt("e_no");
		return empNo;
	}

	public int selectClientNo(Connection conn, Client client) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select c_no from client where c_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, client.getcName());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return getClientNo(rs);
			}
			return 0;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private int getClientNo(ResultSet rs) throws SQLException {
		int Cno = rs.getInt("c_no");
		return Cno;
	}

	public int selectCsalesman(Connection conn, Client client) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select c_salesman from client where c_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, client.getcName());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return getSalesman(rs);
			}
			return 0;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	private int getSalesman(ResultSet rs) throws SQLException {
		int cSman = rs.getInt("c_salesman");
		return cSman;
	}

	
	/***************************************************************************************** (+) 추가 QUERY : 아름  *****************************************************************************************/
	
	public Client loginClient(Connection conn, Client client) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select c_no, c_name, c_ceo, c_address, c_tel, c_id, c_pw, c_mail, c_date, c_salesman  from client where c_id = ? and c_pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, client.getcId());
			pstmt.setString(2, client.getcPw());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return getClient2(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}

	public String selectClientById(Connection conn, String idChk) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select c_id from client where c_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idChk);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return getClientID(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
	
	public Client selectClientByID2(Connection conn, Client client) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select c_id from client where c_no=? and c_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, client.getcNo());
			pstmt.setString(2, client.getcName());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return getClientID2(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
	
	public Client selectClientByMail(Connection conn, Client client) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select c_no, c_name, c_id, c_mail from client where c_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, client.getcId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return getClientMail(rs);
			}
			return null;
		} finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
	}
	
	public int updateClientPassword(Connection conn, Client client) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "update client set c_pw = ? where c_no = ? and c_name = ? and c_id = ? and c_mail = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, client.getcPw());
			pstmt.setInt(2, client.getcNo());
			pstmt.setString(3, client.getcName());
			pstmt.setString(4, client.getcId());
			pstmt.setString(5, client.getcMail());
			return pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}
	

	
	/***************************************************************************************** (+) 추가 GET : 아름 *****************************************************************************************/
		
	private String getClientID(ResultSet rs) throws SQLException {
		if(rs.getString("c_id") == null) {
			return null;
		}else {
			return rs.getString("c_id");
		}
	}

	private Client getClientID2(ResultSet rs) throws SQLException {
		String cId = rs.getString("c_id");
		String cPw = null;
		return new Client(cId, cPw);
	}

	private Client getClientMail(ResultSet rs) throws SQLException {
		int cNo = rs.getInt("c_no");
		String cName = rs.getString("c_name");
		String cId = rs.getString("c_id");
		String cMail = rs.getString("c_mail");
		return new Client(cNo, cName, cId, cMail);
	}
}
