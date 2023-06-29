package OhShu.DAO;

import OhShu.vo.TourReviewVO;

public interface TourReviewDAO {

	int insertTourReview(TourReviewVO tourReview);

	int deleteTourReview(TourReviewVO tourReview);

	int updateTourReview(TourReviewVO tourReview);
}
