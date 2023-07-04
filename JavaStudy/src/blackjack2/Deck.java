package blackjack2;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	private ArrayList<Card> cards = new ArrayList<>();
	private ArrayList<Card> drawed = new ArrayList<>();
	
	public Deck() {
		this(2);
	}
	
	// capacity : 카드를 몇 벌 사용할 것인지
	public Deck(int capacity) {
		for(int i = 0; i < capacity; ++i) {
			for(int suit = 0; suit < 4; ++suit) {
				for(int rank = 0; rank < 13; ++rank) {
					cards.add(new Card(suit, rank));
				}
			}
		}
		Collections.shuffle(cards);
	}
	
	// 카드 더미 맨위의 카드를 뽑는 기능
	public Card getCard() {
		// 카드 리스트에서 카드를 모두 뽑아서 더 뽑을 수 없는 경우
		if(cards.size() == 0) {
			cards = drawed;
			Collections.shuffle(cards);
			drawed = new ArrayList<>();
			System.out.println("[INFO] 카드를 모두 뽑아서 새로 섞었습니다");
		}
		
		Card drawed = cards.remove(0);
		this.drawed.add(drawed);
		
		return drawed;
	}
	
	public static void main(String[] args) {
		Deck d = new Deck();
		
		for(int i = 0; i < 500; ++i) {
			System.out.println("뽑음! " + d.getCard());
		}
	}
}
