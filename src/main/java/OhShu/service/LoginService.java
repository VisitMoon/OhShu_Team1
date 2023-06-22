package OhShu.service;

import OhShu.vo.UserTableVO;

public interface LoginService {

	int getCountUsertable(UserTableVO usertable);

	void getUsertableByIdAndPw(UserTableVO usertable);


}
