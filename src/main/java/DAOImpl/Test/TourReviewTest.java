package DAOImpl.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import OhShu.DAO.TourReviewDAO;
import OhShu.DAOImpl.TourReviewDAOImpl;
import OhShu.vo.TourReviewVO;

class TourReviewTest {
		
	
	  TourReviewDAO dao = TourReviewDAOImpl.getInstance();
	  
	  
	   @Test @Ignore
	   void testinsertTour_review() {
		  TourReviewVO vo = new TourReviewVO();
		  
		  vo.setUser_id("1");
		  vo.setTour_no(50547);
		  vo.setReview_content("살자.");
		  System.out.println(vo);
		  assertEquals(1, dao.InsertTourReview(vo) );
	      System.out.println(vo);	      
	  
	}
	   @Test @Ignore
	   void testdeleteTour_review() {
		  TourReviewVO vo = new TourReviewVO();
		  
		  vo.setReview_no(14);
		  System.out.println(vo);
		  assertEquals(1, dao.DeleteTourReview(vo) );
	  
	}
	   @Test 
	   void testupdateTour_review() {
		  TourReviewVO vo = new TourReviewVO();
		  
		  vo.setReview_content("변경 성공");
		  vo.setReview_no(15);
		  System.out.println(vo);
		  assertEquals(1, dao.updateTourReview(vo) );
	       
	}	   
}
