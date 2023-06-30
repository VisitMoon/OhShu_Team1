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
		
		vo.setUser_id("user05");
		vo.setFood_no(52011);
		vo.setJoayo(1);
		
		assertNotEquals(1, service.pushFoodJoayo(vo));
		System.out.println(vo);
	}
}
