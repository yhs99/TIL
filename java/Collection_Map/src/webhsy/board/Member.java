package webhsy.board;

public class Member {
	private String memberId;
	private String memberName;
	
	public Member(String memberId, String memberName) {
		this.memberId = memberId;
		this.memberName = memberName;
	}
	
	@Override
	public String toString() {
		return "\n멤버 아이디 : " + memberId + ", 닉네임 : " + memberName + "\n";
	}
}
