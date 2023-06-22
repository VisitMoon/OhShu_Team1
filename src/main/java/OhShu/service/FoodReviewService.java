package OhShu.service;

import OhShu.vo.FoodReviewVO;

public interface FoodReviewService {

	int registerfood_reviewinsert(FoodReviewVO reviewinsert);
	
	int registerfood_reviewdelete(FoodReviewVO reviewdelete);
	
	int registerfood_reviewupdate(FoodReviewVO reviewupdate);
}
