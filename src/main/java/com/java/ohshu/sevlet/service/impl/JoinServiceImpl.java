package com.java.ohshu.sevlet.service.impl;

import com.java.ohshu.servlet.dao.JoinDAO;
import com.java.ohshu.servlet.dao.impl.JoinDAOImpl;
import com.java.ohshu.sevlet.service.JoinService;
import com.java.ohshu.sevlet.vo.UserTableVO;

public class JoinServiceImpl implements JoinService {
	
	private  final JoinDAO dao = JoinDAOImpl.getInstance();
	
	private static final JoinServiceImpl instance = new JoinServiceImpl();
	
	private JoinServiceImpl() {
		
	}
	
	public static JoinService getInstance() {
		return instance;
	}
	
	@Override
	public int registerUsertable(UserTableVO usertable) {
	return dao.insertUsertable(usertable);
	}

}
