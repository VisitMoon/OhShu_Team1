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

}
