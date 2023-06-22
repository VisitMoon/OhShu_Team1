package OhShu.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseUtil {
private static Connection connection;
	
	static {
		
		try {
			connection = connectionDB();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void destroyConnection() {
		if(connection != null) {
			try	{	connection.close();
					connection = null;
				}catch (SQLException e) {
				e.printStackTrace();
				}
		}
	}
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		System.out.println("connection -" + connection);
		if(connection == null || connection.isClosed()) {
			connection = connectionDB();
		}
			
		
		return connection;
	}
	public static Connection connectionDB() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String id = "C##OHSHU";
		String pwd= "ohshu";
		return DriverManager.getConnection(url,id,pwd);
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
////		System.out.println(connectionDB());
//		String id = "bang0008";
//		String pwd = "112233";
//		String sql = "SELECT COUNT(1) FROM member\n"
//				+ "WHERE id = '" + id + "'\n"
//					+" 			AND pwd = '"+ pwd + "'\n"
//					;
//		
//		
//		sql = "SELECT m_no\r\n"
//				+ "        ,name\r\n"
//				+ "        ,jumin\r\n"
//				+ "        ,id\r\n"
//				+ "   	 FROM member\r\n"
//				+ "		   ";
//		try(Connection conn = connectionDB();
//			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery(sql);
//			){
//			
//			List<MemberVO> memberList = new ArrayList<>();
//			while( rs.next()) {
//				MemberVO vo = new MemberVO();
//				vo.setM_no	(rs.getInt(1));
//				vo.setName	(rs.getString(2));
//				vo.setJumin	(rs.getString(3));
//				vo.setId	(rs.getString(4));
//				memberList.add(vo);
//			}
//			System.out.println(memberList);
////			System.out.println(conn);
////		
////			rs.next();
////			int cnt = rs.getInt(1);
////			if(cnt==1) {
////				System.out.println("로그인 성공");
////				
////			}else {
////				System.out.println("로그인 실패");
////			}
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
	}
	

}

