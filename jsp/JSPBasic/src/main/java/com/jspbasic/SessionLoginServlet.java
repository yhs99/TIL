package com.jspbasic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionLoginServlet
 */
@WebServlet("/SessionLoginServlet")
public class SessionLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		Cookie cook = new Cookie("cook", id);
		cook.setMaxAge(24*60*60);
		cook.setSecure(true);
		response.addCookie(cook);
		HttpSession s = request.getSession();
		if(id.equals("abcd") && password.equals("1234")) {
			s.setAttribute("id", id);
			System.out.println("session : " + s.getId());
		}else {
			s.invalidate();
		}
		RequestDispatcher rd = request.getRequestDispatcher("mainTest.jsp");
		rd.forward(request, response);
	}

}
