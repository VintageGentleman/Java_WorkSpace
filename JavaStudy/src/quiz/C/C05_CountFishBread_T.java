package quiz.C;

import myobj.FishBread2;

public class C05_CountFishBread_T {
	
	/*
	  	(1) 붕어빵을 100개 만들고 어떤 붕어빵이 몇 개 있는지 세어보세요
	  		(단, 붕어빵의 맛과 품질은 만들 때 랜덤으로 결정되어야 함)
	  		
	  	(2) 붕어빵 배열을 전달하면 모든 붕어빵의 가격이 얼마인지 계산해주는 
	  		함수를 만들어보세요
	  		
	  	※ 붕어빵의 맛 종류 - 슈크림, 팥, 초코 	
	  	※ 붕어빵의 가격 - 팥 800원, 슈크림 1000원, 초코 1200원
	  	※ 각 붕어빵에는 품질이 있으며 품질에 따라 +- 100원이 된다 (상/중/하)
	*/

	public static int totalPrice(FishBread2[] fishes) {
		int sum = 0;
		for (int i = 0; i < fishes.length; ++i) {
			sum += fishes[i].getPrice();
		}
		return sum;
	}
	
	public static void main(String[] args) {
		
		FishBread2[] fishes = new FishBread2[100];

		for (int i = 0; i < 100; ++i) {
			fishes[i] = new FishBread2();
			fishes[i].info();
		}
		
		System.out.println("총 가격: " + totalPrice(fishes));
	}

}
