package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player {
	int handMoney;
	List<String> handCard = new ArrayList<>();
	boolean checkStand = false;
	boolean checkDefeated = false;
	int cardSum;
	
	public Player() {
		this.handMoney = 2500;
	}
	
	public void declareHit(String card) {
		handCard.add(card);
		calNum();
		if(cardSum > 21) {
			checkDefeated = true;
		}
	}

	public void backToStart() {
		handCard.clear();
		checkStand = false;
		checkDefeated = false;
	}
	
	public void betMoney(int chipPrice) {
		handMoney -= chipPrice;
	}
	
	public void earnPrize(int prize) {
		handMoney += prize;
	}

	public void declareStand() {
		checkStand = true;
	}
	
	protected void calNum() {
		String[] cardNumber = new String[handCard.size()];
		for(int j = 0; j < handCard.size(); ++j) {
			String temp = ""; 
			for(int i = 1; i < handCard.get(j).length(); ++i) {
				temp += handCard.get(j).charAt(i);
			}
			cardNumber[j] = temp;
		}
		
		int total = 0;
		boolean checkAce = false;
		for(int i = 0; i < cardNumber.length; ++i) {
		    if(cardNumber[i].equals("A")) {
				total += 11;
				checkAce = true;
			} else if(cardNumber[i].equals("K")
					|| cardNumber[i].equals("Q")
					|| cardNumber[i].equals("J")){
				total += 10;
			} else {
				total += Integer.parseInt(cardNumber[i]);
			}
		}
		
		while(checkAce && total > 21) {
			total = changeAce(cardNumber);
			for(int i = 0; i < cardNumber.length; ++i) {
				if(cardNumber[i].equals("A")) {
					break;
				} else {
					checkAce = false;
				}
			}
		}
		
		cardSum = total;
	}
	
	/** 처음 마주치는 A를 String 1로 바꾸고 합계를 반환합니다. */
	private int changeAce(String[] cardNumber) {
		int total = 0;
		for(int i = 0; i < cardNumber.length; ++i) {
			boolean alreadyChange = false;
			if(!alreadyChange && cardNumber[i].equals("A")) {
				cardNumber[i--] = "1";
				alreadyChange = true;
			} else if(cardNumber[i].equals("A")) {
				total += 11;
			} else if(cardNumber[i].equals("K")
					|| cardNumber[i].equals("Q")
					|| cardNumber[i].equals("J")){
				total += 10;
			} else {
				total += Integer.parseInt(cardNumber[i]);
			}
		}
		return total;
	}
	
	public void showCard() {
		System.out.print("당신의 카드 > ");
		System.out.println(handCard); 
	}
	
	// get메서드는 이 아래
	
	public int getHandMoney() {
		return handMoney;
	}
	
	public int getCardSum() {
		return cardSum;
	}

	public boolean isCheckStand() {
		return checkStand;
	}
	
	public boolean isCheckDefeated() {
		return checkDefeated;
	}
}
