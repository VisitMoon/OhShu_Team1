	package OhShu.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import OhShu.DAO.IdCheckDAO;

/**
 * Servlet implementation class IdCheckServlet
 */
@WebServlet("/IdCheck")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();
        JsonObject jsonObject = new JsonObject();
        String userId = request.getParameter("user_id");

        if (userId == null || userId.isEmpty()) {
            jsonObject.addProperty("result", "error");
            jsonObject.addProperty("message", "잘못된 요청입니다.");
            out.print(jsonObject.toString());
            out.close();
            return;
        }

        try {
            IdCheckDAO userDAO = new IdCheckDAO();
            boolean isDuplicate = userDAO.checkDuplicate(userId);

            if (isDuplicate) {
                jsonObject.addProperty("result", "exist");
                jsonObject.addProperty("message", "이미 사용 중인 아이디입니다.");
            } else {
                jsonObject.addProperty("result", "not exist");
                jsonObject.addProperty("message", "사용 가능한 아이디입니다.");
            }

            out.print(jsonObject.toString());
        } catch (ClassNotFoundException e) {
            jsonObject.addProperty("result", "error");
            jsonObject.addProperty("message", "ClassNotFoundException");
            out.print(jsonObject.toString());
        } catch (SQLException e) {
            jsonObject.addProperty("result", "error");
            jsonObject.addProperty("message", "SQLException");
            out.print(jsonObject.toString());
        } catch (Exception e) {
            jsonObject.addProperty("result", "error");
            jsonObject.addProperty("message", e.getMessage());
            out.print(jsonObject.toString());
        } finally {
            out.close();
        }
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
