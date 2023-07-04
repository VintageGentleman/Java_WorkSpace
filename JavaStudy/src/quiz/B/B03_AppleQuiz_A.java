package quiz.B;

import java.util.Scanner;

public class B03_AppleQuiz_A {
	
	/*
		사과를 10개씩 담을 수 있는 바구니가 있을 때
	
	  	사용자가 사과의 개수를 입력하면 사과를 모두 담기 위해 필요한
	  	바구니의 개수를 알려주는 프로그램을 만들어보세요
	*/
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("사과 개수 > ");
		
		int appleQty = sc.nextInt();
		sc.close();
		
		int basket;
		
		if(appleQty % 10 == 0 && appleQty > 0) {
			basket = appleQty / 10;
			System.out.printf("필요한 바구니의 개수 : %d \n", basket);			
		} else if(appleQty >= 10) {
			basket = appleQty / 10 + 1;
			System.out.printf("필요한 바구니의 개수 : %d \n", basket);
		} else if(appleQty < 10 && appleQty > 0) {
			System.out.println("필요한 바구니의 개수 1");			
		} else {
			System.out.println("사과의 개수가 이상합니다...");	
		}
		
	}

}
