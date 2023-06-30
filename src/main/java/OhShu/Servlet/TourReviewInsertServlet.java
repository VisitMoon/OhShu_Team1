package OhShu.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OhShu.DAOImpl.TourReviewDAOImpl;
import OhShu.ServiceImpl.TourServiceImpl;
import OhShu.service.TourService;
import OhShu.vo.TourReviewVO;
import OhShu.vo.TourVO;



/**
 * Servlet implementation class TourReviewInsertServlet
 */
@WebServlet("/TourReview")
public class TourReviewInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TourReviewInsertServlet() {
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
		
        int tourNo = Integer.parseInt(request.getParameter("tourNo"));
        String userId = request.getParameter("userId");
        String reviewContent = request.getParameter("reviewContent");

        TourService service = TourServiceImpl.getInstance();
        List<TourVO> list = service.getTourList();
          int index=0;
          
          for(int i =0; i<list.size(); i++) {
             if(tourNo==list.get(i).getTour_no()) {
                index = i;
             }
             
          }
          
        TourReviewVO review = new TourReviewVO();
        review.setTour_no(tourNo);
        review.setUser_id(userId);
        review.setReview_content(reviewContent);

        TourReviewDAOImpl reviewDAO = new TourReviewDAOImpl();
        reviewDAO.insertTourReview(review);

        
        response.sendRedirect(request.getContextPath() + "/view/tour_detail_page.jsp?tourNo=" + index );
    }
}