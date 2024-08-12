package com.jspbasic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Exam
 */
@WebServlet("/actionSvl")
public class Exam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Exam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double s = Double.parseDouble(request.getParameter("side"));
		double h = Double.parseDouble(request.getParameter("height"));
		double t = (double)(s*h)/2;
		response.getWriter().append("밑변 : " + s + "cm ")
							.append("높이 : " + h + "cm ")
							.append("삼각형의 넓이: " + t +"cm ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./index.jsp");
		request.setAttribute("name", name);
		request.setAttribute("id", id);
		request.setAttribute("password", password);
		
		dispatcher.forward(request, response);
	}

}
