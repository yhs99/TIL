
public class MethodCreation {
//[접근제한자][static] 반환갑타입 | void 메서드이름 ([매개변수타입 매개변수이름]) {//메서드선언}
	public static void main(String[] args) {
		
		// non-static 메서드 호출
		MethodCreation m = new MethodCreation();
		m.add(5.3f, 3.33f);
		
		// static 메서드 호출
		MethodCreation.add(100, 200);
		
		// 이름이 outputNTimes 이고 매개변수는 String 타입 변수 하나와 int타입 변수(n)을 받아서
		// 받은 문자열을 화면에 n번 반복해서 출력하는 메서드를(인스턴스 메서드)를 만들고 호출하세요
//		m.outputNTimes("안녕하세요", 5);

		System.out.println(m.add(1, 5l));
	}
	
	public void outputNTimes(String str, int n) {
		for(int i=0; i<n; i++) {
			System.out.println(str);
		}
	}

	public float add(float a, float b) {
		float c = a + b;
		return c;
	}
	
	public static int add(int a, int b) {
		return a+b;
	}
	
	public static int add(int a, int b, int c) {
		return a+b+c;
	}
	
	public long add(int a, long b) {
		return a + b;
	}
}