import java.util.Scanner;

public class ArrayEx2 {

	public static void main(String[] args) {
		exchange();
		System.out.println();
		minMax();
	}

	@SuppressWarnings("resource")
	static void exchange() {
		System.out.printf("거스름돈을 입력하세요 => ");
		int money = new Scanner(System.in).nextInt();
		int[] coins = {500,100,50,10};
		int[] exchange = new int[coins.length];
		for(int i=0; i<coins.length; i++) {
			exchange[i] = (money/coins[i]);
			money = money - exchange[i] * coins[i];
			System.out.printf("%d원 짜리 %d개, ", coins[i], exchange[i]);
		}
	}

	static void minMax() {
		// 유저에게 n개의 정수를 입력받아 배열에 저장한 후
		// 최소값, 최대값을 찾아서 출력하는 프로그램
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		Scanner sc = new Scanner(System.in);
		System.out.print("정수의 갯수를 입력하세요. => ");
		int count = sc.nextInt();
		int[] arr = new int[count];
		for(int i=0; i<count; i++) {
			System.out.printf("%d번째 정수를 입력하세요 => ", i+1);
			int userValue = sc.nextInt();
			arr[i] = userValue;
			if(userValue > max) {
				max = userValue;
			}
			if(userValue < min) {
				min = userValue;
			}
		}
		sc.close();
		System.out.printf("입력한 정수의 최대값은 %d, 최소값은 %d 입니다.",max, min);
	}
}
