package webhsy.bytestreamex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

public class StrStreamReadMain {

	public static void main(String[] args) {
		try (InputStream is = new FileInputStream("C:\\workspace\\main\\java\\IOEx\\src\\webhsy\\bytestreamex\\c.txt");
			Reader reader = new InputStreamReader(is);){
			int data;
            while((data = reader.read())!= -1) {
                System.out.println((char) data);
            }
            Reader fr = new FileReader("C:\\workspace\\main\\java\\IOEx\\src\\webhsy\\bytestreamex\\c.txt");
            char[] d = new char[50];
            while(true) {
            	int len = fr.read(d);
                if(len == -1) break;
                System.out.println(Arrays.toString(d));
            }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
