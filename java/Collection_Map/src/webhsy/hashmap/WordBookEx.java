package webhsy.hashmap;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WordBookEx {
	
	public static WordBookImpl wordAction = new WordBookImpl();
	
	public static void main(String[] args) {
		while(true) {
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("1. 영단어 추가하기");
				System.out.println("2. 영단어 검색하기");
				System.out.println("3. 영단어 뜻으로 검색하기");
				System.out.println("4. 영단어 삭제하기");
				System.out.println("5. 영단어 목록보기");
				System.out.println("9. 종료");
				System.out.printf("선택 ==> ");
				action(sc.nextInt());
			}catch(InputMismatchException e) {
				System.out.println("정확한 메뉴를 선택하세요");
			}
		}
	}
	
	public static void action(int num) {
		Scanner str = new Scanner(System.in);
		switch (num) {
		case 1:
			System.out.printf("단어를 입력하세요 ==> ");
			String word = str.nextLine();
			System.out.printf("뜻을 입력하세요 ==> ");
			String mean = str.nextLine();
			if(wordAction.addWord(word, mean)) {
				System.out.println("단어 추가 성공!");
			}else {
				System.out.println("단어 추가 실패");
			}
			break;
		case 2:
			System.out.println("뜻을 검색할 단어를 입력하세요");
			wordAction.searchByWord(str.nextLine());
			break;
		case 3:
			System.out.println("찾을 단어의 뜻을 입력하세요");
			wordAction.searchByMean(str.nextLine());
			break;
		case 4:
			System.out.println("삭제할 단어를 입력하세요.");
			wordAction.removeByWord(str.nextLine());
			break;
		case 5:
			wordAction.getWordList();
			break;
		case 9:
			System.exit(0);
		default:
			throw new InputMismatchException();
		}
	}
}
