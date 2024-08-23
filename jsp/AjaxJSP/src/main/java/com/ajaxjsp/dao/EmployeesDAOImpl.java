package com.ajaxjsp.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.ajaxjsp.dto.EmployeeDTO;
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
				+ "WHERE quit_date IS NULL "
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

	@Override
	public String insertEmployee(EmployeeDTO employee) throws NamingException, SQLException {
		Connection conn = null;
		CallableStatement cstmt = null;
		String flag = "";
		try {
			conn = DBConnection.dbConnect();
			if(conn != null) {
				cstmt = conn.prepareCall("{call INSERT_EMPLOYEE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
				cstmt.setString(1, employee.getFirst_name());
				cstmt.setString(2, employee.getLast_name());
				cstmt.setString(3, employee.getEmail());
				cstmt.setString(4, employee.getPhone_number());
				cstmt.setDate(5, (Date) employee.getHire_date());
				cstmt.setString(6, employee.getJob_id());
				cstmt.setFloat(7, employee.getSalary());
				cstmt.setFloat(8, employee.getCommission_pct());
				cstmt.setInt(9, employee.getManager_id());
				cstmt.setInt(10, employee.getDepartment_id());
				cstmt.registerOutParameter(11, java.sql.Types.VARCHAR);
				cstmt.executeUpdate();
				flag = cstmt.getString(11);
			}
			System.out.println("flag : " + flag);
			return flag;
		}finally {
			DBConnection.connClose(cstmt, conn);
		}
	}

	@Override
	public int updateEmployee(EmployeeDTO employee) throws NamingException, SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int update = 0;
		try {
			String sql = "UPDATE employees " +
						"SET first_name = ?, " +
						"last_name = ?, " +
						"email = ?, " +
						"phone_number = ?, " +
						"hire_date = ?, " +
						"job_id = ?, " +
						"salary = ?, " +
						"commission_pct = ?, " +
						"manager_id = ?, " +
						"department_id = ? " +
						"WHERE employee_id = ?";
			
			conn = DBConnection.dbConnect();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, employee.getFirst_name());
			pstmt.setString(2, employee.getLast_name());
			pstmt.setString(3, employee.getEmail());
			pstmt.setString(4, employee.getPhone_number());
			pstmt.setDate(5, (Date) employee.getHire_date());
			pstmt.setString(6, employee.getJob_id());
			pstmt.setFloat(7, employee.getSalary());
			pstmt.setFloat(8, employee.getCommission_pct());
			pstmt.setInt(9, employee.getManager_id());
			pstmt.setInt(10, employee.getDepartment_id());
			pstmt.setInt(11, employee.getEmployee_id());
			update = pstmt.executeUpdate();
		}finally {
			DBConnection.connClose(pstmt, conn);
		}
		return update;
	}

	@Override
	public int deleteEmployee(int employee_id, Date sysdate) throws NamingException, SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DBConnection.dbConnect();
			String sql = "UPDATE employees " +
						 "SET quit_date = ?" +
						 "WHERE employee_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, sysdate);
			pstmt.setInt(2, employee_id);
			result = pstmt.executeUpdate();
			System.out.println(this.getClass());
			System.out.println("EXECUTE QUERY : " + pstmt.toString().toString());
		}finally {
			DBConnection.connClose(pstmt, conn);
		}
		return result;
	}

	@Override
	public List<EmployeeVO> employeeSearchByName(String name, String sort, String method) throws NamingException, SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<EmployeeVO> employees = new ArrayList<EmployeeVO>();
		try {
			conn = DBConnection.dbConnect();
			String query = "SELECT e.*, d.department_name "
					+ "FROM employees e, departments d "
					+ "WHERE e.department_id = d.department_id "
					+ "AND (lower(e.first_name) LIKE ? or lower(e.last_name) LIKE ?) "
					+ "AND quit_date is null ";
			if(!sort.isEmpty() && !method.isEmpty()) {
				query += "ORDER BY " + sort + " " + method;
			}
			System.out.println("SEARCH Q : " + query);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+name+"%");
			pstmt.setString(2, "%"+name+"%");
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
		}catch (Exception e) {
			e.printStackTrace();
		}
		return employees;
	}

}
