package webhsy;

import java.util.Comparator;

public class IdComparator implements Comparator<User>{

	@Override
	public int compare(User o1, User o2) {
		return o2.getUserId().compareTo(o1.getUserId());
	}

}
