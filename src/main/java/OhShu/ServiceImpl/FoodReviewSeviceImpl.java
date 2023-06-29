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
	public int registerFoodReview(FoodReviewVO foodReview) {
		return dao.insertFoodReview(foodReview);
	}

	@Override
	public int deleteFoodReview(int foodReview) {
		return dao.deleteFoodReview(foodReview);
	}

	@Override
	public int changeFoodReview(FoodReviewVO foodReview) {
		return dao.updateFoodReview(foodReview);
	}
}
