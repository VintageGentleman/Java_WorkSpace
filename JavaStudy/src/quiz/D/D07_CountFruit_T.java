package quiz.D;

import java.util.HashMap;

public class D07_CountFruit_T {
	
	// 다음 과일들로 이루어진 1000개 크기의 String 타입 랜덤 배열을 생성하고
	// 각 과일이 몇 번 등장했는지 세어보세요
	
	public static String[] fruits =
		{"Apple", "Banana", "Mango", "Grape", "Peach",
				"WaterMelon", "Pineapple", "Dragonfruit"};

	public static void main(String[] args) {
		
		String[] fruitArr = new String[1000];
		
		for(int i = 0; i < fruitArr.length; ++i) {
			fruitArr[i] = fruits[(int)(Math.random() * fruits.length)];
		}
		
		HashMap<String, Integer> fruitCount = new HashMap<>();
		
		for(int i = 0; i < fruits.length; ++i) {
			fruitCount.put(fruits[i], 0);
		}
		
		for(int i = 0; i < fruitArr.length; ++i) {
			String name = fruitArr[i];
			int count = fruitCount.get(name);
			fruitCount.put(name, count + 1);
		}
		
		System.out.println(fruitCount);
		
	}
	
}
