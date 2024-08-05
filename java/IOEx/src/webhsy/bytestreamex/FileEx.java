package webhsy.bytestreamex;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileEx {
	public static void main(String[] args) {
		File currentDirectory = new File(".");
		System.out.println("Current Directory : " + currentDirectory.getAbsolutePath());
		File[] files = currentDirectory.listFiles();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		long cntDir = 0l;
		long using = 0l;
		for (File file : files) {
			if(file.isDirectory()) {
				cntDir++;
			}else {
				using += file.length();
			}
			Date lastModified = new Date(file.lastModified());
			System.out.printf("%s\t %s\t %s \t %s \n", dateFormat.format(lastModified), file.isDirectory() ? "<DIR>" : "", file.length()>0 ? String.format("%,d", file.length()) : "", file.getName());
        }
		System.out.printf("%d개의 파일\t %s 바이트\n%d개 디렉터리 \t%s 바이트 남음", files.length-cntDir, String.format("%,d", using), cntDir, String.format("%,d", currentDirectory.getUsableSpace()));
	}
}
