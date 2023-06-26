package OhShu.DAO;

import java.util.List;

import OhShu.vo.StayVO;

public interface StayDAO {

	StayVO selectStay(int stay_no);
	List<StayVO> selectStayList();
}

