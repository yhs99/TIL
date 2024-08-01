package webhsy.board;

public class MemberMain {

	public static void main(String[] args) {
		MemberAction ma = new MemberAction();
		ma.addMember(new Member("hsyoon", "heesung"));
		ma.addMember(new Member("hsyoon1", "heesung1"));
		ma.addMember(new Member("hsyoon2", "heesung2"));
		ma.getMembers();
		ma.getMember(1);
	}

}
