package OhShu.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java.ohshu.servlet.dao.LoginDAO;
import com.java.ohshu.sevlet.vo.UserTableVO;
import com.java.servlet.util.DBCP2Util;
import com.java.servlet.util.DataBaseUtil;


public class LoginDAOImpl implements LoginDAO {

	private static final LoginDAO instance = new LoginDAOImpl();

	private LoginDAOImpl() {

	}

	public static LoginDAO getInstance() {
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
			pstmt.setString(1, usertable.getUser_id());
			pstmt.setString(2, usertable.getUser_pwd());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
			System.out.println("result - " + result);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return result;
	}

	@Override
	public void selectUsertableByIdAndPw (UserTableVO usertable) {
		String sql = "SELECT * FROM user_tb WHERE (user_id, user_pwd) IN ((?,?))";

		try (

				Connection conn = DBCP2Util.getConnection(); // DBCP2Util
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
