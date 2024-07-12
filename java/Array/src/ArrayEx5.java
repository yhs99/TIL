import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayEx5 {

	public static void main(String[] args) {
		System.out.print("찾을 번호를 적어주세요. =>");
		Scanner sc = new Scanner(System.in);
		int findNum = sc.nextInt();
		sc.close();
		int[] randomN = new int[20];
		int findIndex = 0;
		Random r = new Random();
		for(int i=0; i<randomN.length; i++) {
			randomN[i] = (int) (Math.random() * 100 + 1);
		}
		for(int i=0; i<randomN.length; i++) {
			if(randomN[i] == findNum) {
				findIndex = i+1;
				break;
			}
		}
		System.out.println(Arrays.toString(randomN));
		System.out.printf("%d 번째에 있습니다.", findIndex);
	}

}
