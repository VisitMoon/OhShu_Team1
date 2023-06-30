package OhShu.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OhShu.ServiceImpl.TourReviewServiceImpl;
import OhShu.ServiceImpl.TourServiceImpl;
import OhShu.service.TourReviewService;
import OhShu.service.TourService;
import OhShu.vo.TourVO;


/**
 * Servlet implementation class TourReviewDeleteServlet
 */
@WebServlet("/DeleteTourReview")
public class TourReviewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TourReviewDeleteServlet() {
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
		    
		    
		    int tourNo = Integer.parseInt(request.getParameter("tourNo"));
		    TourReviewService service = new TourReviewServiceImpl();
		    service.deleteTourReview(reviewNo);
		    
		    TourService service1 = TourServiceImpl.getInstance();
	        List<TourVO> list = service1.getTourList();
	          int index=0;
	          
	          for(int i =0; i<list.size(); i++) {
	             if(tourNo==list.get(i).getTour_no()) {
	                index = i;
	             }
	             
	          }

	          response.sendRedirect(request.getContextPath() + "/view/tour_detail_page.jsp?tourNo=" + index );
		}
}