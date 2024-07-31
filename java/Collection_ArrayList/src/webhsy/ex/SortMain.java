package webhsy.ex;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SortMain {

	public static void main(String[] args) {
		Student s1 = new Student("24001", "홍길동", 80);
		Student s2 = new Student("24004", "홍길서", 60);
		Student s5 = new Student("24001", "홍길서", 20);
		Student s6 = new Student("24001", "홍길서", 20);
		Student s3 = new Student("24002", "홍길남", 70);
		Student s4 = new Student("24003", "홍길북", 30);
		
		while(true) {
			try {
				System.out.println("1. 학번순 정렬 (오름차순)");
				System.out.println("2. 이름순 정렬 (오름차순)");
				System.out.println("3. 성적순 정렬 (내림차순)");
				System.out.print("정렬 기준 선택 ==> ");
				Scanner sc = new Scanner(System.in);
				int num = sc.nextInt();
				StuClass clas = new StuBuilder()
									.classNo(1)
									.method(SortManager.getSortMethod(num))
									.stuSet(s1)
									.stuSet(s2)
									.stuSet(s3)
									.stuSet(s4)
									.stuSet(s5)
									.stuSet(s6)
									.build();
				System.out.println(clas.getClassNo() + "반 목록");
				for(Student out : clas.getStuSet()) {
					System.out.println(out);
				}
			}catch(NullPointerException e) {
				System.out.println("존재하지 않는 선택지");
				e.printStackTrace();
			}catch(InputMismatchException e) {
				System.out.println("잘못된 입력");
			}
		}
//		
//		Set<Student> tsStuNoAsc = new TreeSet<Student>(new StudentSortAscByStuNo());
//		tsStuNoAsc.addAll(ts);
//		System.out.println("학번기준 오름차순");
//		System.out.println(tsStuNoAsc);
//		
//		Set<Student> tsScoreDesc = new TreeSet<Student>(new StudentSortDescByScore());
//		tsScoreDesc.addAll(ts);
//		System.out.println("점수기준 내림차순");
//		System.out.println(tsScoreDesc);
//		
//		Set<Student> tsScoreAsc = new TreeSet<Student>(new StudentSortAscByScore());
//		tsScoreAsc.addAll(ts);
//		System.out.println("점수기준 오름차순");
//		System.out.println(tsScoreAsc);
//		
//		Set<Student> tsNameDesc = new TreeSet<Student>(new StudentSortDescByName());
//		tsNameDesc.addAll(ts);
//		System.out.println("이름기준 내림차순");
//		System.out.println(tsNameDesc);
//		
//		Set<Student> tsNameAsc = new TreeSet<Student>(new StudentSortAscByName());
//		tsNameAsc.addAll(ts);
//		System.out.println("이름기준 오름차순");
//		System.out.println(tsNameAsc);
		
	}

}

class StuBuilder {
	private int classNo;
	private Set<Student> stuSet;
	private Comparator<Student> method;

	public StuBuilder classNo(int classNo) {
		this.classNo = classNo;
		return this;
	}
	public StuBuilder method(Comparator<Student> method) {
		this.method = method;
		stuSet = new TreeSet<Student>(method);
		return this;
	}
	public StuBuilder stuSet(Student stuSet) {
		this.stuSet.add(stuSet);
		return this;
	}
	
	public StuClass build() {
		return new StuClass(this.classNo, this.stuSet, this.method);
	}
}