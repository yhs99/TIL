package exam;

public class MemberService {
	static Member member = new Member("dooly", "1234", "둘리", 12);
	
	protected static boolean login(String id, String pwd) {
		boolean status = false;
		
		if(member.getMemberId().equals(id) && member.getMemberPwd().equals(pwd)) {
			status = true;
		}
		
		return status;
		
	}

}
