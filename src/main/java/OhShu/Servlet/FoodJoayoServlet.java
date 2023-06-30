package OhShu.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OhShu.DAOImpl.FoodJoayoDAOImpl;
import OhShu.vo.FoodJoayoVO;

/**
 * Servlet implementation class FoodJoayoServlet
 */
@WebServlet("/ToggleFoodJoayo")
public class FoodJoayoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodJoayoServlet() {
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
        int foodNo = Integer.parseInt(request.getParameter("foodNo"));

        // Create FoodJoayoVO instance
        FoodJoayoVO foodJoayo = new FoodJoayoVO();
        foodJoayo.setUser_id(userId);
        foodJoayo.setFood_no(foodNo);
        foodJoayo.setJoayo(1);

        // Toggle food joayo using FoodJoayoDAOImpl
        FoodJoayoDAOImpl.getInstance().toggleFoodJoayo(foodJoayo);

        // Redirect user back to the food_detail_page.jsp
        response.sendRedirect(request.getContextPath() + "/view/food_detail_page.jsp?foodNo=" + foodNo);
    }
}