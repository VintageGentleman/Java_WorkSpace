package quiz.B;

import java.util.Scanner;

public class B07_ChangeCase {
	
	/*
	  	사용자가 문장을 입력하면
	  	대문자는 소문자로 소문자는 대문자로 바꿔서 출력해보세요
	  	(영어가 아닌 문자는 그대로 출력)
	*/

	public static void main(String[] args) {
		
		// '문자' + 정수 = 문자 코드 값을 가진 정수
		System.out.println('A' + 1);
		
		// 'A'로 부터 3번째 뒤에 있는 문자가 무엇인지 계산
		System.out.println((char)('A' + 3));
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input Text >>");
		String text = sc.nextLine();
		sc.close();
		
		System.out.println("입력한 text > " + text);
		
		// 마지막 글자의 인덱스는 무조건 길이 -1이 된다
		System.out.println("마지막 letter > " + text.charAt(text.length() -1));
		
		for (int i = 0; i < text.length(); ++i) {
			char ch = text.charAt(i);
			
			if (ch >= 'a' && ch <= 'z') {
				System.out.printf("%c", ch - 32);
			} else if (ch >= 'A' && ch <= 'Z') {
				System.out.printf("%c", ch + 32);
			} else {
				System.out.printf("%c", ch);
			}
		}
		System.out.println();
	}
}
