package OhShu.ServiceImpl;

import OhShu.DAO.TourDAO;
import OhShu.DAOImpl.TourDAOImpl;
import OhShu.service.TourService;
import OhShu.vo.TourVO;


public class TourServiceImpl implements TourService {
	  private static final TourServiceImpl instance = new TourServiceImpl();
	   private final TourDAO dao = TourDAOImpl.getInstance();
	   
	   private TourServiceImpl() {
		   
	   }
	   
	   public static TourServiceImpl getInstance() {
		   return instance;
	   }
	   
	   
	   @Override
	   public TourVO getTour(int Tour_no) {
	      return dao.selectTour(Tour_no);
	   }
}
