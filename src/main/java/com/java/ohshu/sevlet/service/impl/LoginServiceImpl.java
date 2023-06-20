package com.java.ohshu.sevlet.service.impl;

import com.java.servlet.dao.LoginDAO;
import com.java.servlet.dao.impl.LoginDAOImpl;
import com.java.servlet.service.LoginService;
import com.java.servlet.vo.MemberVO;

public class LoginServiceImpl implements LoginService {

	private final LoginDAO dao = LoginDAOImpl.getInstance();
	private static final LoginService instance = new LoginServiceImpl();

	private LoginServiceImpl() {

	}

	@Override
	public int getCountMember(MemberVO vo) {
		return dao.selectCountMember(vo);
	}

	public static LoginService getInstance() {
		return instance;
	}

	@Override
	public void getMemberByIdAndPw(MemberVO vo) {
		dao.selectMemberByIdAndPw(vo);
	}

}
