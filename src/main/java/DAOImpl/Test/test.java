
package DAOImpl.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import OhShu.ServiceImpl.StayServiceImpl;
import OhShu.service.StayService;

class test {

	private final StayService service = StayServiceImpl.getInstance(); 
	   
	   
	   @Test 
	   void testGetStay() {
	      int stay_no = 9739;
	      assertNotEquals(null, service.getStay(stay_no));
	      System.out.println(service.getStay(stay_no));
	}

}
