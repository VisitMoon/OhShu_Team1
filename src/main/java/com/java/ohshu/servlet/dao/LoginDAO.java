package com.java.ohshu.servlet.dao;

import com.java.ohshu.sevlet.vo.UserTableVO;


public interface LoginDAO {

	void selectUsertableByIdAndPw(UserTableVO usertable);

	int selectCountUsertable(UserTableVO usertable);
	

}
