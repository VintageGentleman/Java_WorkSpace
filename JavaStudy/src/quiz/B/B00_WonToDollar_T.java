package quiz.B;

import java.util.Scanner;

public class B00_WonToDollar_T {
	
	/*
	  	한국 돈을 입력하면 달러로 얼마인지 출력해주는 프로그램을 만들어보세요
	  	(환율은 구글 검색)	  
	*/
	
	public static void main(String[] args) {
		
		// Ctrl + Shift + O : 자동 import 단축키
		Scanner sc = new Scanner(System.in);
		
		System.out.print("한국 돈을 입력 : ");		
		int won = sc.nextInt();
		double dollar = won * 0.00077;
		
		System.out.printf("%d원은 %.2f$입니다.\n", won, dollar);						
		
		sc.close();
	}
}
