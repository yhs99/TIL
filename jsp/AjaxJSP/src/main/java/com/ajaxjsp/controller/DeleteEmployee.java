package com.ajaxjsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajaxjsp.dao.EmployeesDAO;
import com.ajaxjsp.dao.EmployeesDAOImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class DeleteEmployee
 */
@WebServlet("/deleteEmployee")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static EmployeesDAO dao = EmployeesDAOImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		Gson gson = new GsonBuilder().setDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").create();
		Map<String, Object> json = new HashMap<String, Object>();
		try {
			int result = dao.deleteEmployee(Integer.parseInt(request.getParameter("employee_id")), new java.sql.Date(new Date().getTime()));
			if(result > 0) {
				json.put("status", true);
				json.put("message", "success");
				json.put("outputDate", new Date());
				out.print(gson.toJson(json));
			}
		} catch (NumberFormatException | NamingException | SQLException e) {
			System.out.println(e.getMessage());
			json.put("status", false);
			json.put("messsage", e.getMessage());
			json.put("outputDate", new Date());
			out.print(gson.toJson(json));
		}
	}

}
