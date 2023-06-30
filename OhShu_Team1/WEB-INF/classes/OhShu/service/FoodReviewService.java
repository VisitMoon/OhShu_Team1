package OhShu.service;

import OhShu.vo.FoodReviewVO;

public interface FoodReviewService {

	int registerFoodReview(FoodReviewVO foodReview);
	
	void deleteFoodReview(int foodReview);
	
	int changeFoodReview(FoodReviewVO foodReview);
}
