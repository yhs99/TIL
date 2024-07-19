package card;

public class Dealer {
	private static Card[] cards;
	
	private Dealer() {}
	
	public static void openCard() {
		if(!(cards == null)) {
			System.out.println("이미 카드를 개봉했습니다.");
			return;
		}
		String[] numbers = {"1" , "2", "3", "4", "5", "6", "7", "8", "9", "J", "Q", "K"};
		String[] types = {"스페이드", "다이아", "클로버", "하트"};
		cards = new Card[numbers.length * types.length];
		int cardNum = 0;
		for(String type : types) {
			for(String number : numbers) {
				cards[cardNum++] = new Card(type, number);
			}
		}
		System.out.println("<< 카드 개봉 >>");
		for(Card card : cards) {
			System.out.println(card.getCard());
		}
		System.out.println("<<<<<<<<<<<>>>>>>>>>");
	}
	
	public static void shuffle() {
		if(cards==null) {
			System.out.println("카드를 먼저 개봉하세요");
			return;
		}
		for(int i=0; i<cards.length; i++) {
			int rand1 = (int) (Math.random()*cards.length);
			int rand2 = (int) (Math.random()*cards.length);
			Card temp = cards[rand1];
			cards[rand1] = cards[rand2];
			cards[rand2] = temp;
		}
	}
	
	public static void pickCard() {
		if(cards==null) {
			System.out.println("카드를 먼저 개봉하세요");
			return;
		}
		for(Card card : cards) {
			System.out.printf("%s  ::  카드가 지급되었습니다. \n", card.getCard());
		}
	}
}
