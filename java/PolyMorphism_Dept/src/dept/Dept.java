package dept;


import java.util.ArrayList;
import java.util.List;

import emp.Employee;

public class Dept {
	private String deptName;
	private List<Employee> employees;
	
	protected Dept(String deptName) {
		this.deptName = deptName;
		employees = new ArrayList<Employee>();
	}
	
	public String getDeptName() {
		return deptName;
	}
	
	public void addEmployee(Employee emp) {
		employees.add(emp);
	}
	
	public String toString() {
		String str = "";
		for(Employee emp : employees) {
				str += emp;
		}
		return deptName + "부서의 사원 목록 \n" + str;
	}
}
