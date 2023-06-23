package OhShu.DAO;

import OhShu.vo.StayReviewVO;

public interface StayReviewDAO {

	int InsertStayReview(StayReviewVO stay_review);

	int DeleteStayReview(StayReviewVO reviewdelete);

	int updateStayReview(StayReviewVO reviewupdate);

}
