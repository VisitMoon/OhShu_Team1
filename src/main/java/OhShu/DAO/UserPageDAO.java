package OhShu.DAO;

import java.util.List;

import OhShu.vo.FoodVO;
import OhShu.vo.StayVO;
import OhShu.vo.TourVO;
import OhShu.vo.UserTableVO;

public interface UserPageDAO {
	UserTableVO selectUserInfo(String user_id);
	
	int updateUserPwd(String user_id, String current_pwd, String changed_pwd);
	
	List<FoodVO> selectUserFoodJoayo(String user_id);
	List<TourVO> selectUserTourJoayo(String user_id);
	List<StayVO> selectUserStayJoayo(String user_id);
}
