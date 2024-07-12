import java.util.Arrays;

public class ArrayEx6 {

	public static void main(String[] args) {
		int[] numRange = new int[45];
		int[] lotto = new int[6];
		boolean isDup = false;
		for(int i=0; i<numRange.length; i++) {
			numRange[i] = i+1;
		}
		for(int j=0; j<lotto.length; j++) {
			do {
				int rN = (int) ((Math.random()*numRange.length));
				if(numRange[rN] > 0) {
					lotto[j] = numRange[rN];
					numRange[rN] = 0;
					isDup = false;
				}else {
					isDup = true;
				}
			}while(isDup);
		}
		for(int i=0; i<lotto.length-1; i++) {
			for(int j=i+1; j<lotto.length; j++) {
				if(lotto[i] > lotto[j]) {
					int data = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = data;
				}
			}
		}
		for (int i : lotto) {
			System.out.print(i + " ");
		}
	}

}
