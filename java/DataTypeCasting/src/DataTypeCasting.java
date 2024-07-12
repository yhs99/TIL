
public class DataTypeCasting {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// 데이터 타입 형 변환 (cast)
		byte b = 125;

		// 묵시적(자동) 형변환(casting) 프로그래머가 형 변환 연산자를 쓰지 않아도
		// 자동으로 형변환을 한다. 보통 작은 타입에서 큰 타입으로 변환할 때 묵시적 형변환이 일어난다.
		int i = b;
		System.out.println(i); // 125
		
		// int => float
		float f = 1234;
		float f1 = (float) 1234; // 원래 이와같이 형변환이 있어야 하지만, 생략된다.
		
		// float => int
		int j = (int) 3.14;
		System.out.println(j); // 3
		
		// int => byte
		int i2 = 300;
		byte b2 = (byte) i2;
		System.out.println(b2); // overflow가 발생하여 44가 출력된다.
		
		// int => short
		int i3 = 32767;
		short s = (short) i3;
		System.out.println(s); // 32767
		
		// 정수 실수 나누기
		int intNum1 = 1;
		int intNum2 = 2;
		float divNum1 = (float) intNum1 / intNum2;
		System.out.println(divNum1);
		
		// 문자열 변환
		int result3 = 1 + 2+ 3;
		System.out.println("result3 = " + result3); // 6
		
		String result4 = 1+2+"3";
		System.out.println("result4 = " + result4); // 33
		
		String result5 = "1"+2+3;
		System.out.println("result4 = " + result5); // 123
		
		String result6 = "1"+(2+3);
		System.out.println("result4 = " + result6); // 15
		
		// 문자열 => 숫자
		int a = Integer.parseInt(result6);
		System.out.println(a);
		
		// 숫자 => 문자열
		String str1 = Integer.toString(a);
		System.out.println(str1);
		
	}
}
