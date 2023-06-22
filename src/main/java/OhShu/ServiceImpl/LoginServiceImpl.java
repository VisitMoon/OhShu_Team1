package OhShu.ServiceImpl;

import OhShu.DAO.LoginDAO;
import OhShu.DAOImpl.LoginDAOImpl;
import OhShu.service.LoginService;
import OhShu.vo.UserTableVO;

public class LoginServiceImpl implements LoginService {

	private final LoginDAO dao = LoginDAOImpl.getInstance();
	private static final LoginService instance = new LoginServiceImpl();

	private LoginServiceImpl() {

	}

	@Override
	public int getCountUsertable(UserTableVO usertable) {
		return dao.selectCountUsertable(usertable);
	}

	public static LoginService getInstance() {
		return instance;
	}

	@Override
	public void getUsertableByIdAndPw(UserTableVO usertable) {
		dao.selectUsertableByIdAndPw(usertable);
	}

}
