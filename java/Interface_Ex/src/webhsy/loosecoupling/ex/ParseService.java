package webhsy.loosecoupling.ex;


public class ParseService {
	public void processParse(String fileName) {
		Parser parser = null;
		boolean result = false;
		
		String ext = fileName.substring(fileName.lastIndexOf(".")+1);
		System.out.println("파일의 확장자 : " + ext);
		
		if(ext.equals("json")) {
			parser = new JsonParser();
		}else if(ext.equals("xml")) {
			parser = new XmlParser();
		}else if(ext.equals("yaml")) {
			parser = new YamlParser();
		}else {
			System.out.println("파서기가 없습니다.");
		}
		
		if(parser != null) {
			result = parser.parse();
		}
		
		if(result) {
			System.out.println("파싱 완료");
		}else {
			System.out.println("파싱 실패");
		}
	}
}
