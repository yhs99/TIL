package webhsy.throwsex;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ThrowsMain {
	public static void main(String[] args) {
		System.out.print("숫자를 입력하세요 ==> ");
		int num = 0;
		try {
			num = getPositiveNumber();
		}catch (InputMismatchException e) {
			e.printStackTrace();
		}
		System.out.println(num);
	}
	
	private static int getPositiveNumber() throws InputMismatchException{
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
}
