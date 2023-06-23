package OhShu.DAO;

import OhShu.vo.TourJoayoVO;

public interface TourJoayoDAO {
	int toggleTourJoayo(TourJoayoVO tourJoayo);
	int selectTourJoayo(TourJoayoVO tourJoayo);
	int insertTourJoayo(TourJoayoVO tourJoayo);
	int deleteTourJoayo(TourJoayoVO tourJoayo);
}
