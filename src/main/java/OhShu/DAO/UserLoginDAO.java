package OhShu.DAO;

import OhShu.vo.UserTableVO;


public interface UserLoginDAO {

	void selectUsertableByIdAndPw(UserTableVO usertable);

	int selectCountUsertable(UserTableVO usertable);
	

}
