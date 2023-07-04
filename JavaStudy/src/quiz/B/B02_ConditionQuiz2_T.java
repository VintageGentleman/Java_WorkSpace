package quiz.B;

import java.util.Scanner;

public class B02_ConditionQuiz2_T {
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
		char a = 'Q';
		
		System.out.println(a == 'q' || a == 'Q');
		
		// 2. char형 변수 b가 공백이나 탭이 아닐 때 true
		char b = ' ';
		
		System.out.println(!(b == ' ' || b == '\t'));		

		// 3. char형 변수 c가 '0' ~ '9'일 때 true
		char c = '3'; // ''가 없으면 아스키코드 3에 등록된 값이 출력됨.
		
		System.out.println(c >= '0' && c <= '9');	
		
		// 4. char형 변수 d가 영문자(대문자 또는 소문자)일 때 true
		char d = 'a';
		
		System.out.println(d >= 'a' && d <= 'z'
				|| d >= 'A' && d <= 'Z');	
		
		// 'A' : 65
		// 'z' : 122
		System.out.println(d >= 65 && d <= 122);
		System.out.println((int)'z');
		// 대문자와 소문자 사이에 특수문자들이 있기 때문에 쓰면 안되는 방식
		
		// 5. char형 변수 e가 한글일 때 true (한글의 범위는 유니코드 검색)
		char e = '손';
		
		System.out.println(e >= '가' && e <= '힣');
		
		// 6. 사용자가 입력한 문자열이 quit일 때 true
		Scanner sc = new Scanner(System.in);
		
		System.out.print("> ");
		
		String myData = "quit";
		String user = sc.nextLine();
		sc.close();
		
		// 참조형 변수타입의 ==은 같은 주소를 가리키고 있는지를 비교하는 것
		// equals는 가지고 있는 실제 값이 같은지를 비교하는 것
		System.out.println(myData == "quit"); // 서로의 참조값을 비교함
		System.out.println(user == "quit");
		System.out.println(user.equals("quit")); // 해시값을 이용해서 비교함
		
	}
}
