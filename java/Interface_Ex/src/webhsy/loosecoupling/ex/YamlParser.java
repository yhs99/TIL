package webhsy.loosecoupling.ex;

public class YamlParser implements Parser{

	@Override
	public boolean parse() {
		System.out.println("YAML 파일 파싱을 시작합니다.");
		return true;
	}

}
