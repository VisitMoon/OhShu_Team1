package OhShu.ServiceImpl;

import OhShu.DAO.UserJoinDAO;
import OhShu.DAOImpl.UserJoinDAOImpl;
import OhShu.service.UserJoinService;
import OhShu.vo.UserTableVO;

public class UserJoinServiceImpl implements UserJoinService {
	
	private  final UserJoinDAO dao = UserJoinDAOImpl.getInstance();
	
	private static final UserJoinServiceImpl instance = new UserJoinServiceImpl();
	
	private UserJoinServiceImpl() {
		
	}
	
	public static UserJoinService getInstance() {
		return instance;
	}
	
	@Override
	public int registerUsertable(UserTableVO usertable) {
	return dao.insertUsertable(usertable);
	}

}
