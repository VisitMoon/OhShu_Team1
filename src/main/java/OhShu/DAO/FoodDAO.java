package OhShu.DAO;

import java.util.List;

import OhShu.vo.FoodVO;

public interface FoodDAO {
	FoodVO selectFood(int food_no);
	
	List<FoodVO> selectFoodList();
}
