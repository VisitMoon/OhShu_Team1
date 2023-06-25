package OhShu.DAO;

import OhShu.vo.FoodJoayoVO;
import OhShu.vo.StayJoayoVO;

public interface FoodJoayoDAO {
	int toggleFoodJoayo(FoodJoayoVO foodJoayo);
	int selectFoodJoayo(FoodJoayoVO foodJoayo);
	int insertFoodJoayo(FoodJoayoVO foodJoayo);
	int deleteFoodJoayo(FoodJoayoVO foodJoayo);
}
