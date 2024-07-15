import java.util.Arrays;

public class MethodParams2 {

	public static void main(String[] args) {
		Data dataA = new Data();
		System.out.println(dataA.value);
		dataA.value = 10;
		System.out.println(dataA.value);
		callReferenceParam(dataA);
		System.out.println(dataA.value);
		
		int[] arr = {10};
		System.out.println(Arrays.toString(arr));
		changeParam(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	static void callReferenceParam(Data dataB) {
		dataB.value = 20;
	}
	
	static void changeParam(int[] x) {
		x[0] = 100;
	}

}
