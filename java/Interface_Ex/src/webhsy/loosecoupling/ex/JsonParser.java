package webhsy.loosecoupling.ex;

public class JsonParser implements Parser{
	
	@Override
	public boolean parse() {
		System.out.println("json 파일 파싱을 시작합니다..");
		return true;
	}
}
