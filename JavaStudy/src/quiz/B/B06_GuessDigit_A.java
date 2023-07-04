package quiz.B;

import java.util.Scanner;

public class B06_GuessDigit_A {

	/*
	  	사용자가 어떤 숫자를 입력하면 (int 타입)
	  	해당 숫자가 몇 자리 숫자인지를 알려주는 프로그램을 만들어보세요
	  	
	  	123456 -> 6
	  	1111 -> 4
	*/
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		sc.close();
		
		int digit = 1;
		
		for (int i = 0; i < digit; i++) {
			if (num / 10 != 0) {
				num /= 10;
				++digit;
			}
		}
		System.out.println(digit);		
	}
}
