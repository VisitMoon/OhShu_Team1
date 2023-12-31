package OhShu.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OhShu.service.UserJoinService;
import OhShu.ServiceImpl.UserJoinServiceImpl;
import OhShu.vo.UserTableVO;
import OhShu.Util.SHAEncodeUtil;


/**
 * Servlet implementation class JoinSerlvet
 */

@WebServlet("/join")
public class UserJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UserJoinService service = UserJoinServiceImpl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserJoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/ohshujoin.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserTableVO usertable = new UserTableVO();
		usertable.setUser_id(request.getParameter("user_id"));
		usertable.setUser_pwd( SHAEncodeUtil.encodeSha(request.getParameter("user_pwd")));
		usertable.setUser_name(request.getParameter("user_name"));
		usertable.setUser_age(Integer.parseInt(request.getParameter("user_age")));   // int형 user_age
		usertable.setUser_jumin(request.getParameter("user_jumin"));
		
		System.out.println(usertable.toString());
		int isOk= 1;
		String msg = null;
		if(service.registerUsertable(usertable) == isOk) {
			msg = "success";
		}else {
			msg = "fail, try again";

		}
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.sendRedirect(request.getContextPath()+"/SignIn?msg="+msg);		
	}

}
