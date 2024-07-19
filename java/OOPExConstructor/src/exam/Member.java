package exam;

public class Member {
	private String memberId;
	private String memberPwd;
	private String memberName;
	private int memberAge;

	protected Member(String memberId, String memberPwd, String memberName, int memberAge) {
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.memberAge = memberAge;
	}
	
	
	public String getMemberId() {
		return memberId;
	}
	
	public int getMemberAge() {
		return memberAge;
	}
	
	public String getMemberName() {
		return memberName;
	}
	
	public String getMemberPwd() {
		return memberPwd;
	}
}
