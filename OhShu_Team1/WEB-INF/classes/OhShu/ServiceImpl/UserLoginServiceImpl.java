package OhShu.ServiceImpl;

import OhShu.DAO.UserLoginDAO;
import OhShu.DAOImpl.UserLoginDAOImpl;
import OhShu.service.UserLoginService;
import OhShu.vo.UserTableVO;

public class UserLoginServiceImpl implements UserLoginService {

	private final UserLoginDAO dao = UserLoginDAOImpl.getInstance();
	private static final UserLoginService instance = new UserLoginServiceImpl();

	private UserLoginServiceImpl() {

	}

	@Override
	public int getCountUsertable(UserTableVO usertable) {
		return dao.selectCountUsertable(usertable);
	}

	public static UserLoginService getInstance() {
		return instance;
	}

	@Override
	public void getUsertableByIdAndPw(UserTableVO usertable) {
		dao.selectUsertableByIdAndPw(usertable);
	}

	@Override
	public String findUserId(String user_name, String user_jumin) {
		return dao.selectUserId(user_name, user_jumin);
	}
	
	@Override
	public String findUserPwd(String user_id, String user_name, String user_jumin) {
		return dao.selectUserPwd(user_id, user_name, user_jumin);
	}
}
