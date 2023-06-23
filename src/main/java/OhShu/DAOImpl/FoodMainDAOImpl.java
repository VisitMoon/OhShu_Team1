package OhShu.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import OhShu.DAO.FoodMainDAO;
import OhShu.Util.DataBaseUtil;
import OhShu.vo.FoodVO;

public class FoodMainDAOImpl implements FoodMainDAO {

	private static final FoodMainDAO instance = new FoodMainDAOImpl();

	private FoodMainDAOImpl() {
	}

	public static FoodMainDAO getInstance() {
		return instance;
	}

	@Override
	public FoodVO selectFood(int food_no) {

		String sql = "SELECT food_no\r\n"
				+ "			,food_location\r\n"
				+ "			,food_source\r\n"
				+ "			,food_name\r\n"
				+ "			,food_sub_title\r\n"
				+ "			,food_address\r\n"
				+ "			,food_x\r\n"
				+ "			,food_y\r\n"
				+ "			,food_tel\r\n"
				+ "			,food_home_url\r\n"
				+"			,food_info\r\n"
				+ "			,food_img\r\n"
				+ "			FROM food WHERE food_no = ?\r\n"
 				;
		
		FoodVO food = null;

		try (
				Connection conn = DataBaseUtil.getConnection(); // DBCP2Util, DataBaseUtil
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			pstmt.setInt(1, food_no);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				food = new FoodVO();
				
				food.setFood_no(rs.getInt("food_no"));
				food.setFood_location(rs.getString("food_location"));
				food.setFood_source(rs.getString("food_source"));
				food.setFood_name(rs.getString("food_name"));
				food.setFood_sub_title(rs.getString("food_sub_title"));
				food.setFood_address(rs.getString("food_address"));
				food.setFood_x(rs.getString("food_x"));
				food.setFood_y(rs.getString("food_y"));
				food.setFood_tel(rs.getString("food_tel"));
				food.setFood_home_url(rs.getString("food_home_url"));
				food.setFood_info(rs.getString("food_info"));
				food.setFood_img(rs.getString("food_img"));
			
			}
			rs.close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return food;
	}
}
