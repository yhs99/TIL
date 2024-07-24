package webhsy.inheritance.super3;

public class ProductMain {
	
	public static void main(String[] args) {
		Movie movie1 = new Movie("아바타", 20000, "카메른", "전체 이용가");
		Movie movie2 = new Movie("어벤져스", 22000, "조스 휘던", "전체 이용가");
		movie1.productInfo();
		movie2.productInfo();
		Book book1 = new Book("잭과콩", 9800, "누군가", "1234567890");
		Book book2 = new Book("잭과콩", 19800, "아무개", "1234567890");
		Book book3 = new Book("잭과콩", 4800, "홍길동", "1234567890");
		book1.productInfo();
		book2.productInfo();
		book3.productInfo();
		Album album1 = new Album("앨범1", 10000, "bts");
		Album album2 = new Album("앨범1", 10000, "bts");
		Album album3 = new Album("앨범1", 10000, "bts");
		album1.productInfo();
		album2.productInfo();
		album3.productInfo();
		Product.totalPrice();
	}

}
