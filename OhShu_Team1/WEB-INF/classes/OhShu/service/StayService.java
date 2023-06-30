package OhShu.service;

import java.util.List;

import OhShu.vo.StayReviewVO;
import OhShu.vo.StayVO;

public interface StayService {
	StayVO getStay(int stay_no);

	List<StayVO> getStayList();
	
	List<StayReviewVO> getStayReviewList(int stay_no);
}
