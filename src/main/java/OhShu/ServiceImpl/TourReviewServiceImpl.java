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
	public int registerTourReview(TourReviewVO tourReview) {
		return dao.insertTourReview(tourReview);
	}

	@Override
	public int changeTourReview(TourReviewVO tourReview) {
		return dao.updateTourReview(tourReview);
	}

	@Override
	public int deleteTourReview(TourReviewVO tourReview) {
		return dao.deleteTourReview(tourReview);
	}
}