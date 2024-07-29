package webhsy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackMain {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("최범준");
		stack.push("장준호");
		stack.push("곽다훈");
		stack.push("윤희성");
		System.out.println(stack.pop()); // pop : 제일 위 요소를 삭제하고 요소를 반환함
		System.out.println(stack.peek()); // peek : 제일 위 요소를 반환하고 삭제하지는 않음.
		
		System.out.println(stack);
		
		Queue<String> queue = new LinkedList<String>();
		queue.offer("1");
		queue.offer("2");
		queue.offer("3");
		queue.offer("4");
		System.out.println(queue.size());
		System.out.println(queue.poll());
	}

}
