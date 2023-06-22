package OhShu.ServiceImpl;

import OhShu.DAO.FoodMainDAO;
import OhShu.DAOImpl.FoodMainDAOImpl;
import OhShu.service.FoodMainService;
import OhShu.vo.FoodMainVO;
import OhShu.Util.PageMaker;


public class FoodMainServiceImpl implements FoodMainService {
	
	private static final FoodMainService instance = new FoodMainServiceImpl();
	private final FoodMainDAO dao = FoodMainDAOImpl.getInstance();
	
	private FoodMainServiceImpl() {	}
	
	public static FoodMainService getInstance() {
		return instance;
	}
	
	@Override
	public FoodMainVO getFood(int food_no) {
		return dao.selectFood(food_no);
		
	}

	


}
