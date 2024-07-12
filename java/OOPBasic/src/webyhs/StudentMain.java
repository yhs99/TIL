package webyhs;

import java.util.ArrayList;

public class StudentMain {

	public static void main(String[] args) {
		Student stu = new Student();
		Student stu1 = new Student();
		stu.name = "홍길동";
		stu.kor = 50;
		stu.grade= 'D';
		System.out.println("student : " + stu.name + ", kor = " + stu.kor + ", grade = " + stu.grade);
		
		stu1.name = "둘리";
		stu1.kor = 80;
		stu1.grade = 'B';
		System.out.println("student : " + stu1.name + ", kor = " + stu1.kor + ", grade = " + stu1.grade);
		
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(stu);
		students.add(stu1);
		students.get(0).getStudent();
	}

}
