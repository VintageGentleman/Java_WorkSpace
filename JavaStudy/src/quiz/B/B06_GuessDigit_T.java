package quiz.B;

import java.util.Scanner;

public class B06_GuessDigit_T {

	/*
	  	사용자가 어떤 숫자를 입력하면 (int 타입)
	  	해당 숫자가 몇 자리 숫자인지를 알려주는 프로그램을 만들어보세요
	  	
	  	123456 -> 6
	  	1111 -> 4
	*/
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 하나 입력하세요 > ");
		int num = sc.nextInt();
		sc.close();
		
		int size = 0;
		
		for (int i = num; i > 0; i /= 10) {
			System.out.println("num:" + i);
			++size;
		}
		System.out.printf("입력하신 숫자는 %d자리 숫자입니다.\n", size);		
	}
}
