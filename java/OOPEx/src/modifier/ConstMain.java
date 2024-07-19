package modifier;

public class ConstMain {

	public static void main(String[] args) {
		int curReserveUsers = 999;
		reservation(curReserveUsers++);
		reservation(curReserveUsers++);
		reservation(curReserveUsers++);
	}
	
	private static void reservation(int resUsers) {
		System.out.println("예약자 수 : " + resUsers);
		if(resUsers > FieldInit.RESERVE_MAX) {
			System.out.println("대기중");
		}else {
			System.out.println("예약가능");
		}
	}

}
