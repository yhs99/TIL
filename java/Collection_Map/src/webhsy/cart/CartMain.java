package webhsy.cart;

public class CartMain {
	public static void main(String[] args) {
		Cart cart = new Cart();
		cart.addCart(new Product("자바", 20000), 1);
		cart.addCart(new Product("오라클", 22000), 1);
		cart.addCart(new Product("자바", 20000), 1);
		cart.addCart(new Product("자바", 22000), 1);
		cart.addCart(new Product("자바", 22000), 1);
		cart.addCart(new Product("자바", 22000), 1);
		cart.addCart(new Product("자바", 22000), 1);
		cart.addCart(new Product("자바", 22000), 1);
		cart.displayCart();
		System.out.println("상품 제거후 ----------------");
		cart.removeCart();
	}
}
