package webhsy.bytestreamex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class ReadMain2 {
	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("C:\\workspace\\main\\java\\IOEx\\src\\webhsy\\bytestreamex\\b.txt");
			byte[] data = new byte[10];
			while(true)	{
				int num = is.read(data);
				if(num == -1) break;
				for(byte i : data) {
					System.out.println(i + "");
				}
			}
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
