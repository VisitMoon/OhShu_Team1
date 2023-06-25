package DAOImpl.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import OhShu.ServiceImpl.UserLoginServiceImpl;
import OhShu.service.UserLoginService;
import OhShu.vo.UserTableVO;



class LoginServiceTest {

private UserLoginService service = UserLoginServiceImpl.getInstance();
	
//		@Test 
//		void testSelectMember() {
//			MemberVO vo = new MemberVO();
//			vo.setId("nan");
//			vo.setPw("aa11");
//			
//			assertEquals(1, service.getCountMember(vo));
//		}

	@Test @Ignore
	void testGetCountMember() {
		UserTableVO usertable = new UserTableVO();
		usertable.setUser_id("user01");
		usertable.setUser_pwd("pwd");
		
		service.getUsertableByIdAndPw(usertable);
		assertEquals(usertable,usertable);
		
		System.out.println(usertable);
		
	}

}
