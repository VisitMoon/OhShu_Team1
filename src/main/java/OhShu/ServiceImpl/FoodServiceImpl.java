package OhShu.ServiceImpl;

import java.util.List;
import OhShu.DAO.FoodDAO;
import OhShu.DAOImpl.FoodDAOImpl;
import OhShu.service.FoodService;
import OhShu.vo.FoodReviewVO;
import OhShu.vo.FoodVO;


public class FoodServiceImpl implements FoodService {
	  private static final FoodServiceImpl instance = new FoodServiceImpl();
	   private final FoodDAO dao = FoodDAOImpl.getInstance();
	   
	   private FoodServiceImpl() {
		   
	   }
	   
	   public static FoodServiceImpl getInstance() {
		   return instance;
	   }
	   
	   
	   @Override
	   public FoodVO getFood(int Food_no) {
	      return dao.selectFood(Food_no);
	   }
	   
	   @Override
	   public List<FoodVO> getFoodList(){
		   return dao.selectFoodList();
	   }
	   
	   @Override
	   public List<FoodReviewVO> getFoodReviewList(int food_no){
		   return dao.getFoodReviewList(food_no);
	   }
}