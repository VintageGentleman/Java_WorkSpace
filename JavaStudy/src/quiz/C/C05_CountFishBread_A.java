package quiz.C;

import myobj.FishBread;

public class C05_CountFishBread_A {
	
	/*
	  	(1) 붕어빵을 100개 만들고 어떤 붕어빵이 몇 개 있는지 세어보세요
	  		(단, 붕어빵의 맛은 만들 때 랜덤으로 결정되어야 함)
	  		
	  	(2) 붕어빵 배열을 전달하면 모든 붕어빵의 가격이 얼마인지 계산해주는 
	  		함수를 만들어보세요
	  		
	  	※ 붕어빵의 맛 종류 - 슈크림, 팥, 초코 	
	  	※ 붕어빵의 가격 - 팥 800원, 슈크림 1000원, 초코 1200원
	  	※ 각 붕어빵에는 품질이 있으며 품질에 따라 +- 100원이 된다 (상/중/하)
	*/
	
	public static int digit(int number) {
		int digit = 0;
		for (int i = number; i > 0; i /= 10) {
			++digit;
		}
		return digit;
	}
	
	public static void main(String[] args) {
		
		FishBread fb = new FishBread();
		FishBread[] bread = new FishBread[100];
		
		// 붕어빵 100개 생성
		for (int i = 0; i < bread.length; ++i) {
			bread[i] = new FishBread();
		}
		
		for (int i = 0; i < bread.length; ++i) {
			String tasteName = FishBread.tasteType[bread[i].taste];
			String gradeName = FishBread.gradeType[bread[i].grade];
			System.out.printf("%"+digit(bread.length)+"d번째 붕어빵,\t%s맛\t품질: %s\n",
					i + 1, tasteName, gradeName);
		}
		System.out.println("=================================");
		
		// 어떤 붕어빵이 몇 개 있는지 세기
		fb.breadTypeCount(bread); 
		
		// 붕어빵 배열을 전달하면 모든 붕어빵의 가격을 계산해주는 함수
		int price = fb.breadPrice(bread);
		System.out.printf("총 가격 %d원\n\n", price);
	}
	
}
