package OhShu.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import OhShu.DAO.TourJoayoDAO;
import OhShu.Util.DBCP2Util;
import OhShu.vo.TourJoayoVO;

public class TourJoayoDAOImpl implements TourJoayoDAO {
	private final static TourJoayoDAO instance = new TourJoayoDAOImpl();

	public static TourJoayoDAO getInstance() {
		return instance;
	}

	@Override
	public int toggleTourJoayo(TourJoayoVO TourJoayo) {
		int result = 0;
		
		int joayo_flag = selectTourJoayo(TourJoayo);
		switch(joayo_flag) {
		case 0:
			result = insertTourJoayo(TourJoayo);
			System.out.println("좋아요 " + result +"개를 눌렀습니다");
			break;
		case 1:
			result = deleteTourJoayo(TourJoayo);
			System.out.println("좋아요 " + result +"개를 취소했습니다");
			break;
		}
		
		return result;
	}
	@Override
	public int selectTourJoayo(TourJoayoVO TourJoayo) {
		int result = 0;
		
		String sql = "SELECT * from tour_joayo where user_id = ? and tour_no = ? and joayo = ?";
		
		try (Connection conn = DBCP2Util.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

			String user_id = TourJoayo.getUser_id();
			int tour_no = TourJoayo.getTour_no();
			pstmt.setString(1, user_id);
			pstmt.setInt(2, tour_no);
			pstmt.setInt(3, TourJoayo.getJoayo());

			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insertTourJoayo(TourJoayoVO TourJoayo) {
		int result = 0;

		String sql = "INSERT INTO tour_joayo ( user_id, tour_no, joayo)\r\n" 
		+ "            VALUES ( \r\n"			
		+ "             ?\r\n" 
		+ "            ,?\r\n" 
		+ "            ,?\r\n" 
		+ "            )";
		
		try (Connection conn = DBCP2Util.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			System.out.println("insert문 들어옴");
			String user_id = TourJoayo.getUser_id();
			int tour_no = TourJoayo.getTour_no();
			System.out.println(user_id +" " +tour_no);
			pstmt.setString(1, user_id);
			pstmt.setInt(2, tour_no);
			pstmt.setInt(3, TourJoayo.getJoayo());

			result = pstmt.executeUpdate();
			System.out.println(user_id + " 님 " + tour_no + "번 tour 좋아요 +" + result);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public int deleteTourJoayo(TourJoayoVO TourJoayo) {
		int result = 0;

		String sql = "DELETE FROM tour_joayo WHERE user_id = ? and tour_no = ?";

		try (Connection conn = DBCP2Util.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			String user_id = TourJoayo.getUser_id();
			int tour_no = TourJoayo.getTour_no();
			pstmt.setString(1, user_id);
			pstmt.setInt(2, tour_no);

			result = pstmt.executeUpdate();

			System.out.println(user_id + " 님 " + tour_no + "번 tour 좋아요 -" + result);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
}
