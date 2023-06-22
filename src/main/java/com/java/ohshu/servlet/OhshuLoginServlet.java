package com.java.ohshu.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.ohshu.sevlet.service.LoginService;
import com.java.ohshu.sevlet.service.impl.LoginServiceImpl;
import com.java.ohshu.sevlet.vo.UserTableVO;
import com.java.servlet.util.Define;
import com.java.servlet.util.SHAEncodeUtil;



/**
 * Servlet implementation class ohshuservlet
 */
@WebServlet("/ohshlogin")
public class OhshuLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final LoginService service = LoginServiceImpl.getInstance();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OhshuLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("msg"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("????????????로그인페이지주소필요함");
		dispatcher.forward(request, response);
		
	  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		UserTableVO usertable = new UserTableVO();
		
		usertable.setUser_id(request.getParameter("user_id"));
		usertable.setUser_pwd(SHAEncodeUtil.encodeSha(request.getParameter("user_pwd")));
		
//		vo.setId("jam");
//		vo.setPw("jam04");
		
		
		if(service.getCountUsertable(usertable) == Define.LOGIN_AUTH_SUCCESS) {
			// session binding

			service.getCountUsertable(usertable);
			
			HttpSession session = request.getSession(false);
			session.setAttribute("SESS_AUTH",true);
			session.setAttribute("SESS_ID",usertable.getUser_id());
			session.setAttribute("SESS_USERNAME",usertable.getUser_name());
			
			response.sendRedirect(request.getContextPath()+"/ohshumain");
			
			System.out.println("session - "+session);
			
			 
		}else {
			// login false
			// login success
			request.getRequestDispatcher("/view/login.jsp?msg=login failed, plz try again")
					.forward(request, response);
			
		}
		
		System.out.println("result - "+ service.getCountUsertable(usertable));

		
//		service.getCountMember(vo);
//		response.sendRedirect(request.getContextPath()+"/main");
	}

}