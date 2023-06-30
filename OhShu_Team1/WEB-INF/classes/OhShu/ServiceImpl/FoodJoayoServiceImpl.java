package OhShu.ServiceImpl;

import OhShu.DAO.FoodJoayoDAO;
import OhShu.DAOImpl.FoodJoayoDAOImpl;
import OhShu.service.FoodJoayoService;
import OhShu.vo.FoodJoayoVO;

public class FoodJoayoServiceImpl implements FoodJoayoService{
	private final static FoodJoayoService instance = new FoodJoayoServiceImpl();
	private final FoodJoayoDAO dao = FoodJoayoDAOImpl.getInstance();
	
	private FoodJoayoServiceImpl() {}
	
	public static FoodJoayoService getInstance() {
		return instance;
	}
	
	public int pushFoodJoayo(FoodJoayoVO foodJoayo) {
		return dao.toggleFoodJoayo(foodJoayo);
	}
}
