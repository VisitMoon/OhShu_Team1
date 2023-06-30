package OhShu.service;

import OhShu.vo.StayReviewVO;

public interface StayReviewService {
	int registerStayReview(StayReviewVO stayReview);
	
	void deleteStayReview(int stayReview);
	
	int changeStayReview(StayReviewVO stayReview);
	
}
