package OhShu.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import OhShu.DAO.StayReviewDAO;
import OhShu.DAO.TourReviewDAO;
import OhShu.Util.DataBaseUtil;
import OhShu.vo.StayReviewVO;
import OhShu.vo.TourReviewVO;

public class TourReviewDAOImpl implements TourReviewDAO {
private final static TourReviewDAO instance = new TourReviewDAOImpl();
	
		
	
	public static TourReviewDAO getInstance() {
		return instance;
	}
	
	@Override
	public int InsertTourReview(TourReviewVO tour_review) {
		int result = 0;
		
		
		String sql="INSERT INTO tour_review (review_no, time, user_id, tour_no, review_content)\r\n"
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
			pstmt.setString(1, tour_review.getUser_id());
			pstmt.setInt(2, tour_review.getTour_no());
			pstmt.setString(3, tour_review.getReview_content());
			
			
			result = pstmt.executeUpdate();
			System.out.println("result -"+result);
			
		}catch(Exception e) {
			 e.printStackTrace();
		}
		return result;
		
	}
	
	@Override
	public int DeleteTourReview(TourReviewVO reviewdelete) {
		int result = 0;
		
		
		String sql="DELETE FROM tour_review WHERE review_no = ?";
				
		
	
		try(
			Connection conn = DataBaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			System.out.println(pstmt);
			pstmt.setInt(1, reviewdelete.getReview_no());
			
			
			result = pstmt.executeUpdate();
			System.out.println("result -"+result);
			
		}catch(Exception e) {
			 e.printStackTrace();
		}
		return result;
		
	}
	
	public int updateTourReview(TourReviewVO reviewupdate) {
		int result = 0;
		
		
		String sql="UPDATE tour_review SET review_content = ? WHERE review_no = ?";
				
		
	
		try(
			Connection conn = DataBaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			System.out.println(pstmt);
			pstmt.setString(1, reviewupdate.getReview_content());
			pstmt.setInt(2, reviewupdate.getReview_no());
			
			
			result = pstmt.executeUpdate();
			System.out.println("result -"+result);
			
		}catch(Exception e) {
			 e.printStackTrace();
		}
		return result;
		
	}


}