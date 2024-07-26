package webhsy;

public class NotPositiveInteger extends Exception {
	private int errorCode = 103;
	private String message;
	
	public NotPositiveInteger(String message) {
		super(message);
	}
	
	@Override
	public String getMessage() {
		return "code : " + this.errorCode + ", message : " + super.getMessage();
	}
}
