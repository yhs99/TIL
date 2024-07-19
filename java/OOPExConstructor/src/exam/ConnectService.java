package exam;

public class ConnectService {
	// 싱글톤 (Singleton) 패턴
	private static ConnectService cn = new ConnectService();
	
	private ConnectService() {};
	
	public static ConnectService getInstance() {
		return cn;
	}
}
