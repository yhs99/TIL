package exam;

public class Book {
	private String title;
	private int price;
	private int quantity;
	
	protected Book(String title, int price, int quantity) {
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}
	
	protected int getQunatity() {
		return quantity;
	}
	
	protected String getTitle() {
		return title;
	}
	
	protected int getPrice() {
		return price;
	}
	
	protected int getTotalPrice() {
		return price * quantity;
	}
}
