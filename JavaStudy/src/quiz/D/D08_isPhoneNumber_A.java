package quiz.D;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D08_isPhoneNumber_A {

	/*
	  사용자로부터 입력받은 문자열이 유효한 핸드폰 번호인지 검사하는 메서드를 만들어보세요
	*/

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String number = sc.nextLine().trim();

		int len = number.length();
		
		if(len < 13 && len >= 8) {
			List<Character> charSet = new ArrayList<>();
			
			for(int i = 0; i < len; ++i) {
				charSet.add(number.charAt(i));
			}
			
			charSet.add(3, '-');
			charSet.add(8, '-');
			
			String temp = "";
			
			for(int i = 0; i < charSet.size(); ++i) {
				temp += charSet.get(i);
			}
			
			number = temp;
		}

		len = number.length();
		int dash1 = number.indexOf("-");
		int dash2 = number.indexOf("-", dash1 + 1);
		
		boolean condition1 = number.startsWith("010") || number.startsWith("011");
		boolean condition2 = len == 13;
		boolean condition3 = dash1 == 3 && dash2 == 8;
		boolean condition4 = true;
		
		for(int i = 0; i < number.length(); ++i) {
			if(i == 3 || i == 8) {
				continue;
			}
			
			if(!Character.isDigit(number.charAt(i))) {
				condition4 = false;
			}
		}
		
		if (condition1 && condition2 && condition3 && condition4) {
			System.out.println("유효한 번호입니다.");
		} else {
			System.out.println("번호가 유효하지 않습니다.");
		}

		sc.close();
	}
}
