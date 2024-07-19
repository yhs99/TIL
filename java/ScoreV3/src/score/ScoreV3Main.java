package score;

import java.util.Scanner;

public class ScoreV3Main {

	private static StuClass cs;
	
	private static void outputMenu() {
		System.out.println("");
		System.out.println("*********************************************");
		System.out.println("*** 1.반생성                               ***");
		System.out.println("*** 2.학생정보입력(반 생성필수)              ***");
		System.out.println("*** 3.전체 학생 점수 출력                   ***");
		System.out.println("*** 4.반, 학생 자동 생성                    ***");
		System.out.println("*** 5.학번으로 검색                         ***");
		System.out.println("*** 0.종료                                ***");
		System.out.println("*********************************************");
		System.out.print("메뉴를 입력하세요 ==>==> ");
	}
	
	private static void createClass() {
		if(cs == null) {
			cs = new StuClass(1, "1반");
		}else {
			System.out.println("이미 반을 생성했습니다.");
		}
	}
	
	private static void addStudent() {
		int stuCnt = 0;
		if(cs == null) {
			System.out.println("반을 먼저 생성하세요.");
			return;
		}
		for(int i=0; i<cs.getStuList().length; i++) {
			if(!(cs.getStuList()[i]==null)) {
				stuCnt++;
			}
		}
		if(stuCnt >= StuClass.STUDENT_COUNT) {
			System.out.println("학생수 초과");
			return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("학생 번호를 입력하세요 => ");
		String stuNo = sc.nextLine();
		System.out.print("학생 이름을 입력하세요 => ");
		String stuName = sc.nextLine();
		System.out.print("학생 국어점수 입력하세요 => ");
		int kor = sc.nextInt();
		System.out.print("학생 영어점수 입력하세요 => ");
		int eng = sc.nextInt();
		System.out.print("학생 수학점수 입력하세요 => ");
		int math = sc.nextInt();
		cs.setStuList(new Student(stuNo, stuName, kor, eng, math));
	}
	
	private static void autoStudentInsert() {
		Student[] stuList = {new Student("1001", "홍길동", 100, 23, 100),
				new Student("1002", "동길홍", 67, 33, 50),
				new Student("1003", "길홍동", 70, 60, 40),
				new Student("1005", "홍홍홍", 23,44,55)};
			cs = new StuClass(1, "1반", stuList);
	}
	
	private static void searchStudentByNo() {
		if(cs == null) {
			System.out.println("반을 먼저 생성하세요.");
			return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("학생번호를 입력하세요");
		String str = sc.nextLine();
		boolean isFound = false;
		for(int i=0; i<cs.getStuList().length; i++) {
			if(cs.getStuList()[i].getStuNo().equals(str)) {
				isFound = true;
				System.out.printf("%s 학생의 정보입니다. : %s \n",str, cs.getStuList()[i]);
				return;
			}
		}
		if(!isFound) System.out.println("존재하지 않는 학생입니다.");
	}
	
	private static void outputStudents() {
		for(int i=0; i<cs.getStuList().length; i++) {
			System.out.println(cs.getStuList()[i]);
		}
		System.out.printf("반 총점 : %d, 전체 평균 : %.2f", cs.calTotal(), cs.calAvg());
	}

	public static void main(String[] args) {
		boolean runBool = true;
		while(runBool) {
			Scanner sc = new Scanner(System.in);
			outputMenu();
			int selected = sc.nextInt();
			switch(selected) {
				case 1:
					createClass();
					break;
				case 2:
					addStudent();
					break;
				case 3:
					outputStudents();
					break;
				case 4:
					autoStudentInsert();
					break;
				case 5:
					searchStudentByNo();
					break;
				default:
					runBool=false;
					break;
			}
		}
	}
	
}
