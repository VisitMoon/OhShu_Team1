package OhShu.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import OhShu.DAO.TourReviewDAO;
import OhShu.Util.DBCP2Util;
import OhShu.Util.DataBaseUtil;
import OhShu.vo.TourReviewVO;
import OhShu.vo.TourVO;

public class TourReviewDAOImpl implements TourReviewDAO {
private final static TourReviewDAO instance = new TourReviewDAOImpl();
	
		
	
	public static TourReviewDAO getInstance() {
		return instance;
	}
	
	@Override
	public int insertTourReview(TourReviewVO tourReview) {
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
			pstmt.setString(1, tourReview.getUser_id());
			pstmt.setInt(2, tourReview.getTour_no());
			pstmt.setString(3, tourReview.getReview_content());
			
			
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
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM tour_review WHERE review_no=?")) {

           pstmt.setInt(1, review_no);

           pstmt.executeUpdate();
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
	
	public int updateTourReview(TourReviewVO tourReview) {
		int result = 0;
		
		
		String sql="UPDATE tour_review SET review_content = ? WHERE review_no = ?";
				
		
	
		try(
			Connection conn = DataBaseUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			System.out.println(pstmt);
			pstmt.setString(1, tourReview.getReview_content());
			pstmt.setInt(2, tourReview.getReview_no());
			
			
			result = pstmt.executeUpdate();
			System.out.println("result -"+result);
			
		}catch(Exception e) {
			 e.printStackTrace();
		}
		return result;
		
	}
	public List<TourReviewVO> selectTourReview(int tourNo) {
        List<TourReviewVO> reviewList = new ArrayList<>();
        String sql = "SELECT review_no, review_content, user_id, time FROM tour_review WHERE tour_no = ?";

        try (Connection conn = DataBaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, tourNo);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    TourReviewVO reviewVO = new TourReviewVO();
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
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        return reviewList;
    }

}

