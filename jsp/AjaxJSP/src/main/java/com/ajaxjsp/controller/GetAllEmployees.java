package com.ajaxjsp.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.ajaxjsp.dao.EmployeesDAO;
import com.ajaxjsp.dao.EmployeesDAOImpl;
import com.ajaxjsp.dto.EmployeeDTO;
import com.ajaxjsp.etc.OutputJSONForError;
import com.ajaxjsp.vo.EmployeeVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class GetAllEmployees
 */
@WebServlet("/employees")
public class GetAllEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EmployeesDAO dao = EmployeesDAOImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			List<EmployeeVO> list = dao.selectAllEmp();
			// JSON-SIMPLE LIB
//			JSONObject jo = new JSONObject();
//			JSONArray ja = new JSONArray();
//			SimpleDateFormat date = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
//			jo.put("status", "ok");
//			jo.put("outputDate", date.format(new Date()));
//			jo.put("size", list.size());
//			if(list.size() > 0) {
//				for(EmployeeVO e : list) {
//					JSONObject j = new JSONObject();
//					j.put("employee_id", e.getEmployee_id());
//					j.put("first_name", e.getFirst_name());
//					j.put("last_name", e.getLast_name());
//					j.put("email", e.getEmail());
//					j.put("phone_number", e.getPhone_number());
//					Date d = e.getHire_date();
//					SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
//					j.put("hire_date", s.format(d));
//					j.put("job_id", e.getJob_id());
//					j.put("salary",e.getSalary());
//					j.put("commission_pct", e.getCommission_pct());
//					j.put("manager_id", e.getManager_id());
//					j.put("department_id", e.getDepartment_id());
//					j.put("department_name", e.getDepartment_name());
//					ja.add(j);
//				}
//			}
//			jo.put("datas", ja);
//			out.print(jo.toJSONString());
//			out.close();
			
			
			//GSON
			String json = toJsonWithGson(list);
			out.print(json);
			out.close();
			
			
		}catch(NamingException | SQLException e) {
			response.getWriter().print(OutputJSONForError.outputJson(e));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject a = new JSONObject();
		PrintWriter out = response.getWriter();
		
		try {
			EmployeeDTO emp = new EmployeeDTO(301,
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
			String isComplete = dao.insertEmployee(emp);
			a.put("status", isComplete);
			a.put("message", "success");
			out.print(a.toJSONString());
		}catch(IllegalArgumentException | SQLException | NamingException e) {
			a.put("status", false);
			a.put("message", e.getMessage());
			e.printStackTrace();
			out.print(a.toJSONString());
		}
	}
	private String toJsonWithGson(List<EmployeeVO> list) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		JSONObject j = new JSONObject();
		SimpleDateFormat date = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		j.put("status", "ok");
		j.put("outputDate", date.format(new Date()));
		j.put("size", list.size());
		j.put("datas", list);
		return gson.toJson(j);
	}

}
