package OhShu.ServiceImpl;

import OhShu.DAO.TourReviewDAO;
import OhShu.DAOImpl.TourReviewDAOImpl;
import OhShu.service.TourReviewService;
import OhShu.vo.TourReviewVO;

public class TourReviewServiceImpl implements TourReviewService {
	 private final TourReviewDAO dao = TourReviewDAOImpl.getInstance();
	  
	   private static final TourReviewService instance = new TourReviewServiceImpl();
	   
	   private TourReviewServiceImpl() {
		   
	   }
	   
	   public static TourReviewService getInstance() {
		   return instance;
	   }
	   
	   
	   @Override
	      public int registerstay_reviewinsert(TourReviewVO reviewinsert)  {
	  		return dao.InsertTourReview(reviewinsert);
	   }
	   	  public int registerstay_reviewupdate(TourReviewVO reviewdelete)  {
	  		return dao.InsertTourReview(reviewdelete);
	   }
	   	  public int registerstay_reviewdelete(TourReviewVO reviewupdate)  {
		  		return dao.InsertTourReview(reviewupdate);
		   }
}