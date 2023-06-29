package DAOImpl.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import OhShu.ServiceImpl.TourJoayoServiceImpl;
import OhShu.service.TourJoayoService;
import OhShu.vo.TourJoayoVO;

public class TourJoayoTest {
	private final TourJoayoService service = TourJoayoServiceImpl.getInstance();
	
	@Test
	void testPushJoayo() {
		TourJoayoVO vo = new TourJoayoVO();
		
		vo.setUser_id("user05");
		vo.setTour_no(50469);
		vo.setJoayo(1);
		
		assertNotEquals(1, service.pushTourJoayo(vo));
		System.out.println(vo);
	}
}
