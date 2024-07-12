import java.util.Scanner;

public class Prob2 {

	public static void main(String[] args) {
		// 유저에게 숫자를 입력받아서 1부터 입력된 숫자까지의 총합을 출력하세요
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 => ");
		int scan = sc.nextInt();
		int sum = 0;
		for(int i=1; i<=scan; i++) {
			sum+= i;
		}
		System.out.printf("총합 : %d", sum);
	}

}
