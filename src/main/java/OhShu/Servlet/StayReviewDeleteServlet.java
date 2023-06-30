package OhShu.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OhShu.ServiceImpl.StayReviewServiceImpl;
import OhShu.ServiceImpl.StayServiceImpl;
import OhShu.service.StayReviewService;
import OhShu.service.StayService;
import OhShu.vo.StayVO;



/**
 * Servlet implementation class StayReviewDeleteServlet
 */
@WebServlet("/DeleteStayReview")
public class StayReviewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StayReviewDeleteServlet() {
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
	    
	    
	    int StayNo = Integer.parseInt(request.getParameter("stayNo"));
	    StayReviewService service = new StayReviewServiceImpl();
	    service.deleteStayReview(reviewNo);
	    
	    StayService service1 = StayServiceImpl.getInstance();
        List<StayVO> list = service1.getStayList();
          int index=0;
          
          for(int i =0; i<list.size(); i++) {
             if(StayNo==list.get(i).getStay_no()) {
                index = i;
             }
             
          }

          response.sendRedirect(request.getContextPath() + "/view/stay_detail_page.jsp?stayNo=" + index );
	}
}
