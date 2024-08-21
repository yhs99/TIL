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

	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession s = request.getSession();
			s.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("mainTest.jsp");
			rd.forward(request, resp);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = "";
		String password = "";
		RequestDispatcher rd = null;
		id = request.getParameter("id");
		password = request.getParameter("password");
		Cookie cook = new Cookie("cook", id);
		cook.setMaxAge(24*60*60);
		cook.setSecure(true);
		response.addCookie(cook);
		HttpSession s = request.getSession();
		if(id.equals("abcd") && password.equals("1234")) {
			s.setAttribute("loginMemberId", id);
			s.setAttribute("isLogined", true);
			System.out.println("session : " + s.getId());
			rd = request.getRequestDispatcher("mainTest.jsp");
		}else {
			request.setAttribute("msg", "아이디 또는 비밀번호 확인필요");
			rd = request.getRequestDispatcher("loginTest2.jsp");
		}
		rd.forward(request, response);
	}

}
