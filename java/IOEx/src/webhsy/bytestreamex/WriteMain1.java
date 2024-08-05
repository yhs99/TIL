package webhsy.bytestreamex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteMain1 {

	public static void main(String[] args) {
		byte a = 10;
		byte b = 20;
		byte c = 30;
		try (OutputStream out = new FileOutputStream("C:\\workspace\\main\\java\\IOEx\\src\\webhsy\\bytestreamex\\a.txt", true)) {
			out.write(a);
			out.write(b);
			out.write(c);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
