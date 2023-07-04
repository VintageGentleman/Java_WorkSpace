package quiz.D;

import java.util.HashMap;
import java.util.Map;

public class D07_CountFruit_A {
	
	// 다음 과일들로 이루어진 1000개 크기의 String 타입 랜덤 배열을 생성하고
	// 각 과일이 몇 번 등장했는지 세어보세요
	
	public static String[] fruits =
		{"Apple", "Banana", "Mango", "Grape", "Peach",
				"WaterMelon", "Pineapple", "Dragonfruit"};

	public static void main(String[] args) {
		
		String[] fruitSet = new String[1000];
		
		for(int i = 0; i < fruitSet.length; ++i) {
			int num = (int)(Math.random() * fruits.length);
			fruitSet[i] = fruits[num];
		}
		
		Map<String, Integer> countFruits = new HashMap<>();
		
		for(int i = 0; i < fruits.length; ++i) {
			countFruits.put(fruits[i], 0);
		}
		
		// 과일 개수 세기
		for(int i = 0; i < fruitSet.length; ++i) {
			String fruit = fruitSet[i];
			if(countFruits.containsKey(fruit)) {
				countFruits.replace(fruit,
						countFruits.get(fruit) + 1);
			}
		}

		System.out.println(countFruits);
		
		// 총 1000개 확인
		int total = 0;
		for(Integer count : countFruits.values()) {
			total += count;
		}
		
		System.out.println(total);
		
		/*
		 *  frequency 메서드는 한 번 사용할 때 배열을 그 배열의 길이만큼 살펴보기 때문에
		 *  주의해야한다. 불필요한 연산을 많이 하게 될 확률이 크다.
		List<String> temp = new ArrayList<>(Arrays.asList(fruitSet));
		int apple = Collections.frequency(temp, "Apple");
		int banana = Collections.frequency(temp, "Banana");
		int mango = Collections.frequency(temp, "Mango");
		int grape = Collections.frequency(temp, "Grape");
		int peach = Collections.frequency(temp, "Peach");
		int waterMelon = Collections.frequency(temp, "WaterMelon");
		int pineapple = Collections.frequency(temp, "Pineapple");
		int dragonfruit = Collections.frequency(temp, "Dragonfruit");
		
		Map<String, Integer> countFruits = new HashMap<>();
		
		countFruits.put("Apple", apple);
		countFruits.put("Banana", banana);
		countFruits.put("Mango", mango);
		countFruits.put("Grape", grape);
		countFruits.put("Peach", peach);
		countFruits.put("WaterMelon", waterMelon);
		countFruits.put("Pineapple", pineapple);
		countFruits.put("Dragonfruit", dragonfruit);
		
		System.out.println(countFruits);
		*/
	}
			
}
