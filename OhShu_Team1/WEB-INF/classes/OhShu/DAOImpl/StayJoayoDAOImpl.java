package OhShu.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import OhShu.DAO.StayJoayoDAO;
import OhShu.Util.DataBaseUtil;
import OhShu.vo.StayJoayoVO;
import OhShu.vo.StayReviewVO;

public class StayJoayoDAOImpl implements StayJoayoDAO {
	private final static StayJoayoDAO instance = new StayJoayoDAOImpl();

	public static StayJoayoDAO getInstance() {
		return instance;
	}

	@Override
	public int toggleStayJoayo(StayJoayoVO stayJoayo) {
		int result = 0;
				
		String sql="MERGE INTO stay_joayo sj\r\n"
				+ "				USING (\r\n"
				+ "  			SELECT ? AS user_id, ? AS stay_no, ? AS joayo FROM dual\r\n"
				+ "				) push_joayo\r\n"
				+ "				ON (sj.joayo = 1)\r\n"
				+ "				WHEN MATCHED THEN\r\n"
				+ "				DELETE\r\n"
				+ "				WHEN NOT MATCHED THEN\r\n"
				+ "				INSERT (user_id, stay_no, joayo)\r\n"
				+ "  VALUES (push_joayo.userid, push_joayo.stayno, push_joayo.joayo)"
				;
	
		int joayo_flag = selectStayJoayo(stayJoayo);
		switch(joayo_flag) {
		case 0:
			result = insertStayJoayo(stayJoayo);
			System.out.println("좋아요 " + result +"개를 눌렀습니다");
			break;
		case 1:
			result = deleteStayJoayo(stayJoayo);
			System.out.println("좋아요 " + result +"개를 취소했습니다");
			break;
		}
		
		return result;
	}
	@Override
	public int selectStayJoayo(StayJoayoVO stayJoayo) {
		int result = 0;
		
		String sql = "SELECT * from stay_joayo where user_id = ? and stay_no = ? and joayo = ?";

		try (Connection conn = DataBaseUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

			String user_id = stayJoayo.getUser_id();
			int stay_no = stayJoayo.getStay_no();
			pstmt.setString(1, user_id);
			pstmt.setInt(2, stay_no);
			pstmt.setInt(3, stayJoayo.getJoayo());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insertStayJoayo(StayJoayoVO stayJoayo) {
		int result = 0;

		String sql = "INSERT INTO stay_joayo ( user_id, stay_no, joayo)\r\n" 
		+ "            VALUES ( \r\n"			
		+ "             ?\r\n" 
		+ "            ,?\r\n" 
		+ "            ,?\r\n" 
		+ "            )";

		try (Connection conn = DataBaseUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

			String user_id = stayJoayo.getUser_id();
			int stay_no = stayJoayo.getStay_no();
			System.out.println(user_id +" " +stay_no);
			pstmt.setString(1, user_id);
			pstmt.setInt(2, stay_no);
			pstmt.setInt(3, stayJoayo.getJoayo());

			result = pstmt.executeUpdate();

			System.out.println(user_id + " 님 " + stay_no + "번 stay 좋아요 +" + result);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public int deleteStayJoayo(StayJoayoVO stayJoayo) {
		int result = 0;

		String sql = "DELETE FROM stay_joayo WHERE user_id = ? and stay_no = ?";

		try (Connection conn = DataBaseUtil.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

			String user_id = stayJoayo.getUser_id();
			int stay_no = stayJoayo.getStay_no();
			pstmt.setString(1, user_id);
			pstmt.setInt(2, stay_no);

			result = pstmt.executeUpdate();

			System.out.println(user_id + " 님 " + stay_no + "번 stay 좋아요 -" + result);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
}
