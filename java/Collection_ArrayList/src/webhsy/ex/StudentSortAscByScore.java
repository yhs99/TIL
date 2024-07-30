package webhsy.ex;

import java.util.Comparator;

public class StudentSortAscByScore implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		int compare = o1.getStuNo().compareTo(o2.getStuNo());
        if (compare != 0) {
            return compare;
        }
        return Integer.compare(o2.getScore(), o1.getScore());
	}

}
