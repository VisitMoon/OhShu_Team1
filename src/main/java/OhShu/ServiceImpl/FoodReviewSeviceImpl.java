package OhShu.ServiceImpl;

import OhShu.DAO.FoodReviewDAO;
import OhShu.DAOImpl.FoodReviewDAOImpl;
import OhShu.service.FoodReviewService;
import OhShu.vo.FoodReviewVO;

public class FoodReviewSeviceImpl implements FoodReviewService {
	 private final FoodReviewDAO dao = FoodReviewDAOImpl.getInstance();
	  
	   private static final FoodReviewService instance = new FoodReviewSeviceImpl();
	   
	   private FoodReviewSeviceImpl() {
		   
	   }
	   
	   public static FoodReviewService getInstance() {
		   return instance;
	   }
	   
	   
	   @Override
	      public int registerfood_reviewinsert(FoodReviewVO reviewinsert)  {
	  		return dao.InsertFoodReview(reviewinsert);
	   }
	   	  public int registerfood_reviewdelete(FoodReviewVO reviewdelete)  {
	  		return dao.InsertFoodReview(reviewdelete);
	   }
	   	  public int registerfood_reviewupdate(FoodReviewVO reviewupdate)  {
		  		return dao.InsertFoodReview(reviewupdate);
		   }
}
