package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Player_Computer extends Player {

	public Player_Computer() {
		super();
	}
	
	@Override
	public void showCard() {
		List<String> temp = new ArrayList<>();
		temp.addAll(handCard);
		temp.set(0, "[XX]");
	
		System.out.print("컴퓨터의 카드 > ");
		System.out.println(temp);
	}
	
	public void openCard() {
		System.out.print("컴퓨터의 카드 > ");
		System.out.println(handCard); 
	}
	
}
