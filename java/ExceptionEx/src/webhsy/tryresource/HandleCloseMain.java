package webhsy.tryresource;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class HandleCloseMain {

	public static void main(String[] args) {
//		try {
//			FileInputStream fs = new FileInputStream("C:\\workspace\\main\\java\\ExceptionEx\\src\\webhsy\\tryresource\\score.dat");
//			DataInputStream ds = new DataInputStream(fs);
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
		try(FileInputStream fis = new FileInputStream("경로");
		    DataInputStream dis = new DataInputStream(fis);) {

			    }catch (IOException e) {
			      System.out.println("파일이 없습니다.");
			    }
	}

}
