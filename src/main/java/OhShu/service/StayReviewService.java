package OhShu.service;

import OhShu.vo.StayReviewVO;

public interface StayReviewService {
	int registerstay_reviewinsert(StayReviewVO reviewinsert);
	
	int registerstay_reviewdelete(StayReviewVO reviewdelete);
	
	int registerstay_reviewupdate(StayReviewVO reviewupdate);
	
}
