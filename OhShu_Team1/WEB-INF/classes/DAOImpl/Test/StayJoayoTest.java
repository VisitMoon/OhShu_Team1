package DAOImpl.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import OhShu.ServiceImpl.StayJoayoServiceImpl;
import OhShu.service.StayJoayoService;
import OhShu.vo.StayJoayoVO;

public class StayJoayoTest {
	private final StayJoayoService service = StayJoayoServiceImpl.getInstance();
	
	@Test
	void testPushJoayo() {
		StayJoayoVO vo = new StayJoayoVO();
		
		vo.setUser_id("user05");
		vo.setStay_no(9854);
		vo.setJoayo(1);
		
		assertNotEquals(1, service.pushStayJoayo(vo));
		System.out.println(vo);
	}
}
