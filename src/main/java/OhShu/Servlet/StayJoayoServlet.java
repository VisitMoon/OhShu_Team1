package OhShu.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OhShu.DAOImpl.StayJoayoDAOImpl;
import OhShu.vo.StayJoayoVO;

/**
 * Servlet implementation class StayJoayoServlet
 */
@WebServlet("/ToggleStayJoayo")
public class StayJoayoServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StayJoayoServlet() {
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
      // TODO Auto-generated method stub
      request.setCharacterEncoding("UTF-8");

        String userId = request.getParameter("userId");
        int stayNo = Integer.parseInt(request.getParameter("stayNo"));

        // Create FoodJoayoVO instance
        StayJoayoVO stayJoayo = new StayJoayoVO();
        stayJoayo.setUser_id(userId);
        stayJoayo.setStay_no(stayNo);
        stayJoayo.setJoayo(1);

        // Toggle food joayo using FoodJoayoDAOImpl
        StayJoayoDAOImpl.getInstance().toggleStayJoayo(stayJoayo);

        // Redirect user back to the food_detail_page.jsp
        response.sendRedirect(request.getContextPath() + "/view/stay_allCategory_page.jsp");
   }
}