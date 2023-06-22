package OhShu.DAO;

import OhShu.vo.StayReviewVO;
import OhShu.vo.StayMainVO;

public interface StayReviewDAO {

	int InsertStayReview(StayReviewVO stay_review);

	int DeleteStayReview(StayReviewVO reviewdelete);

	int updateStayReview(StayReviewVO reviewupdate);

}
