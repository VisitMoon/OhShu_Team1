package OhShu.ServiceImpl;

import OhShu.DAO.TourJoayoDAO;
import OhShu.DAOImpl.TourJoayoDAOImpl;
import OhShu.service.TourJoayoService;
import OhShu.vo.TourJoayoVO;

public class TourJoayoServiceImpl implements TourJoayoService{
	private final static TourJoayoService instance = new TourJoayoServiceImpl();
	private final TourJoayoDAO dao = TourJoayoDAOImpl.getInstance();
	
	private TourJoayoServiceImpl() {}
	
	public static TourJoayoService getInstance() {
		return instance;
	}
	
	public int pushTourJoayo(TourJoayoVO tourJoayo) {
		return dao.toggleTourJoayo(tourJoayo);
	}
}
