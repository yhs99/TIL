package exam;

public class Student {
	private String stuNo;
	private String stuName;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	private char grade;
	private static int total;
	
	protected Student(Student s) {
		this.stuNo = s.stuNo;
		this.stuName = s.stuName;
		this.kor = s.kor;
		this.eng = s.eng;
		this.math = s.math;
		this.tot = s.tot;
		this.avg = s.avg;
		this.grade = s.grade;
	}
	
	protected Student(String stuNo, String stuName, int kor, int eng, int math) {
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.setTot();
		this.setAvg();
		this.setGrade();
		total += tot;
	}
	public static int getTotal() {
		return total;
	}
	protected void setTotal(int score) {
		Student.total += score;
	}
	protected void setKor(int kor) {
		this.kor = kor;
		setScores();
	}
	
	protected void setEng(int eng) {
		this.eng = eng;
		setScores();
	}
	
	protected void setMath(int math) {
		this.math = math;
		setScores();
	}
	
	private void setTot() {
		this.tot = this.kor + this.eng + this.math;
	}
	
	private void setAvg() {
		this.avg = (double)this.tot / 3;
	}
	
	private void setGrade() {
		int score = (int) (this.avg/10);
		this.grade = score >= 9 ? 'A' :
					score >= 8 && score < 9 ? 'B' :
					score >= 7 && score < 8 ? 'C' :
					score >= 6 && score < 7 ? 'D' : 'F';
	}
	
	private void setScores() {
		setTot();
		setAvg();
		setGrade();
	}
	
	protected void displayScore() {
		System.out.printf("학번 : %s, 이름 : %s, 국어 : %d, 영어 : %d, 수학 : %d, 총점 : %d, 평균 : %.2f 학점 : %c \n",stuNo, stuName, kor, eng, math, tot, avg, grade);
	}
}
