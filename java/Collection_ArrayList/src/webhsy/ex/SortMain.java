package webhsy.ex;

import java.util.Set;
import java.util.TreeSet;

public class SortMain {

	public static void main(String[] args) {
		Student s1 = new Student("24001", "홍길동", 90);
		Student s2 = new Student("24001", "홍길서", 60);
		Student s5 = new Student("24001", "홍길서", 20);
		Student s6 = new Student("24001", "홍길서", 20);
		Student s3 = new Student("24002", "홍길남", 60);
		Student s4 = new Student("24003", "홍길북", 60);
		
		Set<Student> ts = new TreeSet<Student>();
		ts.add(s1);
		ts.add(s2);
		ts.add(s3);
		ts.add(s4);
		ts.add(s5);
		ts.add(s6);

		System.out.println("학번 기준 내림차순");
		System.out.println(ts);
		
		Set<Student> tsStuNoAsc = new TreeSet<Student>(new StudentSortAscByStuNo());
		tsStuNoAsc.addAll(ts);
		System.out.println("학번기준 오름차순");
		System.out.println(tsStuNoAsc);
		
		Set<Student> tsScoreDesc = new TreeSet<Student>(new StudentSortDescByScore());
		tsScoreDesc.addAll(ts);
		System.out.println("점수기준 내림차순");
		System.out.println(tsScoreDesc);
		
		Set<Student> tsScoreAsc = new TreeSet<Student>(new StudentSortAscByScore());
		tsScoreAsc.addAll(ts);
		System.out.println("점수기준 오름차순");
		System.out.println(tsScoreAsc);
		
		Set<Student> tsNameDesc = new TreeSet<Student>(new StudentSortDescByName());
		tsNameDesc.addAll(ts);
		System.out.println("이름기준 내림차순");
		System.out.println(tsNameDesc);
		
		Set<Student> tsNameAsc = new TreeSet<Student>(new StudentSortAscByName());
		tsNameAsc.addAll(ts);
		System.out.println("이름기준 오름차순");
		System.out.println(tsNameAsc);
		
	}

}
