
public class A03_VariableTypes {
	
	/*
	 	#정수 타입들
	 	
	 	 - byte		(1byte, 8bit)
	 	 
	 	    2^8(256)가지의 값을 표현할 수 있음
	 	    byte타입 변수에 넣을 수 있는 정수의 범위는 -128 ~ +127
	 	    
	 	    0000 0000 : 0
	 	    0000 0001 : 1
	 	    ...
	 	    0111 1111 : 127
	 	    1000 0000 : -128
	 	    1000 0001 : -127
	 	    
	 	    첫 번째 자리는 부호표시
	 	    컴퓨터에서 계산 시에는 음수일 경우 값을 뒤집어 계산함.
	 	    1000 0000 => 0111 1111 + 1 계산 시에 +1을 해줌
	 	    
	 	 - short	(2byte, 16bit)
	 	 	
	 	 	2^16(65,536)가지의 값을 표현할 수 있음
	 	 	short타입 변수에 넣을 수 있는 정수의 범위는 -32,768 ~ +32,767	 	 	
	 	 	
	 	 - char 	(2byte, 양수만)
	 	 
	 	  	2^16(65,536)가지의 값을 표현할 수 있음
	 	  	char타입 변수에 넣을 수 있는 정수의 범위는 0 ~ +65,535
	 	 
	 	 - int		(4byte)
	 	 
	 	 	2^32(약 43억)가지의 값을 표현할 수 있음...
	 	 
	 	 - long		(8byte)
	 	 
	 	 	2^64...
	  	
	  	# 실수 타입
	  	
	  	 - 부동 소수점 방식을 사용한다
	  	 - float	(4byte)
	  	 - double	(8byte)
	  
	  	# 참/거짓 타입
	  	
	  	 - boolean 불리언
	  	 
	  	# 문자열
	  	 
	  	 - String
	  	 
	  	# 그 외 모든 클래스들 ... (아직은 이르다)
	*/

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		//정수를 저장할 수 있는 변수 타입들
		byte	byte1 = -128; //타입 이름은 변수명으로 쓸 수 없음 ex) byte, short
		short  	short1 = 123; 
		
		// char타입에 저장하는 정수는 몇 번째 문자인지를 의미한다(ASCII 코드)
		char 	char1 = 65535;
		char 	char2 = 50;
		char	char3 = 100;
		
		// 문자 타입 값은 실제로 정수값이다
		char ch1 = 'A';	// 실제로 ch1에는 65가 저장된다
		char ch2 = 65;
		char ch3 = '漢';
		char ch4 = 'A' + 25; // 문자는 정수이기 때문에 정수와의 계산이 가능하다
		
		// 문자 타입은 실제로 정수값이기 때문에 다른 정수 타입에 저장해도 된다
		int i1 = 'B'; // 출력시 66으로 나옴
		int i2 = '가'; // '가'가 ASCII에서 몇 번째 값인지 알 수 있다
		int i3 = '家';
		
		System.out.println("ch1 : " + ch1);
		System.out.println("ch2 : " + ch2);
		System.out.println("ch3 : " + ch3);
		System.out.println("ch4 : " + ch4);
		
		System.out.println("i1 : " + i1);
		System.out.println("i2 : " + i2);
		System.out.println("i3 : " + i3);
		
		char1 = 70; //char타입에 저장한 정수는 출력할 때 숫자 대신 문자가 나온다
		
		System.out.println(byte1);	
		System.out.println(short1);
		
		// char타입은 각 번호에 해당하는 문자를 출력하게끔 되어있다
		System.out.println(char1);
		System.out.println(char2);
		System.out.println(char3);
		
		// int의 범위는 대략 42억 +-21억
		int int1 = 2100000000;
		
		// int의 범위를 넘어가는 정수 뒤에는 L을 붙여야 한다 (Long타입 리터럴이라는 표시)
		long long1 = 1111111111111111L;
		
		// Q. 숫자 뒤에 L을 적는 건 컴퓨터를 위해서 적는건가요?
		// A. 그냥 적는 정수는 기본적으로 컴파일러가 int로 인식하기 때문에
		//    L이라고 표시를 해줘야 long으로 인식할 수 있다
		
		
		// 그냥 소수를 적는 것은 컴파일러가 double이라고 받아들이기 때문에
		// 뒤에 F라고 표시를 해줘야 float으로 인식할 수 있다
		float float1 = 123.123F;
		double double1 = 123.123;
		
		// boolean 타입은 변수 이름이 아주 중요하다
		boolean male = true;
		boolean female = true;
		boolean goonpil = true;
		boolean silve = false;
		boolean over130cm = false;
		boolean powerOn = true;
		
		// String 타입만 대문자로 시작한다
		// 소문자로 시작하는 모든 타입들을 기본형 변수 타입이라고 한다
		// 대문자로 시작하는 모든 타입들을 참조형 변수 타입이라고 한다
		String message = "문 앞에 놓고 가주세요";			
		
	}
}
