package webhsy.card;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
	private List<Card> deck;
	private Player[] players = new Player[2];
	
	public Dealer() {
		deck = new ArrayList<Card>();
		for(int i=0; i<Card.suits.length; i++) {
			for(int j=1; j<=13; j++) {
				deck.add(new Card(Card.suits[i], j));
			}
		}
	}
	
	public void addPlayer(Player player) {
		for(int i=0; i<players.length; i++) {	
			if(players[i] == null) {
                players[i] = player;
                break;
			}
		}
	}
	
	public void shuffle() {
		int size = deck.size();
		for(int i = 0; i < size; i++) {
			int randomIndex = (int)(Math.random() * size);
			Card temp = deck.get(i);
			deck.set(i, deck.get(randomIndex));
			deck.set(randomIndex, temp);
		}
	}
	
	public void giveCardToPlayers() {
		for(Player player : players) {
			for(int i=0; i<5; i++) {
				player.setHand(deck.get(i));
				deck.remove(i);
			}
		}
	}
	
	public void getCardFromPlayers() {
		for(Player player : players) {
            List<Card> hand = player.getHand();
            System.out.printf("%s", player.getName());
            for(Card card : hand) {
            	System.out.printf("[%s, %d]", card.getSuit(), card.getRank());
            }
            System.out.println("합계 : " + player.getTotal());
        }
	}
	
	public void gameResult() {
		if(players[0].getTotal() > players[1].getTotal()) {
			System.out.printf("%s 우승", players[0].getName());
		}else if(players[0].getTotal() < players[1].getTotal()) {
			System.out.printf("%s 우승", players[1].getName());
		}else {
			System.out.println("무승부");
		}
	}
}
