package test.com.java.test;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import OhShu.DAO.UserJoinDAO;
import OhShu.DAOImpl.UserJoinDAOImpl;
import OhShu.vo.UserTableVO;

public class testJoinDAOImpl {
	
	@Test
	void testJoinDAO() {
		UserJoinDAO dao = UserJoinDAOImpl.getInstance();
		
		UserTableVO vo = new UserTableVO();
		vo.setUser_id("jihol Park");
		vo.setUser_name("박지호");
		vo.setUser_pwd("1234");
		vo.setUser_age(28);
		vo.setUser_jumin("960829-1122333");
		System.out.println(vo.toString());
		
		dao.insertUsertable(vo);
	}
}
