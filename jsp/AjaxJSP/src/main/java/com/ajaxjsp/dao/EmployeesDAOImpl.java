package com.ajaxjsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.ajaxjsp.vo.DepartmentVO;
import com.ajaxjsp.vo.EmployeeVO;
import com.ajaxjsp.vo.JobsVO;

public class EmployeesDAOImpl implements EmployeesDAO {
	
	private EmployeesDAOImpl() {};
	
	private static EmployeesDAOImpl instance;
	
	public static EmployeesDAOImpl getInstance() {
		if(instance == null) {
			instance = new EmployeesDAOImpl();
		}
		return instance;
	}
	
	@Override
	public List<EmployeeVO> selectAllEmp() throws NamingException, SQLException {

		Connection conn = DBConnection.dbConnect();
		String query = "SELECT e.employee_id, e.first_name, e.last_name, e.email, e.phone_number, e.hire_date, e.job_id, e.salary, e.commission_pct, e.manager_id, e.department_id, d.department_name "
				+ "FROM employees e INNER JOIN departments d "
				+ "ON e.department_id = d.department_id "
				+ "ORDER BY e.employee_id";
		List<EmployeeVO> employees = new ArrayList<EmployeeVO>();
		if(conn != null) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				employees.add(new EmployeeVO(rs.getInt("employee_id"),
											 rs.getString("first_name"),
											 rs.getString("last_name"),
											 rs.getString("email"),
											 rs.getString("phone_number"),
											 rs.getDate("hire_date"),
											 rs.getString("job_id"),
											 rs.getFloat("salary"),
											 rs.getFloat("commission_pct"),
											 rs.getInt("manager_id"),
											 rs.getInt("department_id"),
											 rs.getString("department_name")));
			}
	
			DBConnection.connClose(rs, pstmt, conn);
		}
		return employees;
	}

	@Override
	public List<JobsVO> selectAllJobs() throws NamingException, SQLException {
		Connection conn = DBConnection.dbConnect();
		String query = "SELECT job_id, job_title, min_salary, max_salary " +
						"FROM JOBS"; 
		List<JobsVO> jobs = new ArrayList<JobsVO>();
		if(conn != null) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				jobs.add(new JobsVO(rs.getString("job_id"),
						rs.getString("job_title"),
						rs.getInt("min_salary"),
						rs.getInt("max_salary")));
			}
			DBConnection.connClose(rs, pstmt, conn);
		}
		return jobs;
	}

	@Override
	public List<DepartmentVO> selectAllDepartments() throws NamingException, SQLException {
		Connection conn = DBConnection.dbConnect();
		String query = "SELECT department_id, department_name, manager_id, location_id " +
						"FROM departments";
		List<DepartmentVO> departments = new ArrayList<DepartmentVO>();
		if(conn != null) {
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				departments.add(new DepartmentVO(rs.getInt("department_id"), rs.getString("department_name"), rs.getInt("manager_id"), rs.getInt("location_id")));
			}
			DBConnection.connClose(rs, pstmt, conn);
		}
		return departments;
	}

}
