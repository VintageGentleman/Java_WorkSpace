package quiz.B;

public class B02_ConditionQuiz_T {
	
	/*
 	  	# 알맞은 비교 연산을 만들어보세요
 	  	
 	  	 1. int형 변수 a가 10보다 크고 20보다 작을 때 true
 	  	 2. int형 변수 b가 짝수일 때 true
 	  	 3. int형 변수 c가 7의 배수일 때 true
 	  	 4. int형 변수 d와 e의 차이가 30일 때 true
 	  	 5. int형 변수 year가 400으로 나누어 떨어지거나
 	  	  	또는 4로 나누어 떨어지고 100으로 나누어 떨어지지 않을 때 true (윤년 계산)
 	  	 6. boolean형 변수 powerON이 false일 때 true
 	  	 7. 문자열 참조변수 str이 "yea"일 때 true 	
	*/
	public static void main(String[] args) {
		
		
	  	// 1. int형 변수 a가 10보다 크고 20보다 작을 때 true
	  	int a = 1234;
	  	
	  	boolean result1 = a > 10 && a < 20;
	  	
	  	System.out.println(result1);	  			
		
		// 2. int형 변수 b가 짝수일 때 true
	  	int b = 999;
	  	
	  	boolean result2 = b % 2 == 0;
	  	
	  	System.out.println(result2);	  			
	  	
	  	// 3. int형 변수 c가 7의 배수일 때 true
	  	int c = 77;
	  	
	  	boolean result3 = c % 7 == 0;
	  	
	  	System.out.println(result3);	
	  	
	  	// 4. int형 변수 d와 e의 차이가 30일 때 true
	  	int d = 100, e = 70;
	  	
	  	boolean result4 = Math.abs(d - e) == 30;
	  	// boolean result4 = d - e == 30 || d - e == -30;
	  	
	  	System.out.println(result4);
	  	
	  	// 5. int형 변수 year가 400으로 나누어 떨어지거나	  	
	  	// 	  또는 4로 나누어 떨어지고 100으로 나누어 떨어지지 않을 때 true (윤년 계산)
	  	int year = 2024;
	  	
	  	// &&와 ||가 나란히 있을 때는 &&를 먼저 한다
	  	boolean isLeapYear =
	  			year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	  	
	  	System.out.printf("%d년은 윤년입니까? %s\n", year, isLeapYear);
	  	
	  	// 6. boolean형 변수 powerON이 false일 때 true
	  	boolean powerON = false;
	  	
	  	System.out.println(powerON == false);
	  	System.out.println(!powerON);
	  	
	  	// 7. 문자열 참조변수 str이 "yea"일 때 true 			
	  	String str = "yes";
	  	
	  	// ※ 문자열(대문자로 시작하는 타입)은 ==으로 비교하면 안됨
	  	System.out.println(str == "yes");
	  	
	  	// 참조형 변수는 equals() 메서드로 비교해야 한다
	  	// (모든 참조형 변수는 equlas() 메서드를 보유하고 있다)
	  	System.out.println(str.equals("yes"));
		
	}
}
