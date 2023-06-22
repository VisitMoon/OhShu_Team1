package OhShu.ServiceImpl;

import com.java.ohshu.servlet.dao.LoginDAO;
import com.java.ohshu.servlet.dao.impl.LoginDAOImpl;
import com.java.ohshu.sevlet.service.LoginService;
import com.java.ohshu.sevlet.vo.UserTableVO;

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
