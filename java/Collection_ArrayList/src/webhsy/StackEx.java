package webhsy;

import java.util.List;
import java.util.Stack;

public class StackEx {
	static List<String> stack = new Stack<>();
	static int currPage = 0;
	
	public static void main(String[] args) {
		stack.add("네이버");
		stack.add("다음");
		stack.add("쿠팡");
		stack.add("자바API");
		nextPage();
		nextPage();
		nextPage();
		nextPage();
		prevPage();
		prevPage();
		prevPage();
		prevPage();
		nextPage();
		nextPage();
		nextPage();
		nextPage();
	}
	
	private static void nextPage() {
		if(currPage < stack.size()-1) {
			currPage++;
			System.out.println(stack.get(currPage));
		}else {
			System.out.println("마지막 페이지");
		}
	}
	
	private static void prevPage() {
		if(currPage > 0) {
			currPage--;
			System.out.println(stack.get(currPage));
		}else {
			System.out.println("마지막 페이지");
		}
	}
}
