package webhsy.ex;

import java.util.Comparator;

public class StudentSortAscByScore implements Sortable, Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getScore(), o2.getScore());
	}

}
