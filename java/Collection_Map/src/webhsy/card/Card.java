package webhsy.card;

public class Card {
	public static final String[] suits = {"스페이드", "하트", "다이아몬드", "클로버"};
	private String suit;
	private int rank;
	
	public Card(String suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public String getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}
	
	
}
