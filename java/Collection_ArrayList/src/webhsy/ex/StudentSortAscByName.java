package webhsy.ex;

import java.util.Comparator;

public class StudentSortAscByName implements Sortable, Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
