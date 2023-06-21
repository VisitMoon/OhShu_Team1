package com.java.ohshu.sevlet.service;

import com.java.ohshu.sevlet.vo.UserTableVO;

public interface LoginService {

	int getCountUsertable(UserTableVO usertable);

	void getUsertableByIdAndPw(UserTableVO usertable);


}
