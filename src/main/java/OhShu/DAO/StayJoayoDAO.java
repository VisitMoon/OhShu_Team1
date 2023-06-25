package OhShu.DAO;

import OhShu.vo.StayJoayoVO;

public interface StayJoayoDAO {
	int toggleStayJoayo(StayJoayoVO stayJoayo);
	int selectStayJoayo(StayJoayoVO stayJoayo);
	int insertStayJoayo(StayJoayoVO stayJoayo);
	int deleteStayJoayo(StayJoayoVO stayJoayo);
}
