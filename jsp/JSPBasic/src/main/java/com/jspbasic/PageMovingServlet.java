package com.jspbasic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PageMovingServlet")
public class PageMovingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PageMovingServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		// 페이지 이동방법
		// 1) javascript의 location.href 을 이용
		// 2) response.sendRedirect() 를 이용
		// 3) RequestDispatcher 객체의 forwarding을 이용하는 방법
		request.getRequestDispatcher("mainTest.jsp").forward(request, response);;
		// 4) meta 태그
		
	}

}
