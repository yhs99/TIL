
public class MemberCall {
	int iv = 10; // instance variable
	static int cv = 20; // class variable
	
	int iv2 = cv;
//	static int cv2 = iv; // Cannot make a static references to the non-static field iv
	
	static void staticMethod1() {
		// 클래스 메서드 안에서 인스턴스 변수를 사용하기 위해서는 객체를 생성해주어야한다.
		MemberCall mc = new MemberCall();
		
		System.out.println(cv);
		System.out.println(mc.iv);
	}
	
	void instanceMethod1() {
		System.out.println(cv);
		System.out.println(iv);
	}
	
	public static void main(String[] args) {
		staticMethod1();
		MemberCall m = new MemberCall();
		m.instanceMethod1();
	}

}
