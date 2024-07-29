package webhsy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueEx {

	private static Queue<Integer> queue = new LinkedList<>();
	private static int curr = 0;
	public static void main(String[] args) {
		boolean loop = true;
		Scanner sc = new Scanner(System.in);
		int userInput = 0;
		while(loop) {
			System.out.println();
			System.out.println("1. 대기번호 발급");
			System.out.println("2. 대기번호 호출");
			System.out.println("9. 종료");
			System.out.print("번호 입력 ==> ");
			userInput = sc.nextInt();
			System.out.println();
			
			switch (userInput) {
			case 1:
				addQueue();
				break;
			case 2:
				callQueue();
				break;
			case 9:
				System.out.println("종료합니다");
				loop=false;
				break;
			}
		}
		sc.close();
	}
	private static void addQueue() {
		curr++;
		System.out.println("=================발급=================");
		System.out.println(curr + "번 번호표 발급");
		queue.add(curr);
		System.out.println(queue);
		System.out.println("====================================");
	}
	
	private static void callQueue() {
		if(queue.size() > 0) {
			System.out.println("=================호출=================");
			System.out.println(queue.poll() + "번 번호표 호출");
			if(queue.size()==0) curr = 0;
			System.out.println(queue);
			System.out.println("====================================");
		}else {
			System.out.println("번호표가 없습니다.");
		}
	}

}
