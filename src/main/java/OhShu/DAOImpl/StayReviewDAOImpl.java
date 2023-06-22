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
		
		
		String sql="INSERT INTO stay_review \r\n"
				+ "(review_no, time, user_id, stay_no, review_content)\r\n"
				+ "VALUES (seq_review_no.nextval, to_Char(sysdate,'yyyy.mm.dd hh24:mi') ,'?', ?, '?')"
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
			
		}
		return result;

	}

}
