package DAOImpl.Test;



import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

import OhShu.ServiceImpl.StayReviewServiceImpl;
import OhShu.service.StayReviewService;
import OhShu.vo.StayReviewVO;

class StayReviewTest {

	private final StayReviewService service = StayReviewServiceImpl.getInstance(); 
	   
	   
	   @Test 
	   void testGetStay() {
		  StayReviewVO vo = new StayReviewVO();
		  
		  vo.setUser_id("1");
		  vo.setStay_no(9739);
		  vo.setReview_content("안녕하세요 반갑습니다.");
	      
	      assertNotEquals(1, service.InsertStayReview(vo) );
	      System.out.println(vo);
	      
	  
	}

}
