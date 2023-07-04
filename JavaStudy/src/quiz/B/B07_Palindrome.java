package quiz.B;

import java.util.Scanner;

public class B07_Palindrome {

	/*
	  	사용자가 단어를 입력하면
	  	해당 언어가 좌우대칭인지 판별해주는 프로그램을 만들어보세요
	  	(대문자, 소문자 간에도 가능해야함)
	*/
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print(">> ");
		String word = sc.nextLine();
		sc.close();
		
		// 5글자 -> 0,1까지 비교해야함
		// 6글자 -> 0,1,2까지 비교해야함		
		int len = word.length();
		int mid = len / 2;
		
		// 빈 문자열
		String lowercase = "";
		
		for (int i = 0; i < len; ++i) {
			char ch = word.charAt(i);
			
			// word에서 꺼낸 문자가 대문자인 경우 소문자로 변경하여 누적시키기
			if (ch >= 'A' && ch <= 'Z') {
				ch += 32;
			}
			lowercase += ch;
		}
		
		boolean isPalindrome = true;
		
		for (int i = 0; i < mid; ++i) {
			char ch1 = lowercase.charAt(i);
			char ch2 = lowercase.charAt(len - 1 -i);
			
			isPalindrome &= ch1 == ch2;
			
			if (ch1 == ch2) {
				System.out.printf("%d번째 문자와 %d번째 문자가 일치합니다. \n",
						i, len - 1 - i);
			} else {
				System.out.printf("%d번째 문자와 %d번째 문자가 불일치합니다. \n",
						i, len - 1 - i);
			}
		}
		
		System.out.println("Palindrome 여부: " + isPalindrome);
		
	}
}
