package myobj2;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Dices {

	List<Integer> dices = new ArrayList<>();
	
	public Dices() {
		this(
			(int)(Math.random() * 6 + 1),
			(int)(Math.random() * 6 + 1),
			(int)(Math.random() * 6 + 1),
			(int)(Math.random() * 6 + 1),
			(int)(Math.random() * 6 + 1)
		);
	}

	public Dices(int d1, int d2, int d3, int d4, int d5) {
		dices.add(d1);
		dices.add(d2);
		dices.add(d3);
		dices.add(d4);
		dices.add(d5);
	}
	
	public void change(int i, int num) {
		dices.set(i, num);
	}

	public String check() {
		HashMap<Integer, Integer> diceCount = new HashMap<>();

		// 주사위 눈 세기
		for(int num : dices) {
			Integer count = diceCount.putIfAbsent(num, 0);
			diceCount.put(num, count == null ? 1 : count + 1);
		}
		
		System.out.println(dices);
		System.out.println(diceCount);
		
		if(diceCount.containsValue(5)) {
			return "Yacht";
		} else if(diceCount.containsValue(4)) {
			return "Four of Kind";
		} else if(diceCount.containsValue(3) &&
				diceCount.containsValue(2)) {
			return "Full house";
		} else if(diceCount.containsValue(3)) {
			return "Three of Kind";
		}
		
		// LS : 12345, 23456 
		for(int i = 1; i <= 2; ++i) {
			if(diceCount.containsKey(i)
					&& diceCount.containsKey(i + 1)
					&& diceCount.containsKey(i + 2)
					&& diceCount.containsKey(i + 3)
					&& diceCount.containsKey(i + 4)) {
				return "Large straight";
			}			
		}
		
		// SS : 1234, 2345, 3456
		// LS와 같은 방식을 다르게 표현. LS가 좀 더 직관적.
		for(int i = 1; i <= 3; ++i) {
			boolean ss = true;
			for(int j = 0; ss && j < 4; ++j) {
				ss &= diceCount.containsKey(i + j);
			}
			
			if(ss) {
				return "Small straight";
			}
			
		}
		
		return "Nothing";
	}
}
