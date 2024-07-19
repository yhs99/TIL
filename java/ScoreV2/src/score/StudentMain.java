package score;

public class StudentMain {

	public static void main(String[] args) {
		Student s1 = new Student("24001", "홍길동", 98, 75, 34);
		s1.displayScore();
		Student s2 = new Student("24001", "홍길동", 98, 75, 34);
		s2.displayScore();
		System.out.println(Student.getTotal());
		s1.setEng(77);
		System.out.println(Student.getTotal());
	}

}
