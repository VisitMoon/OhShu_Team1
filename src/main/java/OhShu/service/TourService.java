package OhShu.service;

import java.util.List;
import OhShu.vo.TourVO;

public interface TourService {
	TourVO getTour(int Tour_no);

	List<TourVO> getTourList();
	}
