package com.ajaxjsp.dao;

import java.sql.SQLException;
import java.util.List;
import java.sql.Date;

import javax.naming.NamingException;

import com.ajaxjsp.dto.EmployeeDTO;
import com.ajaxjsp.vo.DepartmentVO;
import com.ajaxjsp.vo.EmployeeVO;
import com.ajaxjsp.vo.JobsVO;

public interface EmployeesDAO {
	List<EmployeeVO> selectAllEmp() throws NamingException, SQLException;
	List<JobsVO> selectAllJobs() throws NamingException, SQLException;
	List<DepartmentVO> selectAllDepartments() throws NamingException, SQLException;
	String insertEmployee(EmployeeDTO employee) throws NamingException, SQLException;
	int updateEmployee(EmployeeDTO employee) throws NamingException, SQLException;
	int deleteEmployee(int employee_id, Date sysdate) throws NamingException, SQLException;
	List<EmployeeVO> employeeSearchByName(String name, String sort, String method) throws NamingException, SQLException;
}
