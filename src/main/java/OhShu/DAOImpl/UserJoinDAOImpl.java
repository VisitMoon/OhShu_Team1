package OhShu.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import OhShu.DAO.UserJoinDAO;
import OhShu.vo.UserTableVO;
import OhShu.Util.DataBaseUtil;


public class UserJoinDAOImpl implements UserJoinDAO {
	
	private static final UserJoinDAO instance = new UserJoinDAOImpl();
	
	private UserJoinDAOImpl() {
		
	}
	
	public static UserJoinDAO getInstance() {
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
				
				Connection conn = DataBaseUtil.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql);

		) {
			pstmt.setString(1, usertable.getUser_id());
			pstmt.setString(2, usertable.getUser_pwd());
			pstmt.setString(3, usertable.getUser_name());
			pstmt.setInt(4, usertable.getUser_age());
			pstmt.setString(5, usertable.getUser_jumin());
			
			result = pstmt.executeUpdate();
			System.out.println(result+"명의 유저가 회원가입 완료");
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return result;
	}

}
