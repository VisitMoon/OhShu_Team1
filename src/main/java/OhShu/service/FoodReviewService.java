package OhShu.service;

import OhShu.vo.FoodReviewVO;

public interface FoodReviewService {

	int registerFoodReview(FoodReviewVO foodReview);
	
	int deleteFoodReview(FoodReviewVO foodReview);
	
	int changeFoodReview(FoodReviewVO foodReview);
}
