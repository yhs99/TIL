package webyhs;

public class MobilePhoneMain {

	public static void main(String[] args) {
		MobilePhone2 phone = new MobilePhone2("애플","아이폰13",16,"그래파이트");
		MobilePhone2 samsung = new MobilePhone2("삼성","갤럭시25");
		System.out.println(phone.toString());
		System.out.println(samsung.toString());
		System.out.println(phone.getBrand());
		
		if(!phone.setMemory(1024)) {
			System.out.println("메모리 업그레이드 실패");
		}else {
			System.out.println("메모리 업그레이드 성공");
		}
		System.out.println(phone.toString());
	}

}
