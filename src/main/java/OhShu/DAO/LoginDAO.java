package OhShu.DAO;

import OhShu.vo.UserTableVO;


public interface LoginDAO {

	void selectUsertableByIdAndPw(UserTableVO usertable);

	int selectCountUsertable(UserTableVO usertable);
	

}
