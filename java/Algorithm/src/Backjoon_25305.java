import java.util.Arrays;
import java.util.Scanner;

public class Backjoon_25305 {
	/*
	 * https://www.acmicpc.net/problem/25305
	 */
	private static Scanner sc = new Scanner(System.in);
	private static String str = sc.nextLine();
	private static String scores = sc.nextLine();
	private static String[] scan = str.split(" ");
	private static String[] scanScores = scores.split(" ");
	private static int[] parse = Arrays.stream(scanScores).mapToInt(Integer::parseInt).toArray();
	
	public static void main(String[] args) {
			for(int i=0; i<parse.length-1; i++) {
				for(int j=i+1; j<parse.length; j++) {
					if(parse[i] < parse[j]) {
						int temp =parse[i];
						parse[i] = parse[j];
						parse[j] = temp;
					}
					
				}
			}
			System.out.println(parse[Integer.parseInt(scan[1])-1]);
		}
}