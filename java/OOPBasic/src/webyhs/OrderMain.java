package webyhs;

import java.util.ArrayList;

public class OrderMain {
	public static void main(String[] args) {
		ArrayList<Order> orderList = new ArrayList<Order>();
		int total = 0;
		Order order = new Order();
		Order order1 = new Order();
		Order order2 = new Order();
		order.prodName = "오라클";
		order1.prodName = "자바";
		order2.prodName = "스프링";
		order.price = 20000;
		order1.price = 10000;
		order2.price = 25000;
		order.quantity = 2;
		order1.quantity = 3;
		order2.quantity = 4;
		orderList.add(order);
		orderList.add(order1);
		orderList.add(order2);
		for(Order list : orderList) {
			total += list.price;
			System.out.printf("상품명 : %s, 가격 : %d, 수량: %d \n", list.prodName, list.price, list.quantity);
		}
		System.out.printf("총 결제 금액 : %d원", total);
	}
}
