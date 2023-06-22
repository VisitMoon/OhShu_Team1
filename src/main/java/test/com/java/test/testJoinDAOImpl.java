package test.com.java.test;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import OhShu.DAO.JoinDAO;
import OhShu.DAOImpl.JoinDAOImpl;
import OhShu.vo.UserTableVO;

public class testJoinDAOImpl {
	
	@Test
	void testJoinDAO() {
		JoinDAO dao = JoinDAOImpl.getInstance();
		
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
