
public class ArrayCopy {

	public static void main(String[] args) {
		char[] chArr = new char[] {'a','b','c'};
		
		// 원본배열 복사 (deep copy 원본 != 사본)
		char[] copyCharr = new char[chArr.length];
		int i=0;
		for(char c : chArr) { 
			copyCharr[i++] = c;
		}
		
		// 얕은복사 (참조 해쉬값이 같다. 원본 == 사본)
		char[] copyCharArr = chArr;
		chArr[0] = 'D';
		System.out.println(copyCharr);
		System.out.println(copyCharArr);
		
		// String
		System.out.println("------------------String-------------------");
		String str1 = "대한민국";
		String str2 = "대한민국";

		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		
		String str3 = new String("대한민국");
		String str4 = new String("대한민국");
		
		System.out.println(str3.hashCode());
		System.out.println(str4.hashCode());
		//문자열의 값을 비교하기 위해서는 equals() 메서드를 사용해야한다.
		System.out.println(str1.equals(str3)); // true
		System.out.println(str1 == str3); // false
		
		
		
		
		
	}

}
