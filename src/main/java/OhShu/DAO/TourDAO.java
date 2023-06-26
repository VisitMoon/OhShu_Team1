package OhShu.DAO;


import java.util.List;
import OhShu.vo.TourVO;

public interface TourDAO {
	TourVO selectTour(int tour_no);

	List<TourVO> getTourList();
	
}
