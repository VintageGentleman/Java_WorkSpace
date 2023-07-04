package quiz.B;

import java.util.Scanner;

public class B00_WonToDollar_A {
	
	/*
	  	한국 돈을 입력하면 달러로 얼마인지 출력해주는 프로그램을 만들어보세요
	  	(환율은 구글 검색)	  
	*/
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("금액(￦)을 입력해주세요 > ");
		
		double won = sc.nextDouble();
		
		System.out.printf("%.0f(￦)은 %.2f($)입니다", won, won * 0.00077);		
		
		sc.close();
	}

}
