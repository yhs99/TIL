package webhsy.card;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private String name;
	private List<Card> hand;
	private int total;
	
	public Player(String name) {
		hand = new ArrayList<>();
		this.name = name;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(Card hand) {
        this.hand.add(hand);
        this.hand.sort(new SortCard());
		this.total += hand.getRank();
	}

	public String getName() {
		return name;
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
