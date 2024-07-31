package webhsy.ex;

import java.util.Comparator;

public class StudentSortAscByStuNo implements Sortable, Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getStuNo().compareTo(o2.getStuNo());
	}

}
