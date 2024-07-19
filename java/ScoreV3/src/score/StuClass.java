package score;

import java.util.Arrays;

public class StuClass {
	private int no;
	private String className;
	private Student[] stuList;
	private int total;
	private double totalAvg;
	
	protected static final int STUDENT_COUNT = 3;
	
	public StuClass() {
		System.out.println("반이 생성되었습니다.");
	}
	
	public StuClass(int no, String className) {
		this();
		this.no = no;
		this.className = className;
		this.stuList = new Student[STUDENT_COUNT];
	}
	public StuClass(int no, String className, Student[] students) {
		this();
		this.no = no;
		this.className = className;
		this.stuList = students;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Student[] getStuList() {
		return stuList;
	}

	public void setStuList(Student student) {
		for(int i=0; i<STUDENT_COUNT; i++) {
			if(stuList[i] == null) {
				stuList[i] = student;
				return;
			}
		}
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getTotalAvg() {
		return totalAvg;
	}

	public void setTotalAvg(double totalAvg) {
		this.totalAvg = totalAvg;
	}

	@Override
	public String toString() {
		return "StuClass [no=" + no + ", className=" + className + ", stuList=" + Arrays.toString(stuList) + ", total="
				+ calTotal() + ", totalAvg=" + calAvg() + "]";
	}
	
	

	public double calAvg() {
		int stuCnt = 0;
		totalAvg = 0d;
		for (Student student : stuList) {
			if(!(student == null)) {
				totalAvg += student.getAvg();
				stuCnt++;
			}
		}
		return totalAvg/stuCnt;
	}

	public int calTotal() {
		total = 0;
		for(Student student : stuList) {
			total += student == null ? 0 : student.getTot();
		}
		return total;
	}
	
}
