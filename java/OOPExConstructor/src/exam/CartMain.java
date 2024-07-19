package exam;

public class CartMain {

	public static void main(String[] args) {
		Cart cart = new Cart();
		Book book1 = new Book("자바", 20000, 2);
		Book book2 = new Book("JSP", 22000, 3);
		Book book3 = new Book("CSS", 32000, 3);
		Book book4 = new Book("HTML", 22000, 3);
		cart.addBook(book1);
		cart.addBook(book2);
		cart.addBook(book3);
		cart.addBook(book4);
		cart.addBook(book4);
		cart.addBook(book4);
		cart.addBook(book4);
		cart.addBook(book4);
		cart.addBook(book4);
		cart.addBook(book4);
		cart.addBook(book4);

		cart.displayBooks();
	}

}
