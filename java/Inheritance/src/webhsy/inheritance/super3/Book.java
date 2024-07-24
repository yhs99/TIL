package webhsy.inheritance.super3;

public class Book extends Product{
	public String author;
	public String isbn;
	
	Book(String name, int price, String author, String isbn) {
		super(name, price);
		this.author = author;
		this.isbn = isbn;
	}
	
	@Override
	public void productInfo() {
		super.productInfo();
		System.out.printf("저자 : %s, 고유번호 : %s \n", author, isbn);
		
	}
}
