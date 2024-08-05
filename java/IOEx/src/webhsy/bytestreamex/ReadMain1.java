package webhsy.bytestreamex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadMain1 {

	public static void main(String[] args) {
		try (InputStream is = new FileInputStream("C:\\workspace\\main\\java\\IOEx\\src\\webhsy\\bytestreamex\\b.txt");){
			while(true) {
				int a = is.read();
				if(a == -1) break;
				System.out.println(a);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
