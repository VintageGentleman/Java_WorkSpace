package quiz.B;

import java.util.Scanner;

public class B07_Palindrome2 {

	/*
	  	사용자가 단어를 입력하면
	  	해당 언어가 좌우대칭인지 판별해주는 프로그램을 만들어보세요
	  	(대문자, 소문자 간에도 가능해야함)
	*/
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print(">> ");
		String word = sc.next();
		
		sc.close();
		
		// (1) 단어 내의 모든 대문자를 소문자로 바꾼다
		String lowercase = "";
		int len = word.length();
		
		for (int i = 0; i < len; ++i) {
			char ch = word.charAt(i);
			if (ch >= 'A' && ch <= 'Z') {
				ch += 32;
			}
			lowercase += ch;
		}
		
		// (2) 거꾸로 뒤집는다
		String reversedLowercase = "";
		for (int i = 0; i < len; ++i) {
			reversedLowercase += lowercase.charAt(len - 1 - i);
		}
		
		// (3) 원본과 거꾸로 뒤집은 문자열이 일치하면 좌우대칭이다
		System.out.println("뒤집은 소문자와 소문자가 일치하나요? " +
				lowercase.equals(reversedLowercase));
		
	}
}
