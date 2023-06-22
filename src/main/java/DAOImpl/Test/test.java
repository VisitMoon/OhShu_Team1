
package DAOImpl.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import OhShu.ServiceImpl.StayMainServiceImpl;
import OhShu.service.StayMainService;

class test {

	private final StayMainService service = StayMainServiceImpl.getInstance(); 
	   
	   @Test @Ignore
	   void testGetStay() {
	      int stay_no = 9739;
	      assertNotEquals(null, service.getStay(stay_no));
	      System.out.println(service.getStay(stay_no));
	}

}
