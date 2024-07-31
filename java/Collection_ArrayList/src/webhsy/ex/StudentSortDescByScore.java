package webhsy.ex;

import java.util.Comparator;

public class StudentSortDescByScore implements Sortable, Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
        return Integer.compare(o2.getScore(), o1.getScore());
	}

}
