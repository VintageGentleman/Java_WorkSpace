package blackjack2;

import java.util.ArrayList;

public class Player {
	ArrayList<Card> hand = new ArrayList<>();
	int money;
	
	public void plusMoney(int money) {
		this.money += money;
	}
	
	public void minusMoney(int money) {
		this.money -= money;
	}
	
	public int getMoney() {
		return money;
	}
	
	/** 플레이어에게 카드를 추가한다 */
	public void addCard(Card card) {
		hand.add(card);
	}
	
	public void reset() {
		while(hand.size() != 0) {
			hand.remove(0);
		}
	}
	
	/** 들고 있는 카드 중 해당 번째 카드를 뒤집은 상태로 변경한다 */
	public void reverse(int index) {
		if(hand.size() <= index || index < 0) {
			System.out.println("없는 카드 입니다.");
			return;
		}
		hand.get(index).reverse();
	}
	
	/** 전체 카드 목록과 점수를 콘솔에 찍어준다 */
	public void printCards() {
		for(Card card : hand) {
			System.out.print(card + " ");
		}
		System.out.printf("(%d)\n", getValue());
	}
	
	/** 점수를 제외하고 전체 카드 목록만 콘솔에 찍어준다 */
	public void printCardsWithNoValue() {
		for(Card card : hand) {
			System.out.print(card + " ");
		}
		System.out.println();
	}
	
	/** 플레이어가 현재 가진 카드들로 점수를 계산하여 리턴*/
	public int getValue() {
		int value = 0;
		int a_count = 0;
		
		for(Card card : hand) {
			value += card.getRankValue();
			
			// A의 개수를 센다
			if(card.getRank() == 0) {
				++a_count;
			}
		}
		
		// 21점이 넘으면서 동시에 A를 가지고 있다면
		while(value > 21 && a_count-- > 0) {
			value -= 10; // 11점 짜리를 1점으로 변경
		}
		
		return value;
	}

}
