package webhsy;

import java.util.Arrays;

public class MathArrUtils {
	public static void sum(int[] arr) {
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum+=arr[i];
		}
		System.out.println(sum);
	}
	
	public static void average(int[] arr) {
		int sum = 0;
		double average;
		for(int i=0; i<arr.length; i++) {
			sum+=arr[i];
		}
		average = (double) sum/arr.length;
		System.out.println(average);
	}

	public static void min(int[] arr) {
		int min = Integer.MAX_VALUE;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] < min) {
				min = arr[i];
			}
		}
		System.out.println(min);
	}
	
	public static void max(int[] arr) {
		int max = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println(max);
	}
	
	public static void sort(int[] arr) {
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length-i-1; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
