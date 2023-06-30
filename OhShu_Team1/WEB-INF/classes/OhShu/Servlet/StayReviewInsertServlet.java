package OhShu.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OhShu.DAOImpl.StayReviewDAOImpl;
import OhShu.DAOImpl.TourReviewDAOImpl;
import OhShu.ServiceImpl.StayServiceImpl;
import OhShu.service.StayService;
import OhShu.vo.StayReviewVO;
import OhShu.vo.StayVO;

/**
 * Servlet implementation class StayReviewInsertServlet
 */
@WebServlet("/StayReview")
public class StayReviewInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StayReviewInsertServlet() {
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
		
        int StayNo = Integer.parseInt(request.getParameter("stayNo"));
        String userId = request.getParameter("userId");
        String reviewContent = request.getParameter("reviewContent");

        StayService service = StayServiceImpl.getInstance();
        List<StayVO> list = service.getStayList();
          int index=0;
          
          for(int i =0; i<list.size(); i++) {
             if(StayNo==list.get(i).getStay_no()) {
                index = i;
             }
             
          }
          
        StayReviewVO review = new StayReviewVO();
        review.setStay_no(StayNo);
        review.setUser_id(userId);
        review.setReview_content(reviewContent);

        StayReviewDAOImpl reviewDAO = new StayReviewDAOImpl();
        reviewDAO.insertStayReview(review);

        
        response.sendRedirect(request.getContextPath() + "/view/stay_detail_page.jsp?stayNo=" + index );
    }
}
