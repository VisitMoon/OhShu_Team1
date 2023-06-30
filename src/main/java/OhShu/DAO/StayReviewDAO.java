package OhShu.DAO;

import java.util.List;

import OhShu.vo.StayReviewVO;
import OhShu.vo.StayVO;


public interface StayReviewDAO {

	int insertStayReview(StayReviewVO stayReview);

	int updateStayReview(StayReviewVO stayReview);
	
	List<StayReviewVO> selectStayReview(int StayNo);

	void deleteTourReview(int review_no);

}
