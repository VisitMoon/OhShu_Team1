package OhShu.ServiceImpl;

import OhShu.DAO.FoodReviewDAO;
import OhShu.DAOImpl.FoodReviewDAOImpl;
import OhShu.service.FoodReviewService;
import OhShu.vo.FoodReviewVO;

public class FoodReviewSeviceImpl implements FoodReviewService {
	private final FoodReviewDAO dao = FoodReviewDAOImpl.getInstance();

	private static final FoodReviewService instance = new FoodReviewSeviceImpl();

	public FoodReviewSeviceImpl() {

	}

	public static FoodReviewService getInstance() {
		return instance;
	}

	@Override
	public int registerFoodReview(FoodReviewVO foodReview) {
		return dao.insertFoodReview(foodReview);
	}

	@Override
	public void deleteFoodReview(int review_no) {
        dao.deleteFoodReview(review_no);
    }

	@Override
	public int changeFoodReview(FoodReviewVO foodReview) {
		return dao.updateFoodReview(foodReview);
	}
}
