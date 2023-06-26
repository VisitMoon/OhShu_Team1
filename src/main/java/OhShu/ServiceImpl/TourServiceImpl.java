package OhShu.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

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
	   
	   @Override
	   public List<TourVO> getTourList(){
		   return dao.getTourList();
	   }
}
