
public class StaticVSInstance {

	public static void main(String[] args) {
		System.out.printf("카드의 가로 = %d, 세로 = %d \n", Card.width, Card.height);
		Card card = new Card();
		card.kind = "Heart";
		card.number = 7;
		System.out.printf("카드 : %s, 번호 : %d \n", card.kind, card.number);
		
		Card card2 = new Card();
		card2.kind = "Diamond";
		card2.number = 4;
		System.out.printf("카드 : %s, 번호 : %d \n", card2.kind, card2.number);
		card.width = 70;     // 다른 생성자로 접근을해도 모두 적용된다.
		card2.height = 100;
		System.out.printf("카드1 : %s, 가로 : %d 세로 : %d\n", card.kind, card.width, card.height);
		System.out.printf("카드2 : %s, 가로 : %d 세로 : %d\n", card2.kind, card2.width, card2.height);
		
	}

}
