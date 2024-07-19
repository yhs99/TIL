package exam;

public class InstanceCopyMain {

	public static void main(String[] args) {
		Student s1 = new Student("24001", "홍길동", 80, 98, 77);
		s1.displayScore();
		// 얕은 복사
		Student s2 = s1;
		s2.setKor(5);
		s2.displayScore();
		s1.displayScore();
		
		// 깊은 복사
		s2 = new Student(s1);
		s1.setEng(0);
		s1.displayScore();
		s2.displayScore();
		
		
	}

}
