package com.ajaxjsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajaxjsp.dao.EmployeesDAO;
import com.ajaxjsp.dao.EmployeesDAOImpl;
import com.ajaxjsp.vo.EmployeeVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class SearchEmployee
 */
@WebServlet("/searchEmployee")
public class SearchEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static EmployeesDAO dao = EmployeesDAOImpl.getInstance();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		Map<String, Object> map = new HashMap<String, Object>();
		PrintWriter out = response.getWriter();
		String searchQ = request.getParameter("name").isEmpty() ? "" : request.getParameter("name");
		System.out.println("searching name : " + searchQ);
		String sortQ = request.getParameter("sort");
		String methodQ = request.getParameter("method");
		try {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			List<EmployeeVO> employees = dao.employeeSearchByName(searchQ, sortQ, methodQ);
			System.out.println(employees.toString());
			map.put("status", true);
			map.put("outputDate", new Date());
			map.put("datas", employees);
			map.put("size", employees.size());
			out.print(gson.toJson(map));
		} catch (NamingException | SQLException e) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").create();
			map.put("status", false);
			map.put("outputDate", new Date());
			map.put("message", e.getMessage());
			out.print(gson.toJson(map));
			e.printStackTrace();
		}
	}

}
