package DAOImpl.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import OhShu.DAO.UserLoginDAO;
import OhShu.DAOImpl.UserLoginDAOImpl;
import OhShu.vo.UserTableVO;

class LoginDAOImplTest {
	
	UserLoginDAO dao = UserLoginDAOImpl.getInstance();

	@Test @Ignore
	void testSelectMember() {
		UserTableVO usertable = new UserTableVO();
		usertable.setUser_id("jihol Park");
		usertable.setUser_pwd("1234");
		
		assertEquals(1, dao.selectCountUsertable(usertable));
	}

}
