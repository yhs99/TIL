package dept;

import emp.EmployeeIntern;
import emp.EmployeeParmernant;

public class DeptMain {
	public static void main(String[] args) {
		Dept dept = new Dept("IT");
		EmployeeIntern emp1 = new EmployeeIntern("IT", "001", "홍길동", 8);
		EmployeeParmernant emp2 = new EmployeeParmernant("IT", "002", "신정규");
		dept.addEmployee(emp1);
		dept.addEmployee(emp2);
		
		System.out.println(dept.toString());
	}
}
