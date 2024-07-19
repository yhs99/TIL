package modifier;

public class FinalLocalMain {
	
	public static void main(String[] args) {
		// 지역변수
		int num = 0;
		final int finalnum = 0;
		System.out.println(num);
		System.out.println(finalnum);
		method(10);
	}
	// 메서드의 매개변수에 final이 붙으면 메서드 내부에서 매개변수값을 변경할 수 없음
	static void method(final int param) {
		System.out.println(param);
	}
}
