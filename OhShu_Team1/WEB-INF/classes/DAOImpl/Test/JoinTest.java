package DAOImpl.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import OhShu.ServiceImpl.UserJoinServiceImpl;
import OhShu.service.UserJoinService;
import OhShu.vo.UserTableVO;

class JoinTest {

UserJoinService service =  UserJoinServiceImpl.getInstance();
	
	
	@Test	@Ignore
	void testInsertMember() {
		UserTableVO usertable = new UserTableVO();
		usertable.setUser_id("2");
		usertable.setUser_pwd("1");
		usertable.setUser_name("ko");
		usertable.setUser_age(12);
		usertable.setUser_jumin("111111-1111111");
		
		
		assertEquals(1, service.registerUsertable(usertable));
		
	}
	

}
