package com.jspbasic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet") // 매핑 주소
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String charset;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Hello Servlet Init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("Hello Servlet Destroy");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HelloServlet Get Request");
		
		RequestDispatcher ds = request.getRequestDispatcher("./requestInfo.jsp");
		
		ds.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloServlet Post Request");
		RequestDispatcher dispatcher = req.getRequestDispatcher("./index.jsp");
		req.setAttribute("name", req.getParameter("name"));
		resp.setContentType("text/html; charset=UTF-8");
		dispatcher.forward(req, resp);
	}

}
