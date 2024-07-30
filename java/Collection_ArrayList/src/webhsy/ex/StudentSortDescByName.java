package webhsy.ex;

import java.util.Comparator;

public class StudentSortDescByName implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o2.getName().compareTo(o1.getName());
	}

}
