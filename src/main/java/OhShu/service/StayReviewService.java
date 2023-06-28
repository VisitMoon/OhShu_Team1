package OhShu.service;

import OhShu.vo.StayReviewVO;

public interface StayReviewService {
	int registerStayReview(StayReviewVO stayReview);
	
	int deleteStayReview(StayReviewVO stayReview);
	
	int changeStayReview(StayReviewVO stayReview);
	
}
