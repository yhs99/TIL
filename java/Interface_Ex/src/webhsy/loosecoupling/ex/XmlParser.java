package webhsy.loosecoupling.ex;

public class XmlParser implements Parser{
	
	@Override
	public boolean parse() {
		System.out.println("XML 파일 파싱을 시작합니다.");
		return true;
	}
}
