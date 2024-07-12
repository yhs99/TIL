import java.util.Arrays;

public class ShuffleBubbleSort {

	public static void main(String[] args) {
		int[] numbers = {1,2,3,4,5,6,7,8,9};
		System.out.println("배열 : " + Arrays.toString(numbers));
		for(int i=0; i<numbers.length; i++) {
			int a = (int) (Math.random()*numbers.length);
			int b =  (int) (Math.random()*numbers.length);
			int temp = numbers[a];
			numbers[a] = numbers[b];
			numbers[b] = temp;
		}
		boolean isSwapped = true;
		int cnt = 0;
		System.out.println("셔플 : " + Arrays.toString(numbers));
		
		for(int i=0; i<numbers.length-1; i++) {
			if(!isSwapped) {
				break;
			}
			isSwapped = false;
			for(int j=0; j<numbers.length-i-1; j++) {
				cnt++;
				if(numbers[j] > numbers[j+1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
					isSwapped = true;
				}
			}
		}
		System.out.println("오름차순 정렬 : " + Arrays.toString(numbers) + cnt);
	}

}
