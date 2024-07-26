package webhsy;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExMain {
	public static void main(String[] args) {
		int num = 0;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("정수를 입력하세요. =>> ");
			num = sc.nextInt();
			num = 3/num;
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}catch(ArithmeticException e) {
			e.printStackTrace();
		}
		System.out.println(num);
	}
}