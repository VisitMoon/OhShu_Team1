package OhShu.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.java.ohshu.servlet.dao.JoinDAO;
import com.java.ohshu.sevlet.vo.UserTableVO;
import com.java.servlet.util.DBCP2Util;
import com.java.servlet.util.DataBaseUtil;


public class JoinDAOImpl implements JoinDAO {
	
	private static final JoinDAO instance = new JoinDAOImpl();
	
	private JoinDAOImpl() {
		
	}
	
	public static JoinDAO getInstance() {
		return instance;
	}

	@Override
	public int insertUsertable(UserTableVO usertable) {

		int result =0;
		String sql = "INSERT INTO user_tb (user_id, user_pwd, user_name, user_age, user_jumin)\r\n"
				+ "                    VALUES(  ?\r\n"
				+ "                            ,?\r\n"
				+ "                            ,?\r\n"
				+ "                            ,?\r\n"
				+ "                            ,?\r\n"
				+ "                            )";

		try (
				
				Connection conn = DBCP2Util.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql);

		) {
			pstmt.setString(1, usertable.getUser_id());
			pstmt.setString(2, usertable.getUser_pwd());
			pstmt.setString(3, usertable.getUser_name());
			pstmt.setInt(4, usertable.getUser_age());
			pstmt.setString(5, usertable.getUser_jumin());
			
			result = pstmt.executeUpdate();
			System.out.println("result - " + result);
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return result;
	}

}
