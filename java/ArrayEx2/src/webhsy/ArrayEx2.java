package webhsy;
import java.util.Arrays;

public class ArrayEx2 {

	public static void main(String[] args) {
		int[] arr5 = {3,5,1,4,2};
		Arrays.sort(arr5);
		System.out.println(Arrays.toString(arr5));
		
		int intA = 12;
		
		// Boxing
		Integer integerA = new Integer(intA);
		Integer integerB = new Integer(intA);
		System.out.println(integerA == integerB);
		
		// Unboxing
		int intB = integerA.intValue();
		System.out.println(intB);
	}

}
