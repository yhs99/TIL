package com.ajaxjsp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.ajaxjsp.dao.EmployeesDAO;
import com.ajaxjsp.dao.EmployeesDAOImpl;
import com.ajaxjsp.dto.EmployeeDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/modify")
public class ModifyEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EmployeesDAO dao = EmployeesDAOImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		JSONObject a = new JSONObject();
		PrintWriter out = response.getWriter();
		System.out.println("POST");
		try {
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			EmployeeDTO emp = new EmployeeDTO(
					Integer.parseInt(request.getParameter("employee_id")),
					request.getParameter("first_name"),
					request.getParameter("last_name"),
					request.getParameter("email"),
					request.getParameter("phone_number"),
					java.sql.Date.valueOf(request.getParameter("hire_date")),
					request.getParameter("job_id"),
					Float.parseFloat(request.getParameter("salary")),
					request.getParameter("commission_pct") == "0" ? 0 : Float.parseFloat(request.getParameter("commission_pct"))/100,
					Integer.parseInt(request.getParameter("manager_id")),
					Integer.parseInt(request.getParameter("department_id")));
			System.out.println(emp.toString());
			int result = dao.updateEmployee(emp);
			System.out.println(result);
			a.put("status", true);
			a.put("message", "success");
			a.put("outputDate", new Date());
			out.print(gson.toJson(a));
		}catch(NamingException | SQLException e) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").create();
			a.put("status", false);
			a.put("outputDate", new Date());
			a.put("message", e.getMessage());
			out.print(gson.toJson(a));
		}
	
	}

}
