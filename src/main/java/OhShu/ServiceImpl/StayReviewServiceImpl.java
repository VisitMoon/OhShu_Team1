package OhShu.ServiceImpl;

import OhShu.DAO.StayReviewDAO;
import OhShu.DAOImpl.StayReviewDAOImpl;
import OhShu.service.StayReviewService;
import OhShu.vo.StayReviewVO;

public class StayReviewServiceImpl implements StayReviewService {

	private final StayReviewDAO dao = StayReviewDAOImpl.getInstance();

	private static final StayReviewService instance = new StayReviewServiceImpl();

	public StayReviewServiceImpl() {

	}

	public static StayReviewService getInstance() {
		return instance;
	}

	@Override
	public int registerStayReview(StayReviewVO stayReview) {
		return dao.insertStayReview(stayReview);
	}

	@Override
	public int changeStayReview(StayReviewVO stayReview) {
		return dao.updateStayReview(stayReview);
	}

	@Override
	public void deleteStayReview(int stayReview) {
		dao.deleteTourReview(stayReview);
	}
}
