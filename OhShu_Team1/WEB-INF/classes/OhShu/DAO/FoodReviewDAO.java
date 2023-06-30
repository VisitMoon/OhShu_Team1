package OhShu.DAO;

import java.util.List;

import OhShu.vo.FoodReviewVO;

public interface FoodReviewDAO {

	int insertFoodReview(FoodReviewVO food_review);

	void deleteFoodReview(int food_review);
	
	int updateFoodReview(FoodReviewVO food_review); 

	List<FoodReviewVO> selectFoodReview(int foodNo);
}
