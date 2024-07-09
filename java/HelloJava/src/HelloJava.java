/*
 * 규칙) public class가 있는 경우, 소스파일의 이름은 public class 이름과 일치해야한다.
 */
public class HelloJava { // HelloJava 클래스의 시작
	public static void main(String[] args) { // main 메서드 (프로그램 실행 시작점) 시작
		HelloA a = new HelloA();
		HelloA b = new HelloA();
		HelloA c = new HelloA();
		HelloA d = new HelloA();
		a.sysHello();
	}
} // HelloJava 클래스의 끝

class HelloA {
	public static int a = 0;
	HelloA() {
		a++;
		System.out.println(a);
	}
	public void sysHell() {
		System.out.println("Say Hello!");
	}
	public void sysHello() {
		// TODO Auto-generated method stub
		System.out.println("Say Hello2!");
	}
}