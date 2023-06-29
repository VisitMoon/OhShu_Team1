package OhShu.DAO;

import OhShu.vo.StayReviewVO;
import OhShu.vo.StayVO;


public interface StayReviewDAO {

	int insertStayReview(StayReviewVO stayReview);

	int deleteStayReview(StayReviewVO stayReview);

	int updateStayReview(StayReviewVO stayReview);

}
