package baekjoon;

import java.util.Scanner;

public class Practice {

	/*
	 	입력된 문자가 좌우대칭인지 알려주는 프로그램
	 	(대문자, 소문자 구별 안하고 같은 문자면 됨)
	*/
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print(">> ");
		
		String text = sc.nextLine();
		
		int len = text.length();
		
		int count = 0;
		
		for (int i = 0; i < len / 2; i++) {
			char letter = text.charAt(i);
			char backletter = text.charAt(len - 1 - i);
			
			if (letter >= 'a' && letter <= 'z') {
				letter -= 32;
			}
			if (backletter >= 'a' && backletter <= 'z') {
				backletter -= 32;
			}
			if (letter == backletter) {
				count++;
			}
		}
		
		if (count == len / 2 && count != 0) {
			System.out.println("좌우대칭입니다");
		} else {
			System.out.println("좌우대칭이 아닙니다");
		}
		
		sc.close();
	}
}
