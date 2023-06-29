package OhShu.service;

import java.util.List;

import OhShu.vo.FoodVO;
import OhShu.vo.StayVO;
import OhShu.vo.TourVO;
import OhShu.vo.UserTableVO;

public interface UserPageService {
	UserTableVO getUserInfo(String user_id);
	
	int changeUserPwd(String user_id, String current_pwd, String changed_pwd);
	
	List<FoodVO> getUserFoodJoayo(String user_id);
	List<TourVO> getUserTourJoayo(String user_id);
	List<StayVO> getUserStayJoayo(String user_id);
}
