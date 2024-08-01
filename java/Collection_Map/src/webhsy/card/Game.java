package webhsy.card;

public class Game {

	public static void main(String[] args) {
		Dealer dealer = new Dealer();
		dealer.shuffle();
		dealer.addPlayer(new Player("임요한"));
		dealer.addPlayer(new Player("나"));
		dealer.giveCardToPlayers();
		dealer.getCardFromPlayers();
		dealer.gameResult();
	}

}
