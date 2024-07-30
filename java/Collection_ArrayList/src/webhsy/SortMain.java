package webhsy;

import java.util.ArrayList;
import java.util.List;

public class SortMain {

	public static void main(String[] args) {
		User u1 = new User("11", 5);
		User u2 = new User("22", 15);
		User u3 = new User("33", 3);
		User u4 = new User("44", 27);
		List<User> uL = new ArrayList<User>();
		uL.add(u1);
		uL.add(u2);
		uL.add(u3);
		uL.add(u4);
		uL.sort(new IdComparator());
		System.out.println(uL);
	}

}
