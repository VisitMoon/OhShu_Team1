package DAOImpl.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import OhShu.DAO.FoodReviewDAO;
import OhShu.DAOImpl.FoodReviewDAOImpl;
import OhShu.vo.FoodReviewVO;
import OhShu.vo.TourReviewVO;

class FoodReviewTest {

	FoodReviewDAO dao = FoodReviewDAOImpl.getInstance();
	  
	  
//	   @Test @Ignore
//	   void testinsertFood_review() {
//		  FoodReviewVO vo = new FoodReviewVO();
//		  
//		  vo.setUser_id("1");
//		  vo.setFood_no(16212);
//		  vo.setReview_content("살자.");
//		  System.out.println(vo);
//		  assertEquals(1, dao.InsertFoodReview(vo) );
//	      System.out.println(vo);	      
	  
//	}
//	   @Test @Ignore
//	   void testdeleteFood_review() {
//		  FoodReviewVO vo = new FoodReviewVO();
//		  
//		  vo.setReview_no(16);
//		  System.out.println(vo);
//		  assertEquals(1, dao.DeleteFoodReview(vo) );
//	  
//	}
	  @Test 
	   void testupdateFood_review() {
		  FoodReviewVO vo = new FoodReviewVO();
		  
		  vo.setReview_content("변경 성공");
		  vo.setReview_no(17);
		  System.out.println(vo);
		  assertEquals(1, dao.updateFoodReview(vo) );
	      
	      
	      
//	  
	}

}
