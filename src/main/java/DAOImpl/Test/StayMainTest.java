
package DAOImpl.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import OhShu.ServiceImpl.StayMainServiceImpl;
import OhShu.service.StayMainService;
import OhShu.vo.StayMainVO;

class StayMainTest {

	private final StayMainService service = StayMainServiceImpl.getInstance(); 
	   
	   @Test @Ignore
	   void testGetStayJoayoRank() {
	      
	      StayMainVO vo = new StayMainVO();
	      vo = service.getStayJoayoRanking(1);
	      System.out.println(vo);
	}

}
