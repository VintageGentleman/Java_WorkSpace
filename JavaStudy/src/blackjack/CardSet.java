package blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CardSet {
	List<String> card = new ArrayList<>();
	List<String> usedCard = new ArrayList<>();
	
	public CardSet() {
		for(int j = 0; j < 4; ++j) {
			String card = "";
			for(int i = 1; i < 14; ++i) {
				switch(j) {
				case 0:
					card += "♠";
					break;
				case 1:
					card += "♣";
					break;
				case 2:
					card += "♡";
					break;
				case 3:
					card += "◇";
					break;
				}
				
				switch(i) {
				case 1:
					card += "A";
					break;
				case 11:
					card += "J";
					break;
				case 12:
					card += "Q";
					break;
				case 13:
					card += "K";
					break;
				default:
					card += i;
					break;
				}
				this.card.add(card);
				card = "";
			}
		}
		setShuffle();
	}
	
	private void setShuffle() {
		Collections.shuffle(card);
	}
	
	public String drawCard() {
		usedCard.add(card.get(0));
		return card.remove(0);
	}
	
	public void cardReset() {
		card.addAll(usedCard);
		setShuffle();
		usedCard.clear();
	}
	@Override
	public String toString() {
		return Arrays.toString(card.toArray(new String[card.size()]));
	}
	
}
