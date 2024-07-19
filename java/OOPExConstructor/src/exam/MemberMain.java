package exam;
public class MemberMain {

	public static void main(String[] args) {
		if(MemberService.login("dooly", "12345")) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
	}

}
