package com.java.servlet.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.java.servlet.service.MemberApiService;
import com.java.servlet.service.impl.MemberApiServiceImpl;

/**
 * Servlet implementation class MemberApiServlet
 */
@WebServlet("/api/member")
public class MemberApiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final MemberApiService service = MemberApiServiceImpl.getInstace();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberApiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8");
		String opKey = request.getParameter("opKey");
		
		if(opKey.equals("123")) {
			
			JsonObject jsonObj1 = new JsonObject();
			
			JsonArray list = new JsonArray();
			JsonObject person = new JsonObject();
			person.addProperty("name", "park");
			person.addProperty("age", 123);
			list.add(person);
			
			person = new JsonObject();
			person.addProperty("name", "kim");
			person.addProperty("age", 123);
			list.add(person);
			
			jsonObj1.add("list", list);
			
			JsonObject jsonObj = service.getMember();
			PrintWriter out = response.getWriter();
			out.println(new Gson().toJson(jsonObj1));
			System.out.println(new Gson().toJson(jsonObj1));

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
