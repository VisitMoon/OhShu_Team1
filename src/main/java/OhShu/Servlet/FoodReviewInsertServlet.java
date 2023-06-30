package OhShu.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OhShu.DAOImpl.FoodReviewDAOImpl;
import OhShu.ServiceImpl.FoodServiceImpl;
import OhShu.service.FoodService;
import OhShu.vo.FoodReviewVO;
import OhShu.vo.FoodVO;

/**
 * Servlet implementation class FoodReviewServlet
 */
@WebServlet("/FoodReview")
public class FoodReviewInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodReviewInsertServlet() {
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
		
        int foodNo = Integer.parseInt(request.getParameter("foodNo"));
        String userId = request.getParameter("userId");
        String reviewContent = request.getParameter("reviewContent");

        FoodService service = FoodServiceImpl.getInstance();
        List<FoodVO> list = service.getFoodList();
          int index=0;
          
          for(int i =0; i<list.size(); i++) {
             if(foodNo==list.get(i).getFood_no()) {
                index = i;
             }
             
          }
          
        FoodReviewVO review = new FoodReviewVO();
        review.setFood_no(foodNo);
        review.setUser_id(userId);
        review.setReview_content(reviewContent);

        FoodReviewDAOImpl reviewDAO = new FoodReviewDAOImpl();
        reviewDAO.insertFoodReview(review);

        
        response.sendRedirect(request.getContextPath() + "/view/food_detail_page.jsp?foodNo=" + index );
    }
}
