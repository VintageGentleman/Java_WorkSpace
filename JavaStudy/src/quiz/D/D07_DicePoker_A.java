package quiz.D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class D07_DicePoker_A {
	
	/*
	  	# 주사위 포커를 만들어 주세요
	  	
	  	1. 주사위를 다섯개 던진다
	  	
	  	2. 각 주사위의 눈을 가지고 어떤 패가 만들어졌는지 알려줘야 한다
	  	
	  	3. 다섯 개의 주사위 눈을 통해 다음을 구분한다
	  	
	  	 (1) 풀 하우스 (같은 눈이 2개 / 3개)
	  	 ex> 11222, 21122, 55566, 53535 ...
	  	 
	  	 (2) 스몰 스트레이트 (1234/2345/3456)
	  	 ex> 31246, 24352 ... 
	  	 
	  	 (3) 라지 스트레이트 (12345/23456)
	  	 
	  	 (4) Three of kind (같은 눈 3개)
	  	 ex> 33312, 61626
	  	 
	  	 (5) Four of kind (같은 눈 4개)
	  	 ex> 33331, 65666
	  	 
	  	 (6) Yacht (같은 눈 5개)
	  	 ex 66666, 11111
	  	 
	  	 (7) 이외의 것은 아무일도 없었던 것으로 처리
	*/
	
	public static boolean checkStraight(HashMap<String, Integer> diceMap) {
		List<Integer> dices = new ArrayList<>();
		
		for(Integer x : diceMap.values()) {
			dices.add(x);
		}
		
		Collections.sort(dices);
		
		HashSet<Integer> temp = new HashSet<>(dices);
		
		String text = "";
		
		for(Integer x : temp) {
			text += x;
		}
		
		if(text.contains("23456") ||  text.contains("12345")) {
			System.out.println("라지 스트레이트");
			return true;
		} else if(text.contains("1234") || text.contains("2345") || text.contains("3456")) {
			System.out.println("스몰 스트레이트");
			return true;
		} 
		
		return false;
	}
	
	public static void main(String[] args) {
		
		HashMap<String, Integer> diceMap = new HashMap<>();
		
		for(int i = 1; i <= 5; ++i) {
			diceMap.put("Dice" + i, (int)(Math.random() * 6 + 1));
		}
		 
		System.out.println(diceMap);
		
		HashMap<Integer, Integer> diceNums = new HashMap<>();
		
		for(int i = 1; i <= 6; ++i) {
			diceNums.put(i, 0);
		}
		
		for(int i = 1; i <= diceMap.size(); ++i) {
			int diceValue = diceMap.get("Dice" + i);
			diceNums.put(diceValue, diceNums.get(diceValue) + 1);
		}
		
		System.out.println(diceNums);
		
		boolean made = false;
		
		if(diceNums.containsValue(3)) {
			if(diceNums.containsValue(2)) {
				System.out.println("풀하우스");
				made = true;
			} else {
				System.out.println("Three of kind");
				made = true;
			}
		} else if(diceNums.containsValue(4)) {
			System.out.println("Four of kind");
			made = true;
		} else if(diceNums.containsValue(5)) {
			System.out.println("Yacht");
			made = true;
		} else {
			made = checkStraight(diceMap);
		}
		
		if(!made) {
			System.out.println("No Made");
		}
		
	}
	
}
