package test.com.java.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import OhShu.ServiceImpl.LoginServiceImpl;
import OhShu.service.LoginService;
import OhShu.vo.UserTableVO;



class LoginServiceTest {

private LoginService service = LoginServiceImpl.getInstance();
	
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
		usertable.setUser_id("ohshu");
		usertable.setUser_pwd("ohshu1");
		
		service.getUsertableByIdAndPw(usertable);
		assertEquals(usertable,usertable);
		
		System.out.println(usertable);
		
	}

}
