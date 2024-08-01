package webhsy.board;

import java.util.HashMap;
import java.util.Map;

public class MemberAction {
	private Map<Integer, Member> members;
	private int memberId;
	
	public MemberAction() {
		members = new HashMap<>();
	}
	
	public void addMember(Member member) {
		members.put(++memberId, member);
	}
	
	public void getMembers() {
		System.out.println("회원 목록 : " + members.values());
	}
	
	public void getMember(Integer memberId) {
		System.out.println("유저번호 : "+ memberId + ", " + members.get(memberId));
	}
	
	public void deleteMember(Integer memberId) {
		members.remove(memberId);
	}
}
