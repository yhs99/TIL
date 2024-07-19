package card;


public class Card {
	private String cardNumber;
	private String cardType;
	
	public Card(String cardType, String cardNumber) {
		this.cardType = cardType;
		this.cardNumber = cardNumber;
	}
	
	public String getCard() {
		String str = cardType + " " + cardNumber;
		return str;
	}
}
