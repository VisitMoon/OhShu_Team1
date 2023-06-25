package OhShu.ServiceImpl;

import OhShu.DAO.TourMainDAO;
import OhShu.DAOImpl.TourMainDAOImpl;
import OhShu.service.TourMainService;
import OhShu.vo.TourMainVO;

public class TourMainServiceImpl implements TourMainService{
	private final static TourMainService instance = new TourMainServiceImpl();
	
	private final TourMainDAO dao = TourMainDAOImpl.getInstance();
	
	public static TourMainService getInstance() {
		return instance;
	}
	
	public TourMainVO getTourJoayoRanking(int rank) {
		return dao.selectTourJoayoRank(rank);
	}
}
