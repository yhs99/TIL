package webhsy.ex;


public class SortManager {
	public static Sortable getSortMethod(int num) {
		Sortable result = null;
		switch (num) {
		case 1:
			result = new StudentSortAscByStuNo(); 
			return result;
		case 2:
			result = new StudentSortAscByName();
			return result;
		case 3:
			result = new StudentSortDescByScore();
			return result;
		default:
			System.exit(0);
		}
		return result;
	}
}
