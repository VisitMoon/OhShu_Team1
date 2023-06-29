package OhShu.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import OhShu.DAO.FoodReviewDAO;
import OhShu.DAO.StayReviewDAO;
import OhShu.Util.DataBaseUtil;
import OhShu.vo.FoodReviewVO;
import OhShu.vo.StayReviewVO;

public class FoodReviewDAOImpl implements FoodReviewDAO {

private final static FoodReviewDAO instance = new FoodReviewDAOImpl();
	
		
	
	public static FoodReviewDAO getInstance() {
		return instance;
	}
	
	@Override
	public int insertFoodReview(FoodReviewVO food_review) {
		int result = 0;
		
		
		String sql="INSERT INTO food_review (review_no, time, user_id, food_no, review_content)\r\n"
				+ "								  VALUES (\r\n"
				+ "								 seq_review_no.nextval\r\n"
				+ "								 ,to_Char(sysdate,'yyyy.mm.dd hh24:mi')\r\n"
				+ "								 ,?\r\n"
				+ "								 ,?\r\n"
				+ "								 ,?\r\n"
				+ "                 )";
				
		
	
		try(
			Connection conn = DataBaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			System.out.println(pstmt);
			pstmt.setString(1, food_review.getUser_id());
			pstmt.setInt(2, food_review.getFood_no());
			pstmt.setString(3, food_review.getReview_content());
			
			
			result = pstmt.executeUpdate();
			System.out.println("result -"+result);
			
		}catch(Exception e) {
			 e.printStackTrace();
		}
		return result;
		
	}
	
	@Override
	public int deleteFoodReview(FoodReviewVO food_review) {
		int result = 0;
		
		
		String sql="DELETE FROM food_review WHERE review_no = ?";
				
		
	
		try(
			Connection conn = DataBaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			System.out.println(pstmt);
			pstmt.setInt(1, food_review.getReview_no());
			
			
			result = pstmt.executeUpdate();
			System.out.println("result -"+result);
			
		}catch(Exception e) {
			 e.printStackTrace();
		}
		return result;
		
	}
	
	public int updateFoodReview(FoodReviewVO food_review) {
		int result = 0;
		
		
		String sql="UPDATE food_review SET review_content = ? WHERE review_no = ?";
				
		
	
		try(
			Connection conn = DataBaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			System.out.println(pstmt);
			pstmt.setString(1, food_review.getReview_content());
			pstmt.setInt(2, food_review.getReview_no());
			
			
			result = pstmt.executeUpdate();
			System.out.println("result -"+result);
			
		}catch(Exception e) {
			 e.printStackTrace();
		}
		return result;
		
	}


}

