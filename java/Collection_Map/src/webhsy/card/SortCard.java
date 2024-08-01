package webhsy.card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SortCard implements Comparator<Card>{

	public ArrayList<String> suits = new ArrayList<String>(Arrays.asList(Card.suits));
	
	@Override
	public int compare(Card o1, Card o2) {
		if(o1.getRank() > o2.getRank()) {
			return 1;
		}else if(o1.getRank() == o2.getRank()) {
			int i1 = suits.indexOf(o1.getSuit());
			int i2 = suits.indexOf(o2.getSuit());
			return Integer.compare(i1, i2);
		}else {
			return -1;
		}
	}

}
