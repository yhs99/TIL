import java.util.Scanner;

public class Prob3 {

	static Scanner sc = new Scanner(System.in);
	static String bookName = "";
	static int price = 0;
	static int qt = 0;
	
	public static void main(String[] args) {
		
		// 메뉴 선택
		// 1. 도서정보입력 2. 총비용 3. 종료
		// 1선택 => 도서명, 가격, 수량 정보를 출력
		// 2선택 => 총비용
		// 3 선택 => 종료
		try {
			market();
		}catch (Exception e) {
			if(e.getMessage().equals("Scanner closed")) {
				System.out.println("종료합니다.");
			};
		}
	}
	static void market() throws Exception {
		while(true) {
			System.out.println("1. 도서정보입력 | 2. 총비용 | 3. 종료");
			System.out.print("메뉴를 입력하세요 => ");
			int choose = sc.nextInt();
			sc.nextLine();
			switch(choose) {
				case 1:
					System.out.print("도서명을 입력하세요 => ");
					bookName = sc.nextLine();
					System.out.print("가격을 입력하세요 => ");
					price = sc.nextInt();
					sc.nextLine();
					System.out.print("수량을 입력하세요 => ");
					qt = sc.nextInt();
					break;
				case 2:
					System.out.printf("도서명 : %s, 가격 : %d, 수량 %d, 총 비용 : %d \n", bookName, price, qt, price*qt);
					break;
				case 3:
					sc.close();
					throw new Exception("Scanner closed");
				default :
					System.out.println("올바르게 선택해주세요.");
			}
		}
	}

}
