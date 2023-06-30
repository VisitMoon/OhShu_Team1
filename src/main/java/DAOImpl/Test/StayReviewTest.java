package DAOImpl.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import OhShu.DAO.StayReviewDAO;
import OhShu.DAOImpl.StayReviewDAOImpl;
import OhShu.ServiceImpl.StayReviewServiceImpl;
import OhShu.service.StayReviewService;
import OhShu.vo.StayReviewVO;

class StayReviewTest {

	StayReviewDAO dao = StayReviewDAOImpl.getInstance(); 
	StayReviewService service = StayReviewServiceImpl.getInstance();	   
	   
	   @Test @Ignore
	   void testinsertstay_review() {
		  StayReviewVO vo = new StayReviewVO();
		  vo.setUser_id("jihol Park");
		  vo.setStay_no(9708);
		  vo.setReview_content("안녕하세요 반갑습니다.");

	      assertNotEquals(1, dao.insertStayReview(vo) );

		  vo.setUser_id("1");
		  vo.setStay_no(9739);
		  vo.setReview_content("살자.");
		  System.out.println(vo);
		  assertEquals(1, dao.insertStayReview(vo) );
	      System.out.println(vo);
	   
	  
	}
//	   @Test @Ignore
//	   void testdeleteStay_review() {
//		  StayReviewVO vo = new StayReviewVO();
//		  
//		  vo.setReview_no(9);
//		  System.out.println(vo);
//		  assertEquals(1, dao.deleteStayReview(vo) );
//	      
//	  
//	}
//	   @Test @Ignore
//	   void testupdateStay_review() {
//		  StayReviewVO vo = new StayReviewVO();
//		  
//		  vo.setReview_content("변경 성공");
//		  vo.setReview_no(12);
//		  System.out.println(vo);
//		  assertEquals(1, dao.updateStayReview(vo) );
//	          
//	  
//	}
	  
}
