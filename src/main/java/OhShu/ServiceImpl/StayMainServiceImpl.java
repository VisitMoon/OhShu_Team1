package OhShu.ServiceImpl;

import OhShu.DAO.StayMainDAO;
import OhShu.DAOImpl.StayMainDAOImpl;
import OhShu.service.StayMainService;
import OhShu.vo.StayVO;

public class StayMainServiceImpl implements StayMainService {
	  private static final StayMainService instance = new StayMainServiceImpl();
	   private final StayMainDAO dao = StayMainDAOImpl.getInstance();
	   
	   private StayMainServiceImpl() {
		   
	   }
	   
	   public static StayMainService getInstance() {
		   return instance;
	   }
	   
	   
	   @Override
	   public StayVO getStay(int stay_no) {
	      return dao.selectStay(stay_no);
	   }
}
