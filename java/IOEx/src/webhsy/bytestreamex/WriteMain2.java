package webhsy.bytestreamex;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteMain2 {

	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("C:\\workspace\\main\\java\\IOEx\\src\\webhsy\\bytestreamex\\b.txt");
			byte[] ar = {10,20,30,40,50};
			os.write(ar);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
