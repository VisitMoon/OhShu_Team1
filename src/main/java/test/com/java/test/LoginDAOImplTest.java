package test.com.java.test;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import OhShu.DAO.LoginDAO;
import OhShu.DAOImpl.LoginDAOImpl;
import OhShu.vo.UserTableVO;

class LoginDAOImplTest {
	
	LoginDAO dao = LoginDAOImpl.getInstance();

	@Test @Ignore
	void testSelectMember() {
		UserTableVO usertable = new UserTableVO();
		usertable.setUser_id("ohshu");
		usertable.setUser_pwd("ohshu1");
		
		assertEquals(1, dao.selectCountUsertable(usertable));
	}

}
