package OhShu.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import OhShu.ServiceImpl.StayMainServiceImpl;
import OhShu.service.StayMainService;
import OhShu.vo.StayMainVO;

/**
 * Servlet implementation class StayServlet
 */
@WebServlet("/StayServlet")
public class StayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final StayMainService service = StayMainServiceImpl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
