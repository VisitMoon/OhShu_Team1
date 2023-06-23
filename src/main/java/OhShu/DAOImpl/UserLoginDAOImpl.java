package OhShu.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import OhShu.DAO.UserLoginDAO;
import OhShu.vo.UserTableVO;
import OhShu.Util.DataBaseUtil;


public class UserLoginDAOImpl implements UserLoginDAO {

	private static final UserLoginDAO instance = new UserLoginDAOImpl();

	private UserLoginDAOImpl() {

	}

	public static UserLoginDAO getInstance() {
		return instance;
	}

	@Override
	public int selectCountUsertable(UserTableVO usertable) {

		int result = 0;
		String sql = "SELECT COUNT(1) FROM user_tb WHERE (user_id, user_pwd) IN ((?,?))";

		try (

				Connection conn = DataBaseUtil.getConnection(); // DBCP2Util
				PreparedStatement pstmt = conn.prepareStatement(sql);

		) {
			System.out.println(pstmt);
			String userid = usertable.getUser_id();

			pstmt.setString(1, usertable.getUser_id());
			pstmt.setString(2, usertable.getUser_pwd());
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				result = rs.getInt(1);
			}
			System.out.println(result+"명의 유저가 로그인함");
			System.out.println("\""+userid+"\" 님 로그인 성공");

		} catch (Exception e) {
			e.printStackTrace();

		}
		return result;
	}

	@Override
	public void selectUsertableByIdAndPw (UserTableVO usertable) {
		String sql = "SELECT * FROM user_tb WHERE (user_id, user_pwd) IN ((?,?))";

		try (

				Connection conn = DataBaseUtil.getConnection(); // DBCP2Util
				PreparedStatement pstmt = conn.prepareStatement(sql);

		) {
			System.out.println(pstmt);
			pstmt.setString(1, usertable.getUser_id());
			pstmt.setString(2, usertable.getUser_pwd());

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				usertable.setUser_name(rs.getString("user_name"));
				usertable.setUser_age(rs.getInt("age"));
				usertable.setUser_jumin(rs.getString("jumin"));

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}



}