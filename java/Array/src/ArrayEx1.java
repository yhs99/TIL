import java.util.Arrays;

public class ArrayEx1 {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		char[] charArr = new char[3];
		int[] scores = new int[3]; // int타입 배열은 자동 초기화된다. [0,0,0]
		System.out.println(scores); // [I@48cf768c << 타입@주소 (16진수)
		
		String[] names = new String[5]; // String타입의 배열은 null로 자동 초기화된다.
		System.out.println(names);
		
		boolean[] isOk = new boolean[2]; // boolean타입의 배열은 false로 초기화된다. 
		System.out.println(isOk);
		
		// 배열 요소에 값 할당
		scores[0] = 45;
		scores[1] = 23;
		scores[2] = 100;

		// 배열의 크기를 변경
		scores = new int[4];
		System.out.println(scores.length);
		
		int[] scores2 = {100,200,300,400,500};
		int[] scores3 = new int[] {10,20,30,40,50};
		System.out.println(Arrays.toString(scores2));
		
		int[] scores4 = {10,20,30,40,50}; // 선언시에만 가능한 방법.
		String[] heroes = {"아이언맨", "스파이더맨", "헐크"};
		// for문
		for (int i = 0; i < heroes.length; i++) {
			String string = heroes[i];
			System.out.println(string);
		}
		// 확장for문 (foreach)
		for (String string : heroes) {
			System.out.println(string);
		}
		
		
	}

}