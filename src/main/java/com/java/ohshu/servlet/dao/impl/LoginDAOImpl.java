package com.java.ohshu.servlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java.servlet.dao.LoginDAO;
import com.java.servlet.util.DBCP2Util;
import com.java.servlet.util.DataBaseUtil;
import com.java.servlet.vo.MemberVO;

public class LoginDAOImpl implements LoginDAO {

	private static final LoginDAO instance = new LoginDAOImpl();

	private LoginDAOImpl() {

	}

	public static LoginDAO getInstance() {
		return instance;
	}

	@Override
	public int selectCountMember(MemberVO vo) {

		int result = 0;
		String sql = "SELECT COUNT(1) FROM member\r\n" + "		WHERE (id, pw) IN ((?,?))";

		try (

				Connection conn = DataBaseUtil.getConnection(); // DBCP2Util
				PreparedStatement pstmt = conn.prepareStatement(sql);

		) {
			System.out.println(pstmt);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
			System.out.println("result - " + result);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return result;
	}

	@Override
	public void selectMemberByIdAndPw (MemberVO vo) {
		String sql = "SELECT * FROM member\r\n" + "		WHERE (id, pw) IN ((?,?))";

		try (

				Connection conn = DBCP2Util.getConnection(); // DBCP2Util
				PreparedStatement pstmt = conn.prepareStatement(sql);

		) {
			System.out.println(pstmt);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				vo.setM_no(rs.getInt("m_no"));
				vo.setName(rs.getString("name"));
				vo.setJumin("jumin");

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
