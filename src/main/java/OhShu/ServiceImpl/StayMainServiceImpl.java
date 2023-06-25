package OhShu.ServiceImpl;

import OhShu.DAO.StayMainDAO;
import OhShu.DAOImpl.StayMainDAOImpl;
import OhShu.service.StayMainService;
import OhShu.vo.StayMainVO;

public class StayMainServiceImpl implements StayMainService {
	  private static final StayMainService instance = new StayMainServiceImpl();
	   private final StayMainDAO dao = StayMainDAOImpl.getInstance();
	   
	   private StayMainServiceImpl() {
		   
	   }
	   
	   public static StayMainService getInstance() {
		   return instance;
	   }
	   
	   
	   @Override
	   public StayMainVO getStayJoayoRanking(int rank) {
	      return dao.selectStayJoayoRank(rank);
	   }
}
