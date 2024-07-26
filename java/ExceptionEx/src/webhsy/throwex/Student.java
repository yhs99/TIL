package webhsy.throwex;

public class Student{
	
	private String stuNo;
	private String stuName;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	private char grade;
	
	protected Student() {};
	
	protected Student(String stuNo, String stuName, int kor, int eng, int math) {
		
		this.stuNo = stuNo;
		this.stuName = stuName;
		if(kor >= 0 && kor <= 100) {
			this.kor = kor;
		}else {
			throw new IllegalArgumentException("잘못된 국어 점수 입니다.");
		}
		
		if(eng >= 0 && eng <= 100) {
			this.eng = eng;
		}else {
			throw new IllegalArgumentException("잘못된 영어 점수 입니다.");
		}
		
		if(math >= 0 && math <= 100) {
			this.math = math;
		}else {
			throw new IllegalArgumentException("잘못된 영어 점수 입니다.");
		}
		this.setTot();
		this.setAvg();
		this.setGrade();
	}
	
	protected String getStuNo() {
		return this.stuNo;
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
	
	protected double getAvg() {
		return avg;
	}
	
	protected int getTot() {
		return tot;
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

	@Override
	public String toString() {
		return "Student [학번=" + stuNo + ", 이름=" + stuName + ", 국어=" + kor + ", 영어=" + eng + ", 수학=" + math
				+ ", 총점=" + tot + ", 평균=" + avg + ", 학점=" + grade + "]";
	}
}

