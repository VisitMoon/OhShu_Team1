package OhShu.DAO;

import OhShu.vo.TourReviewVO;

public interface TourReviewDAO {

	int InsertTourReview(TourReviewVO tour_review);

	int DeleteTourReview(TourReviewVO reviewudelete);

	int updateTourReview(TourReviewVO reviewupdate);
}
