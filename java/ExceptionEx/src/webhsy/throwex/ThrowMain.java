package webhsy.throwex;

public class ThrowMain {
	public static void main(String[] args) {
		Student stu1 = null;
		try {
			stu1 = new Student("24001", "홍길동", 80, 90, 60);
		}catch (IllegalArgumentException e) {
			e.printStackTrace();
		}catch (NullPointerException e) {
			e.printStackTrace();
		}
		
	}
}
