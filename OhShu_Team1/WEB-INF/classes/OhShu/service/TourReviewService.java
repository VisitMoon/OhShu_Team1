package OhShu.service;

import OhShu.vo.TourReviewVO;

public interface TourReviewService {

	int registerTourReview(TourReviewVO tourReview);
	
	int changeTourReview(TourReviewVO tourReview);
	
	void deleteTourReview(int review_no);
}
