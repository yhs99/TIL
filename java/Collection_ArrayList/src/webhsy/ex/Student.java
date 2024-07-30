package webhsy.ex;

public class Student implements Comparable<Student> {
	private String stuNo;
	private String name;
	private int score;
	
	public Student(String stuNo, String name, int score) {
		this.stuNo = stuNo;
		this.name = name;
		this.score = score;
	}
	
	public String getStuNo() {
		return stuNo;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	@Override
	public int hashCode() {
		return this.stuNo.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student a = (Student) obj;
			return this.stuNo.equals(a.stuNo);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Student [stuNo=" + stuNo + ", name=" + name + ", score=" + score + "]";
	}

	@Override
	public int compareTo(Student s) {
		// TODO Auto-generated method stub
		// 내림차순
		return s.stuNo.compareTo(this.stuNo);
		// 오름차순
		//return this.stuNo.compareTo(s.stuNo);
	}
	
}
