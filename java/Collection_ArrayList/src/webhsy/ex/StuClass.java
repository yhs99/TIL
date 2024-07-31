package webhsy.ex;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class StuClass {
	private int classNo;
	private Set<Student> stuSet;
	
	public StuClass(int classNo, Set<Student> stuSet, Comparator<Student> method) {
		this.classNo = classNo;
		this.stuSet = new TreeSet<Student>(method);
		this.stuSet.addAll(stuSet);
	}
	
	@Override
	public String toString() {
		return "StuClass [classNo=" + classNo + ", stuSet=" + stuSet + "]";
	}

	public Set<Student> getStuSet() {
		return stuSet;
	}
	
	public int getClassNo() {
		return classNo;
	}
	
	public void outputEntrieStudnet() {
		for(Student s : this.stuSet) {
			System.out.println(s);
		}
	}
}