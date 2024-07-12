import java.util.Scanner;

public class ScannerEx1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		System.out.print("이름을 입력하세요 => ");
//		String name = sc.nextLine();
//		
//		System.out.print("나이를 입력하세요 => ");
//		int age = sc.nextInt();
//		System.out.print("키를 입력하세요 => ");
//		double height = sc.nextDouble();
//		System.out.println(name);
//		System.out.println(age);
//		System.out.println(height);
		
		// 유저에게 숫자를 입력받아서, 짝수인지 홀수인지 출려갛는 프로그램을 만드세요
		System.out.print("숫자를 입력하세요 => ");
		System.out.print(sc.nextInt() % 2 == 0 ? "짝수입니다." : "홀수입니다.");
	}
}
