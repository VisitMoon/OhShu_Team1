package OhShu.DAO;

import OhShu.vo.UserTableVO;


public interface UserLoginDAO {

	void selectUsertableByIdAndPw(UserTableVO usertable);

	int selectCountUsertable(UserTableVO usertable);
	
	String selectUserId(String user_name, String user_jumin);
	
	String selectUserPwd(String user_id, String user_name, String user_jumin);
}
