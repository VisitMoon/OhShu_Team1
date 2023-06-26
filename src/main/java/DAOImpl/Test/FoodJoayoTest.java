package DAOImpl.Test;

import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

import OhShu.ServiceImpl.FoodJoayoServiceImpl;
import OhShu.service.FoodJoayoService;
import OhShu.vo.FoodJoayoVO;

public class FoodJoayoTest {
	private final FoodJoayoService service = FoodJoayoServiceImpl.getInstance();
	
	@Test
	void testPushJoayo() {
		FoodJoayoVO vo = new FoodJoayoVO();
		
		vo.setUser_id("jihol Park");
		vo.setFood_no(52021);
		vo.setJoayo(1);
		
		assertNotEquals(1, service.pushFoodJoayo(vo));
		System.out.println(vo);
	}
}
