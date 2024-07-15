
public class MethodParams1 {

	static int a = 10;
	
	public static void main(String[] args) {
		int a = 10;
		System.out.println("메서드 호출 전 a = " + a);
		callPrimitiveParam(a);
		System.out.println("메서드 호출 후 a = " + a);
	}
	
	static void callPrimitiveParam(int x) {
		a = 20;
	}
}
