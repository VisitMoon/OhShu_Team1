package OhShu.DAO;

import OhShu.vo.FoodReviewVO;

public interface FoodReviewDAO {

	int InsertFoodReview(FoodReviewVO food_review);

	int DeleteFoodReview(FoodReviewVO reviewdelete);
	
	int updateFoodReview(FoodReviewVO reviewupdate); 

}
