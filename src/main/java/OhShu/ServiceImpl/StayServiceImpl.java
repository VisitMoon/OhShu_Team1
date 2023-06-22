package OhShu.ServiceImpl;



import OhShu.DAO.StayDAO;
import OhShu.DAOImpl.StayDAOImpl;
import OhShu.service.StayService;
import OhShu.vo.StayVO;

public class StayServiceImpl implements StayService {
	  private static final StayServiceImpl instance = new StayServiceImpl();
	   private final StayDAO dao = StayDAOImpl.getInstance();
	   
	   private StayServiceImpl() {
		   
	   }
	   
	   public static StayService getInstance() {
		   return instance;
	   }
	   
	   
	   @Override
	   public StayVO getStay(int Stay_no) {
	      return dao.selectStay(Stay_no);
	   }
}