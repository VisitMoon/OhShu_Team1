package OhShu.service;

import OhShu.vo.UserTableVO;

public interface UserLoginService {

	int getCountUsertable(UserTableVO usertable);

	void getUsertableByIdAndPw(UserTableVO usertable);


}
