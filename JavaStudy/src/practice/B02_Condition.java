package practice;

public class B02_Condition {
	
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
		
		int a = 15;
		int b = 20;
		int c = 14;
		int d = 20, e = 60; 
		int year = 2023;
		boolean powerON = true;
		String str = "yea";
		
		boolean result1 = a > 10 && a < 20; 
		boolean result2 = b % 2 == 0;
		boolean result3 = c % 7 == 0;
		boolean result4 = Math.abs(d - e) == 30;
		boolean result5 = year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
		boolean result6 = !powerON;
		boolean result7 = str.equals("yea");
		
		boolean[] resultSet = {result1, result2, result3, result4, result5, result6, result7}; 
		
		for(int i = 1; i <= 7; ++i) {
			System.out.printf("%d. %s\n", i, resultSet[i - 1]);
		}
		
	}
	
}
