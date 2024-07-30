package webhsy.ex;

import java.util.Comparator;

public class StudentSortDescByScore implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		int comInt = Integer.compare(o1.getScore(), o2.getScore());
		int compares = o1.getStuNo().compareTo(o2.getStuNo());	
        if (compares != 0) {
            return compares;
        }
        return comInt;
	}

}
