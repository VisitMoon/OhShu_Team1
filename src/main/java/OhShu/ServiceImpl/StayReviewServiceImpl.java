package OhShu.ServiceImpl;

import OhShu.DAO.StayReviewDAO;
import OhShu.DAOImpl.StayReviewDAOImpl;
import OhShu.service.StayReviewService;
import OhShu.vo.StayReviewVO;

public class StayReviewServiceImpl  implements StayReviewService{
	  
	   private final StayReviewDAO dao = StayReviewDAOImpl.getInstance();
	  
	   private static final StayReviewService instance = new StayReviewServiceImpl();
	   
	   private StayReviewServiceImpl() {
		   
	   }
	   
	   public static StayReviewService getInstance() {
		   return instance;
	   }
	   
	   
	   @Override
	      public int registerstay_reviewinsert(StayReviewVO reviewinsert)  {
	  		return dao.InsertStayReview(reviewinsert);
	   }
	   	  public int registerstay_reviewupdate(StayReviewVO reviewdelete)  {
	  		return dao.InsertStayReview(reviewdelete);
	   }
	   	  public int registerstay_reviewdelete(StayReviewVO reviewupdate)  {
		  		return dao.InsertStayReview(reviewupdate);
		   }
}
