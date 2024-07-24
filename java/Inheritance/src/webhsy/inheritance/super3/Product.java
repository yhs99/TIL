package webhsy.inheritance.super3;

public class Product {
	public String name;
	public int price;
	public static int totalPrice;
	
	Product() {};
	
	Product(String name, int price) {
		this.name = name;
		this.price = price;
		Product.totalPrice+=price;
	}
	
	public static void totalPrice() {
		System.out.println("총 가격 : " + totalPrice);
	}
	
	public void productInfo() {
		System.out.printf("상품 이름 : %s, 상품 가격 : %d ", name, price);
	}
}
