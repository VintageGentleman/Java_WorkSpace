
public class D04_WrapperClass {

	/*
	  	# Wrapper Class
	  	
	  	- 각 기본형 타입에 대응하는 참조형 타입
	  	- 각 타입과 관련된 유용한 기능들이 해당 클래스에 정의되어 있다
	  	
	  	# 기본형
	  	
	  	- int, char, byte, short, long, float, double, boolean
	  	
	  	# 참조형
	  	
	  	- Integer, Character, Byte, Short, Long, Float, Double, Boolean
	*/
	
	public static void main(String[] args) {
		
		/*
		  	# Parsing
		  	
		  	- 문자열을 해당 타입 값으로 변환하는 기능
		  	- 각 타입 클래스마다 parseXXX 메서드가 존재한다
		*/
		
		String value = "12345";
		String value2 = "123.12345";
		String value3 = "10111";
		
		// parseXXX(str) : 전달한 문자열의 정수값을 리턴한다
		int a = Integer.parseInt(value);
		short b = Short.parseShort(value);
		
		// parseXXX(str, radix) : 전달한 문자열을 해당 진법으로 계산한 정수값을 리턴한다
		a = Integer.parseInt(value3, 10);
		
		float c = Float.parseFloat(value2);
		double d = Double.parseDouble(value2); 
				
		System.out.println(a + a);
		System.out.println(b + b);
		System.out.println(c + c);
		System.out.println(d + d);
		
		/*
		  	# toString
		  	
		  	- 각 WrapperClass의 toString()은 해당 타입 값을 문자열로 변환시키는 
		  	  기능을 가지고 있다.
		  	- 인스턴스의 toString()은 해당 인스턴스를 문자열로 변환한 값을 반환한다
		  	- 스태틱의 toString()은 전달한 값을 문자열로 변환한 값을 반환한다 
		*/
		
		Integer num1 = 10; // new Integer(10)과 같음
		String str1 = num1.toString();
		String str2 = Integer.toString(0x123);
		
		System.out.println(str1);
		System.out.println(str2);
		
		// Integer.toString(i. radix): 원하는 값을 해당 진법 문자열로 변환하여 반환
		System.out.println(Integer.toString(0x3AF, 2));
		System.out.println(Double.toHexString(55.1235441));
		
		// 각 타입들과 관련된 상수들
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Short.BYTES + "bytes");
		System.out.println(Short.SIZE + "bits");
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);

		// Character 타입의 기능들
		System.out.println("글자인가요?" + Character.isAlphabetic('김'));
		System.out.println("글자인가요?" + Character.isAlphabetic('A'));
		System.out.println("글자인가요?" + Character.isAlphabetic('9'));
		System.out.println("글자인가요?" + Character.isAlphabetic('_'));
		System.out.println("글자인가요?" + Character.isAlphabetic('+'));
		
		System.out.println("대문자인가요?" + Character.isUpperCase('A'));
		System.out.println("대문자인가요?" + Character.isUpperCase('d'));
		System.out.println("대문자인가요?" + Character.isUpperCase('ㅇ'));
		
		char ch = '김';
		System.out.println("영문자인가요?" +
				(Character.isUpperCase(ch) || Character.isLowerCase(ch)));
		
		System.out.println("공백인가요? " + Character.isWhitespace('\t'));
		System.out.println("공백인가요? " + Character.isWhitespace(' '));
		System.out.println("공백인가요? " + Character.isWhitespace('\n'));
		System.out.println("공백인가요? " + Character.isWhitespace('A'));
		
		System.out.println("숫자인가요? " + Character.isDigit('0'));
		System.out.println("숫자인가요? " + Character.isDigit('ㅁ'));

		// 자바 변수 첫 번째 글자로 사용할 수 있나요?
		System.out.println(Character.isJavaIdentifierStart('#'));
		System.out.println(Character.isJavaIdentifierStart('A'));
		System.out.println(Character.isJavaIdentifierStart('_'));
		System.out.println(Character.isJavaIdentifierStart('$'));
		System.out.println(Character.isJavaIdentifierStart('7'));
		
		// 자바 변수에 사용되는 문자인가요?
		System.out.println(Character.isJavaIdentifierPart('8'));
		System.out.println(Character.isJavaIdentifierPart(' '));
		System.out.println(Character.isJavaIdentifierPart('#'));
	}
}
