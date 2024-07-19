package webyhs;

public class Book {
	private String title;
	private String author;
	private int price;
	
	public Book() {};
	public Book(String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	public Book(String title, String author) {
		this(title, author, 0);
	}
	
	public void displayBook() {
		System.out.printf("제목 : %s, 저자 : %s, 가격 : %d \n", this.title, this.author, this.price);
	}
}
