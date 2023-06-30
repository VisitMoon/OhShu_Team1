package OhShu.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import OhShu.DAO.StayReviewDAO;
import OhShu.Util.DBCP2Util;
import OhShu.vo.FoodReviewVO;
import OhShu.vo.StayReviewVO;


public class StayReviewDAOImpl  implements StayReviewDAO{
	
	private final static StayReviewDAO instance = new StayReviewDAOImpl();
	
	public static StayReviewDAO getInstance() {
		return instance;
	}
	
	@Override
	public int insertStayReview(StayReviewVO stayReview) {
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
			Connection conn = DBCP2Util.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			System.out.println(pstmt);
			pstmt.setString(1, stayReview.getUser_id());
			pstmt.setInt(2, stayReview.getStay_no());
			pstmt.setString(3, stayReview.getReview_content());
			
			
			result = pstmt.executeUpdate();
			System.out.println("result -"+result);
			
		}catch(Exception e) {
			 e.printStackTrace();
		}
		return result;
		
	}
	
	@Override
	 public void deleteTourReview(int review_no) {
       try (Connection conn = DBCP2Util.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM stay_review WHERE review_no=?")) {

           pstmt.setInt(1, review_no);

           pstmt.executeUpdate();
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
	
	public int updateStayReview(StayReviewVO stayReview) {
		int result = 0;
		
		String sql="UPDATE stay_review SET review_content = ? WHERE review_no = ?";	
		
		try(
			Connection conn = DBCP2Util.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			System.out.println(pstmt);
			pstmt.setString(1, stayReview.getReview_content());
			pstmt.setInt(2, stayReview.getReview_no());
			
			
			result = pstmt.executeUpdate();
			System.out.println("result -"+result);
			
		}catch(Exception e) {
			 e.printStackTrace();
		}
		return result;
		
	}public List<StayReviewVO> selectStayReview(int StayNo) {
        List<StayReviewVO> reviewList = new ArrayList<>();
        String sql = "SELECT review_no, review_content, user_id, time FROM stay_review WHERE stay_no = ?";

        try (Connection conn = DBCP2Util.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, StayNo);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    StayReviewVO reviewVO = new StayReviewVO();
                    reviewVO.setReview_no(rs.getInt("review_no"));
                    reviewVO.setReview_content(rs.getString("review_content"));
                    reviewVO.setUser_id(rs.getString("user_id"));
                    reviewVO.setTime(rs.getString("time"));
                    reviewList.add(reviewVO);
                }
            }
        }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return reviewList;
    }

}