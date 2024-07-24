package emp;

public abstract class Employee{
	private String deptName;
	private String empNo;
	private String name;
	protected abstract int calculateSal();

	protected Employee(String deptName, String empNo, String name) {
		this.deptName = deptName;
		this.empNo = empNo;
		this.name = name;
	}
	
	public String getEmpNo() {
		return empNo;
	}
	
	public String getName() {
		return name;
	}
	

	@Override
	public String toString() {
		return "부서 : "+ deptName +", 사원번호 : " + empNo + ", 이름 : " + name + ", ";
	}

	
}
