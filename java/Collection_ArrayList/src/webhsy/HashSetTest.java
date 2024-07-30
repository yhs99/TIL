package webhsy;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
	public static void main(String[] args) {
		Korean k1 = new Korean("240730-1234567", "홍길동");
		Korean k2 = new Korean("240730-1234567", "홍길동");
		Set koreans = new HashSet<>();
		koreans.add(k1);
		koreans.add(k2);
		Student s1 = new Student();
		System.out.println(k1.equals(s1));
		System.out.println(koreans);
		System.out.println(k1.hashCode());
		System.out.println(k2.hashCode());
		System.out.println(k1.equals(k2));
	}
	
}
