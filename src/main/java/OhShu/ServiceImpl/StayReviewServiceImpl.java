package OhShu.ServiceImpl;

import OhShu.DAO.StayReviewDAO;
import OhShu.DAOImpl.StayReviewDAOImpl;
import OhShu.service.StayReviewService;
import OhShu.vo.StayReviewVO;

public class StayReviewServiceImpl  implements StayReviewService{
	  private static final StayReviewServiceImpl instance = new StayReviewServiceImpl();
	   private final StayReviewDAO dao = StayReviewDAOImpl.getInstance();
	   
	   private StayReviewServiceImpl() {
		   
	   }
	   
	   public static StayReviewService getInstance() {
		   return instance;
	   }
	   
	   
	   @Override
	      public int InsertStayReview(StayReviewVO stay_review) {
	  		return dao.InsertStayReview(stay_review);
	   }
}
