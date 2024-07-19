package exam;

public class Cart {
	private Book[] books = new Book[10];
	private int bookCnt = 0;
	
	protected void addBook(Book book) {
		if(bookCnt >= 10) {
			System.out.println("카트에는 10개까지만 담을 수 있습니다.");
			return;
		}
		books[bookCnt] = book;
		bookCnt++;
		System.out.printf("카트에 추가되었습니다. 총 : %d건 \n", bookCnt);
	}
	
	protected void displayBooks() {
		int totalPrice = 0;
		for(int i=0; i<bookCnt; i++) {
			totalPrice += books[i].getTotalPrice();
			System.out.printf("책 이름 : %s, 금액 : %d, 갯수 : %d \n", books[i].getTitle(), books[i].getPrice(), books[i].getQunatity());
		}
		System.out.printf("총 금액 : %d",totalPrice);
	}
}
