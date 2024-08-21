package com.ajaxjsp.dao;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.ajaxjsp.vo.DepartmentVO;
import com.ajaxjsp.vo.EmployeeVO;
import com.ajaxjsp.vo.JobsVO;

public interface EmployeesDAO {
	List<EmployeeVO> selectAllEmp() throws NamingException, SQLException;
	List<JobsVO> selectAllJobs() throws NamingException, SQLException;
	List<DepartmentVO> selectAllDepartments() throws NamingException, SQLException;
}
