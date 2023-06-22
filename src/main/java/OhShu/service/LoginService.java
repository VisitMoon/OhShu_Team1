package OhShu.service;

import com.java.ohshu.sevlet.vo.UserTableVO;

public interface LoginService {

	int getCountUsertable(UserTableVO usertable);

	void getUsertableByIdAndPw(UserTableVO usertable);


}
