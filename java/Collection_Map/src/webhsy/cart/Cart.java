package webhsy.cart;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Cart {
	// product 이름과 가격이 같으면 하나의 상품
	private Map<Product, Integer> cartList;
	private int quantity;
	
	public Cart() {	
		cartList = new HashMap<Product, Integer>();
	}
	
	public void addCart(Product product, int quantity) {
		if(this.cartList.containsKey(product)) {
			this.cartList.put(product, this.cartList.get(product)+quantity);
		}else {
			this.cartList.put(product, quantity);
		}
	}
	
	public void displayCart() {
		for(Map.Entry<Product, Integer> entry : cartList.entrySet()) {
			Product product = entry.getKey();
			int quantity = entry.getValue();
			System.out.printf("상품명 : %s, 가격 : %d, 수량 : %d\n",product.getProductName(), product.getPrice(), quantity);
		}
	}
	
	public void removeCart() {
		//방법1
//		Iterator<Entry<Product, Integer>> iter = cartList.entrySet().iterator();
//		while(iter.hasNext()) {
//			Entry<Product, Integer> entry = iter.next();
//			Product product = entry.getKey();
//			int quantity = entry.getValue();
//			quantity--;
//			if(quantity <= 0) {
//				iter.remove();
//			}else {
//				cartList.put(product, quantity);
//			}
//		}
		//방법2
		for(Map.Entry<Product, Integer> entry : cartList.entrySet()) {
			Product product = entry.getKey();
			int quantity = entry.getValue();
			quantity--;
			if(quantity <= 0) {
				cartList.remove(product);
			}else {
				cartList.put(product, quantity);
			}
		}
		
		displayCart();
	}
}
