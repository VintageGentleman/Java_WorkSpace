package quiz.B;

import java.util.Scanner;

public class B08_Numeric {

	/*
	 	사용자가 입력한 문자열이 모두 숫자로만 구성된 문자열인지
	 	판별하는 프로그램을 만들어보세요
	*/
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Input something >> ");
		String text = sc.next();
		
		boolean onlyNumber = true;
		
		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			
			if (ch < '0' || ch > '9') {
				onlyNumber = false;
				break;
			}
//			System.out.printf("%c는 숫자입니까? %s\n",
//					ch, ch >= '0' && ch <= '9');
		}
		System.out.println("Only Number? " + onlyNumber);
		sc.close();
	}
}
