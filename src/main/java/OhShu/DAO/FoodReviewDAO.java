package OhShu.DAO;

import java.util.List;

import OhShu.vo.FoodReviewVO;

public interface FoodReviewDAO {

	int insertFoodReview(FoodReviewVO food_review);

	int deleteFoodReview(FoodReviewVO food_review);
	
	int updateFoodReview(FoodReviewVO food_review); 

	List<FoodReviewVO> selectFoodReviewListOf(int foodNo);
}
