package webhsy.bytestreamex;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class StrStreamWriteMain {

	public static void main(String[] args) {
		try (OutputStream os = new FileOutputStream("C:\\workspace\\main\\java\\IOEx\\src\\webhsy\\bytestreamex\\c.txt");){
			Writer writer = new OutputStreamWriter(os);
			char a = 'A';
			writer.write(a);
			char b = 'B';
			writer.write(b);
			char c = 'C';
			writer.write(c);
			char[] arr = {'D', 'E', 'F'};
			writer.write(arr);
			writer.write("GHI");
			
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
