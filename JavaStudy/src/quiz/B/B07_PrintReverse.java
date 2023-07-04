package quiz.B;

import java.util.Scanner;

public class B07_PrintReverse {

	/*
	  	사용자가 어떤 문장을 입력했을 때 해당 문장을 거꾸로 출력해보세요
	*/
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아무거나 >> ");
		String text = sc.nextLine();
		
		int len = text.length();
		
		// 1. 마지막 글자부터 시작해서 0번까지 반복하는 방법
		for (int i = len - 1; i >= 0; --i) {
			System.out.print(text.charAt(i));
		}
		System.out.println();

		int lastIndex = len - 1;
		
		// 2. 빼는 숫자를 점점 크게 만들어서 뒤에서부터 반복하는 방법
		for (int i = 0; i < len; ++i) {
			System.out.print(text.charAt(lastIndex - i));
		}
		sc.close();
	}
}
