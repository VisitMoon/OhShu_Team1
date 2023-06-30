package OhShu.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import OhShu.DAO.FoodMainDAO;
import OhShu.Util.DBCP2Util;
import OhShu.Util.DataBaseUtil;
import OhShu.vo.FoodMainVO;

public class FoodMainDAOImpl implements FoodMainDAO {

	private static final FoodMainDAO instance = new FoodMainDAOImpl();

	private FoodMainDAOImpl() {
	}

	public static FoodMainDAO getInstance() {
		return instance;
	}

	@Override
	public FoodMainVO selectFoodJoayoRank(int rank) {

		String sql = "SELECT food.food_no,food_name, food.food_img,joayo_amount\r\n"
				+ "FROM food\r\n"
				+ "JOIN (\r\n"
				+ "    SELECT food_no, SUM(joayo) as joayo_amount\r\n"
				+ "    FROM food_joayo\r\n"
				+ "    GROUP BY food_no\r\n"
				+ "    ORDER BY joayo_amount DESC\r\n"
				+ ") ranking_table\r\n"
				+ "ON food.food_no = ranking_table.food_no\r\n"
				+ "WHERE ranking_table.joayo_amount = ("
				+ "SELECT joayo_amount FROM (\r\n"
				+ "    SELECT food_no, SUM(joayo) as joayo_amount, ROW_NUMBER() OVER(ORDER BY SUM(joayo) DESC) as rank_idx\r\n"
				+ "    FROM food_joayo\r\n"
				+ "    GROUP BY food_no\r\n"
				+ ")\r\n"
				+ "WHERE rank_idx = ?)";
		
		FoodMainVO food = null;

		try (
				Connection conn = DBCP2Util.getConnection(); // DBCP2Util, DataBaseUtil
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			pstmt.setInt(1, rank);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				food = new FoodMainVO();
				
				food.setFood_no(rs.getInt("food_no"));
				food.setFood_name(rs.getString("food_name"));		
				food.setFood_img(rs.getString("food_img"));
				food.setJoayo_amount(rs.getInt("joayo_amount"));
			}
			rs.close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return food;
	}
}
