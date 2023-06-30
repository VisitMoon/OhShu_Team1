package OhShu.service;

import OhShu.vo.UserTableVO;

public interface UserLoginService {

	int getCountUsertable(UserTableVO usertable);

	void getUsertableByIdAndPw(UserTableVO usertable);

	String findUserId(String user_name, String user_jumin);
	
	String findUserPwd(String user_id, String user_name, String user_jumin);
}
