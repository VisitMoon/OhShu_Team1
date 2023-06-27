package OhShu.ServiceImpl;

import java.util.List;

import OhShu.DAO.UserPageDAO;
import OhShu.DAOImpl.UserPageDAOImpl;
import OhShu.service.UserPageService;
import OhShu.vo.FoodVO;
import OhShu.vo.StayVO;
import OhShu.vo.TourVO;
import OhShu.vo.UserTableVO;

public class UserPageServiceImpl implements UserPageService{
	private static final UserPageService instance = new UserPageServiceImpl();
	
	private UserPageServiceImpl() {}
	
	private final UserPageDAO dao = UserPageDAOImpl.getInstance();
	
	public UserTableVO getUserInfo(String user_id) {
		return dao.selectUserInfo(user_id);
	}
	
	public int changeUserPwd(String user_id, String current_pwd, String changed_pwd) {
		return dao.updateUserPwd(user_id, current_pwd, changed_pwd);
	}
	
	public List<FoodVO> getUserFoodJoayo(String user_id){
		return dao.selectUserFoodJoayo(user_id);
	}
	
	public List<TourVO> getUserTourJoayo(String user_id){
		return dao.selectUserTourJoayo(user_id);
	}
	
	public List<StayVO> getUserStayJoayo(String user_id){
		return dao.selectUserStayJoayo(user_id);
	}
}
