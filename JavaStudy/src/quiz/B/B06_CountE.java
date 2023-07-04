package quiz.B;

import java.util.Scanner;

public class B06_CountE {

	/*
	  	사용자가 문장을 입력하면 해당 문장에 알파벳 e가 몇번이나 등장하는지
	  	알려주는 프로그램을 만들어보세요
	  	(대/소문자 모두 세어야 함)
	*/
	
	public static void main(String[] args) {
		String data = "ABCDEFG";
		// "".charAt() : 문자열의 한 글자를 꺼내오기, 맨 앞 글자가 0번
		System.out.println(data.charAt(0));
		System.out.println(data.charAt(1));
		System.out.println(data.charAt(2));

		// "".length() : 문자열의 전체 길이를 알아내기
		System.out.println(data.length());
		
		Scanner sc = new Scanner(System.in);

		System.out.print("아무 문장이나 >> ");
		String text = sc.nextLine();
		sc.close();
		
		int len = text.length();
		
		int count = 0;
		
		for (int i = 0; i < len; ++i) {
			
			char ch = text.charAt(i);
			
			if (ch == 'e' || ch == 'E') {
				++count;
			}
//			System.out.printf("%d번째 문자: %c(%d)\n",
//					i, text.charAt(i), (int)text.charAt(i));
		}
		System.out.println("해당 문자에서 e가 등장한 횟수: " + count);
	}
}
