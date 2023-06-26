package OhShu.service;

import java.util.List;
import OhShu.vo.FoodVO;

public interface FoodService {
	FoodVO getFood(int Food_no);
	
	List<FoodVO> getFoodList();
}
