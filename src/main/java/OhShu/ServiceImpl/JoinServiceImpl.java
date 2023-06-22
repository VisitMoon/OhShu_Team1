package OhShu.ServiceImpl;

import OhShu.DAO.JoinDAO;
import OhShu.DAOImpl.JoinDAOImpl;
import OhShu.service.JoinService;
import OhShu.vo.UserTableVO;

public class JoinServiceImpl implements JoinService {
	
	private  final JoinDAO dao = JoinDAOImpl.getInstance();
	
	private static final JoinServiceImpl instance = new JoinServiceImpl();
	
	private JoinServiceImpl() {
		
	}
	
	public static JoinService getInstance() {
		return instance;
	}
	
	@Override
	public int registerUsertable(UserTableVO usertable) {
	return dao.insertUsertable(usertable);
	}

}
