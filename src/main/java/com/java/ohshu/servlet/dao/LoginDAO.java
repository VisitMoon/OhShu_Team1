package com.java.ohshu.servlet.dao;

import com.java.ohshu.sevlet.vo.UserTableVO;


public interface LoginDAO {

	int selectCountMember(UserTableVO vo);

	void selectMemberByIdAndPw(UserTableVO vo);
	

}
