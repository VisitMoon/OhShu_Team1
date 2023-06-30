package OhShu.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OhShu.DAOImpl.TourJoayoDAOImpl;
import OhShu.vo.TourJoayoVO;

/**
 * Servlet implementation class TourJoayoServlet
 */
@WebServlet("/ToggleTourJoayo")
public class TourJoayoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TourJoayoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      request.setCharacterEncoding("UTF-8");

	        String userId = request.getParameter("userId");
	        int TourNo = Integer.parseInt(request.getParameter("tourNo"));

	        // Create FoodJoayoVO instance
	        TourJoayoVO TourJoayo = new TourJoayoVO();
	        TourJoayo.setUser_id(userId);
	        TourJoayo.setTour_no(TourNo);
	        TourJoayo.setJoayo(1);

	        // Toggle food joayo using FoodJoayoDAOImpl
	        TourJoayoDAOImpl.getInstance().toggleTourJoayo(TourJoayo);

	        // Redirect user back to the food_detail_page.jsp
	        response.sendRedirect(request.getContextPath() + "/view/tour_allCategory_page.jsp");
	    }
}
