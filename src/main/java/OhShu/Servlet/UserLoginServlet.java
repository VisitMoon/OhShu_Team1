package OhShu.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import OhShu.service.UserLoginService;
import OhShu.ServiceImpl.UserLoginServiceImpl;
import OhShu.vo.UserTableVO;
import OhShu.Util.Define;
import OhShu.Util.SHAEncodeUtil;



/**
 * Servlet implementation class ohshuservlet
 */
@WebServlet("/SignIn")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UserLoginService service = UserLoginServiceImpl.getInstance();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("msg"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/js/signin.jsp");
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
			
			response.sendRedirect(request.getContextPath()+"/Main");
			
			System.out.println("session - "+session);
			
			 
		}else {
			// login false
			// login success
			request.getRequestDispatcher("/view/js/signin.jsp?msg=login failed, plz try again")
					.forward(request, response);
			
		}
		
		System.out.println("result - "+ service.getCountUsertable(usertable));

		
//		service.getCountMember(vo);
//		response.sendRedirect(request.getContextPath()+"/main");
	}

}
