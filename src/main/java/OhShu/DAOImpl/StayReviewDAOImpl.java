package OhShu.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import OhShu.DAO.StayReviewDAO;
import OhShu.Util.DataBaseUtil;
import OhShu.vo.StayReviewVO;


public class StayReviewDAOImpl  implements StayReviewDAO{
	
	private final static StayReviewDAO instance = new StayReviewDAOImpl();
	
	public static StayReviewDAO getInstance() {
		return instance;
	}
	
	@Override
	public int InsertStayReview(StayReviewVO stay_review) {
		int result = 0;
	
		String sql="INSERT INTO stay_review ( review_no, time, user_id, stay_no, review_content)\r\n"
				+ "            VALUES ( \r\n"
				+ "            seq_review_no.nextval\r\n"
				+ "            ,to_char(sysdate,'yyyy.mm.dd hh24:mi') \r\n"
				+ "            ,?\r\n"
				+ "            ,?\r\n"
				+ "            ,?\r\n"
				+ "            )"
				;
	
		try(
			Connection conn = DataBaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			System.out.println(pstmt);
			pstmt.setString(1, stay_review.getUser_id());
			pstmt.setInt(2, stay_review.getStay_no());
			pstmt.setString(3, stay_review.getReview_content());
			
			
			result = pstmt.executeUpdate();
			System.out.println("result -"+result);
			
		}catch(Exception e) {
			 e.printStackTrace();
		}
		return result;
		
	}
	
	@Override
	public int DeleteStayReview(StayReviewVO reviewdelete) {
		int result = 0;
		
		String sql="DELETE FROM stay_review WHERE review_no = ?";
				
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
	
	public int updateStayReview(StayReviewVO reviewupdate) {
		int result = 0;
		
		String sql="UPDATE stay_review SET review_content = ? WHERE review_no = ?";	
		
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
