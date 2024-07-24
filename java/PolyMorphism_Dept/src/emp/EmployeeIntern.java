package emp;

public class EmployeeIntern extends Employee {
	private int workTime;
	private int salary=9870;
	
	public EmployeeIntern(String deptName, String empNo,String name, int workTime) {
		super(deptName, empNo, name);
		this.workTime = workTime;
	}
	
	@Override
	public int calculateSal() {
		return this.workTime * this.salary;
	}
	
	@Override
	public String toString() {
		return super.toString() + "구분 : 인턴, 급여 : " + calculateSal() + "\n";
	}
}
