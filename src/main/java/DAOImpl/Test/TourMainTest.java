package DAOImpl.Test;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import OhShu.ServiceImpl.TourMainServiceImpl;
import OhShu.service.TourMainService;
import OhShu.vo.TourMainVO;

public class TourMainTest {
	private final TourMainService service = TourMainServiceImpl.getInstance();
	
	@Test
	void testGetTourJoayoRank() {
		TourMainVO vo = new TourMainVO();
		
		System.out.println("1위");
		//assertNotEquals(1, service.getTourJoayoRanking(1));
		vo = service.getTourJoayoRanking(1);
		System.out.println(vo);
		
		System.out.println("2위");
		//assertNotEquals(1, service.getTourJoayoRanking(2));
		vo = service.getTourJoayoRanking(2);
		System.out.println(vo);
		
	}
}
