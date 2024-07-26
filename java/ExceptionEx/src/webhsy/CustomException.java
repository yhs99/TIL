package webhsy;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomException {
	public static void main(String[] args) {
		try {
			scan();
		} catch (NotPositiveInteger e) {
			e.printStackTrace();
		} catch (InputMismatchException e) {
			e.printStackTrace();
		}
	}
	
	public static void scan() throws NotPositiveInteger {
		Scanner sc = new Scanner(System.in);
		System.out.print("양수 입력 ==> ");
		int num = sc.nextInt();
		if(num <= 0) {
			throw new NotPositiveInteger("양수만 입력하세요.");
		}
		System.out.println(num);
	}
}
