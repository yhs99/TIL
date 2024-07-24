package emp;

public class EmployeeParmernant extends Employee {
	private int salary=300000;
	
	public EmployeeParmernant(String deptName, String empNo, String name) {
		super(deptName, empNo, name);
	}

	@Override
	public int calculateSal() {
		return salary;
	}
	
	@Override
	public String toString() {
		return super.toString() + "구분 : 정규, 급여 : " + calculateSal() + "\n";
	}
}
