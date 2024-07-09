public class DataTypesAndVariables {

	public static void main(String[] args) {
		// boolean : true | false (1byte)
		boolean bool = true; // 변수 bool를 선언과 동시에 할당함.
		System.out.println(bool);
		
		// char : 문자형, 2byte 한문자를 저장
		char character = 'a';
		System.out.println(character);
		
		char character2 = '가';
		System.out.println(character2);
		
		byte b = 127;
		System.out.println(b);
		System.out.println("Byte 타입 최대값 : "+ Byte.MAX_VALUE);
		System.out.println("Byte 타입 최소값 : "+ Byte.MIN_VALUE);
		
		// short : 정수형 2byte
		short sInt = 128;
		System.out.println(sInt);
		System.out.println("short 타입의 최대값 : " + Short.MAX_VALUE);
		System.out.println("short 타입의 최소값 : " + Short.MIN_VALUE);
		
		// int : 정수형 4byte
		int i = 35;
		System.out.println(i);
		System.out.println("int 타입 최대값 : " + Integer.MAX_VALUE);
		System.out.println("int 타입 최소값 : " + Integer.MIN_VALUE);
		
		// long : 정수형 8byte
		// int타입을 기본형으로 갖기 때문에 int타입 최대값보다 많은 값을 넣으려면
		// Long 리터럴 접미사를 주어야한다.
		long l = 2147483649L; // L, l 리터럴 접미사
		System.out.println(l);
		System.out.println("long 타입 최대값 : " + Long.MAX_VALUE);
		System.out.println("long 타입 최소값 : " + Long.MIN_VALUE);
		
		// float : 실수형
		// double타입을 주로 사용한다. 실수는 오차가 발생하기 때문에
		// 더 높은 정밀도를 가지기 위해서 double타입을 주로 사용한다.
		float f = 3.14f; // double타입이 기본형이기 때문에 float 접미사를 주어야한다.
		System.out.println(f);
		System.out.println("float 타입 최대값 : " + Float.MAX_VALUE);
		System.out.println("float 타입 최소값 : " + Float.MIN_VALUE);
		
		// double : 실수형. 8byte
		double d = 3.14;
		System.out.println(d);
		System.out.println("double 타입 최대값 : " + Double.MAX_VALUE);
		System.out.println("double 타입 최소값 : " + Double.MIN_VALUE);
		
		// 문자열 (String) : 참조타입
		String str = "문자열";
		System.out.println(str);
		System.out.println(str.getClass().getName());
		
		String str1 = ""; // 빈 문자열
//		char ch = ''; // 에러
		char ch = ' '; // 공백문자로 초기화
	}

}
