package OhShu.ServiceImpl;

import OhShu.DAO.StayJoayoDAO;
import OhShu.DAOImpl.StayJoayoDAOImpl;
import OhShu.service.StayJoayoService;
import OhShu.vo.StayJoayoVO;

public class StayJoayoServiceImpl implements StayJoayoService{
	private final static StayJoayoService instance = new StayJoayoServiceImpl();
	private final StayJoayoDAO dao = StayJoayoDAOImpl.getInstance();
	
	private StayJoayoServiceImpl() {}
	
	public static StayJoayoService getInstance() {
		return instance;
	}
	
	public int pushStayJoayo(StayJoayoVO stayJoayo) {
		return dao.toggleStayJoayo(stayJoayo);
	}
}
