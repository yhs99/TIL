package exam;
public class ConnectServiceMain {

	public static void main(String[] args) {
		ConnectService cs1 = ConnectService.getInstance();
		ConnectService cs2 = ConnectService.getInstance();
		if(cs1 == cs2) {
			System.out.println("같은 ConnectService객체입니다.");
		}else {
			System.out.println("다른 ConnectService객체입니다.");
		}
	}

}
