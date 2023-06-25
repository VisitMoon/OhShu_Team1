
package DAOImpl.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import OhShu.ServiceImpl.FoodMainServiceImpl;
import OhShu.service.FoodMainService;
import OhShu.vo.FoodMainVO;

class FoodMainTest {

	private final FoodMainService service = FoodMainServiceImpl.getInstance(); 
	   
	   @Test @Ignore
	   void testGetFoodJoayoRank() {
	      
	      FoodMainVO vo = new FoodMainVO();
	      vo = service.getFoodJoayoRanking(1);
	      System.out.println(vo);
	}

}
