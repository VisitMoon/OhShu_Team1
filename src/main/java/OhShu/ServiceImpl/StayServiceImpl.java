package OhShu.ServiceImpl;

import java.util.List;
import OhShu.DAO.StayDAO;
import OhShu.DAOImpl.StayDAOImpl;
import OhShu.service.StayService;
import OhShu.vo.StayReviewVO;
import OhShu.vo.StayVO;


public class StayServiceImpl implements StayService {
	  private static final StayServiceImpl instance = new StayServiceImpl();
	   private final StayDAO dao = StayDAOImpl.getInstance();
	   
	   private StayServiceImpl() {
		   
	   }
	   
	   public static StayServiceImpl getInstance() {
		   return instance;
	   }
	   
	   
	   @Override
	   public StayVO getStay(int stay_no) {
	      return dao.selectStay(stay_no);
	   }

	   
	   @Override
	   public List<StayVO> getStayList(){
		   return dao.getStayList();
	   }
	   
	   @Override
	   public List<StayReviewVO> getStayReviewList(int tour_no){
		   return dao.getStayReviewList(tour_no);
	   }
}