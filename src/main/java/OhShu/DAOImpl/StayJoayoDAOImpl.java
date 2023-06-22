package OhShu.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import OhShu.DAO.StayJoayoDAO;
import OhShu.Util.DataBaseUtil;
import OhShu.vo.StayJoayoVO;

public class StayJoayoDAOImpl implements StayJoayoDAO{
	private final static StayJoayoDAO instance = new StayJoayoDAOImpl();
	
	public static StayJoayoDAO getInstance() {
		return instance;
	}
	
	@Override
	public int toggleStayJoayo(StayJoayoVO stayJoayo) {
		int result = 0;
				
		String sql="MERGE INTO stay_joayo sj\r\n"
				+ "USING (\r\n"
				+ "  SELECT ? AS userid, ? AS stayno, ? AS joayo FROM dual\r\n"
				+ ") push_joayo\r\n"
				+ "ON (sj.joayo = 1)\r\n"
				+ "WHEN MATCHED THEN\r\n"
				+ "  DELETE\r\n"
				+ "WHEN NOT MATCHED THEN\r\n"
				+ "  INSERT (user_id, stay_no, joayo)\r\n"
				+ "  VALUES (push_joayo.userid, push_joayo.stayno, push_joayo.joayo);"
				;
		
	
		try(
			Connection conn = DataBaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			System.out.println(pstmt);
			String user_id = stayJoayo.getUser_id();
			int stay_no = stayJoayo.getStay_no();
			pstmt.setString(1, user_id);
			pstmt.setInt(2, stay_no);
			pstmt.setInt(3, stayJoayo.getJoayo());
			
			result = pstmt.executeUpdate();
			System.out.println(user_id+" 님 "+ stay_no + " 번 숙소 좋아요 버튼누름");
			
		}catch(Exception e) {
			
		}
		return result;

	}
}
