package webhsy;

import java.util.ArrayList;
import java.util.List;

public class RawTypeMain {

	public static void main(String[] args) {
		// raw타입의 ArrayList 객체 생성시 경고메시지
		// Generic 타입으로 사용할 것을 권고한다.
		List ar = new ArrayList<>();
		ar.add(11);
		ar.add(3.14f);
		ar.add(3.141592d);
		ar.add("대한민국");
		for (Object object : ar) {
			System.out.println(object);
		}
		
		List<String> ar2 = new ArrayList<String>();
		ar2.add("스트링");
		ar2.add("저장");
//		ar2.add(11); // 에러
		for (String string : ar2) {
			System.out.println(string);
		}
		
		// Generic 타입은 참조 타입만 사용가능
//		List<int> ar3 = new ArrayList<>(); // Wrapper Class로 선언해 주어야 한다.
		// ArrayList를 생성할 때 다형성을 구현하여 사용하는 것이 좋다.
		// ArrayList에서 Stack으로 변경을 할 때 하위 코드에 영향을 미치지 않기 때문이다.
		List<Integer> ar3 = new ArrayList<>();
		ar3.add(13);
	}
}
