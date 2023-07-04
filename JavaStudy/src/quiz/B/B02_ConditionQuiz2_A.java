package quiz.B;

import java.util.Scanner;

public class B02_ConditionQuiz2_A {
	
	/*
	  	# 알맞은 조건식을 만들어보세요
	  	
	  	 1. char형 변수 a가 'q' 또는 'Q'일 때 true
	  	 2. char형 변수 b가 공백이나 탭이 아닐 때 true
	  	 3. char형 변수 c가 '0' ~ '9'일 때 true
	  	 4. char형 변수 d가 영문자(대문자 또는 소문자)일 때 true
	  	 5. char형 변수 e가 한글일 때 true (한글의 범위는 유니코드 검색)
	  	 6. 사용자가 입력한 문자열이 quit일 때 true
	*/
	
	public static void main(String[] args) {
		
		// 1. char형 변수 a가 'q' 또는 'Q'일 때 true
		char a = 'q';
		
		boolean result1 = a == 'q' || a == 'Q';
		
		System.out.println(result1);
		
		// 2. char형 변수 b가 공백이나 탭이 아닐 때 true
		char b = ' ';
		
		boolean result2 = !(b == ' ' || b == '\t');
		
		System.out.println(result2);		
		
		// 3. char형 변수 c가 '0' ~ '9'일 때 true		
		char c = 48;
				
		boolean result3 = c >= 48 && c <= 57;
			
		System.out.printf("%c, 결과 %s \n", c, result3);		
		
		// 4. char형 변수 d가 영문자(대문자 또는 소문자)일 때 true
		char d = 'd';
				
		boolean result4 = d >= 65 && d <= 90 || d >= 97 && d <= 122;
				
		System.out.printf("%c는 영문자입니까? %s \n", d, result4);	
		
		// 5. char형 변수 e가 한글일 때 true (한글의 범위는 유니코드 검색)
		char e = '한';
		
		boolean result5 = e >= 44032 && e <= 55215;
		
		System.out.printf("%c(은)는 한글입니까? %s \n", e, result5);	
		
		// 6. 사용자가 입력한 문자열이 quit일 때 true
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력하세요 > ");
		
		String str1 = sc.nextLine();
		sc.close();
		
		boolean result6 = str1.equals("quit");
		
		System.out.printf("입력하신 값은 %s입니다 > %s\n", str1, result6);		
								
				
	}
}
