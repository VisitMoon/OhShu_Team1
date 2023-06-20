package com.java.ohshu.servlet.dao;

import com.java.servlet.vo.MemberVO;

public interface LoginDAO {

	int selectCountMember(MemberVO vo);

	void selectMemberByIdAndPw(MemberVO vo);
	

}
