package OhShu.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OhShu.DAO.FoodReviewDAO;
import OhShu.DAOImpl.FoodReviewDAOImpl;
import OhShu.ServiceImpl.FoodReviewSeviceImpl;
import OhShu.ServiceImpl.FoodServiceImpl;
import OhShu.service.FoodReviewService;
import OhShu.service.FoodService;
import OhShu.vo.FoodReviewVO;
import OhShu.vo.FoodVO;

/**
 * Servlet implementation class FoodReviewDeleteServlet
 */
@WebServlet("/DeleteFoodReview")
public class FoodReviewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodReviewDeleteServlet() {
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

		    String reviewNoStr = request.getParameter("reviewNo");

		    if (reviewNoStr == null) {
		        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid parameters");
		        return;
		    }
		    
		    int reviewNo = Integer.parseInt(reviewNoStr);
		   System.out.println(reviewNo);
		   FoodReviewService service = new FoodReviewSeviceImpl();
		    service.deleteFoodReview(reviewNo);
		    
		    String foodNoStr = request.getParameter("foodNo");
		    int foodNo = Integer.parseInt(foodNoStr);
		    
		    
		    FoodService service1 = FoodServiceImpl.getInstance();
	        List<FoodVO> list = service1.getFoodList();
	          int index=0;
	          
	          for(int i =0; i<list.size(); i++) {
	             if(foodNo==list.get(i).getFood_no()) {
	                index = i;
	             }
	             
	          }

	          response.sendRedirect(request.getContextPath() + "/view/food_detail_page.jsp?foodNo=" + index );
		}
}