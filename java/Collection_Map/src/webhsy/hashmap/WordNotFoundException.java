package webhsy.hashmap;

public class WordNotFoundException extends RuntimeException{
	public WordNotFoundException() {
		super("해당 단어를 찾을 수 없습니다.");
	}
	public WordNotFoundException(String msg) {
		super(msg);
	}
}
