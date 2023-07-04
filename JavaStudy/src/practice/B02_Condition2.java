package practice;

import java.util.Scanner;

public class B02_Condition2 {
	
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

		Scanner sc = new Scanner(System.in);
		
		char a = 'q';
		char b = '\t';
		char c = '1';
		char d = 'a';
		char e = '밹';
		String str = sc.nextLine();
		sc.close();
		
		boolean result1 = a == 'q' || a == 'Q';
		boolean result2 = b != ' ' || b != '\t';
		boolean result3 = c >= '0' && c <= '9';
		boolean result4 = d >= 'a' && d <= 'z' || d >= 'A' && d <= 'Z';
 		boolean result5 = e >= 44032 && e <= 55215; 
 		boolean result6 = "quit".equals(str);
 		
		boolean[] resultSet = {result1, result2, result3, result4, result5, result6};
		
		for(int i = 0; i < 6; ++i) {
			System.out.printf("%d. %s\n", i + 1, resultSet[i]);
		}
		
	}
}
