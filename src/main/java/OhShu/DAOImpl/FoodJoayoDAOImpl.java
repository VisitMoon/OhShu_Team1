package OhShu.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import OhShu.DAO.FoodJoayoDAO;
import OhShu.Util.DBCP2Util;
import OhShu.vo.FoodJoayoVO;

public class FoodJoayoDAOImpl implements FoodJoayoDAO{
	private final static FoodJoayoDAO instance = new FoodJoayoDAOImpl();

	public static FoodJoayoDAO getInstance() {
		return instance;
	}

	@Override
	public int toggleFoodJoayo(FoodJoayoVO foodJoayo) {
		int result = 0;
		
		int joayo_flag = selectFoodJoayo(foodJoayo);
		switch(joayo_flag) {
		case 0:
			result = insertFoodJoayo(foodJoayo);
			System.out.println("좋아요 " + result +"개를 눌렀습니다");
			break;
		case 1:
			result = deleteFoodJoayo(foodJoayo);
			System.out.println("좋아요 " + result +"개를 취소했습니다");
			break;
		}
		
		return result;
	}
	@Override
	public int selectFoodJoayo(FoodJoayoVO foodJoayo) {
		int result = 0;
		
		String sql = "SELECT * from Food_joayo where user_id = ? and Food_no = ? and joayo = ?";

		try (Connection conn = DBCP2Util.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

			String user_id = foodJoayo.getUser_id();
			int food_no = foodJoayo.getFood_no();
			pstmt.setString(1, user_id);
			pstmt.setInt(2, food_no);
			pstmt.setInt(3, foodJoayo.getJoayo());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insertFoodJoayo(FoodJoayoVO foodJoayo) {
		int result = 0;

		String sql = "INSERT INTO Food_joayo ( user_id, Food_no, joayo)\r\n" 
		+ "            VALUES ( \r\n"			
		+ "             ?\r\n" 
		+ "            ,?\r\n" 
		+ "            ,?\r\n" 
		+ "            )";

		try (Connection conn = DBCP2Util.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

			String user_id = foodJoayo.getUser_id();
			int food_no = foodJoayo.getFood_no();
			System.out.println(user_id +" " +food_no);
			pstmt.setString(1, user_id);
			pstmt.setInt(2, food_no);
			pstmt.setInt(3, foodJoayo.getJoayo());

			result = pstmt.executeUpdate();

			System.out.println(user_id + " 님 " + food_no + "번 Food 좋아요 +" + result);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	@Override
	public int deleteFoodJoayo(FoodJoayoVO foodJoayo) {
		int result = 0;

		String sql = "DELETE FROM Food_joayo WHERE user_id = ? and Food_no = ?";

		try (Connection conn = DBCP2Util.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

			String user_id = foodJoayo.getUser_id();
			int food_no = foodJoayo.getFood_no();
			pstmt.setString(1, user_id);
			pstmt.setInt(2, food_no);

			result = pstmt.executeUpdate();

			System.out.println(user_id + " 님 " + food_no + "번 Food 좋아요 +" + result);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
}
