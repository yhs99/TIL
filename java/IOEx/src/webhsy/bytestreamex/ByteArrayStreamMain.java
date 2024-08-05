package webhsy.bytestreamex;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class ByteArrayStreamMain {
	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = {};
		
		ByteArrayInputStream in = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream outs = null;
		outs = new ByteArrayOutputStream();
		int data = 0;
		while((data = in.read()) != -1) {
			System.out.println(data);
			outs.write(data);
		}
		outSrc = outs.toByteArray();
		System.out.println(Arrays.toString(outSrc));
	}
}
