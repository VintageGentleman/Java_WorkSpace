import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D10_Regex {

	/*
	  	# 정규표현식(Regular Expression)
	  	
	  	- 문자열이 특정 패턴과 일치하는지 검사할 수 있는 표현식
	  	- 특정 프로그래밍 언어에만 있는 것이 아닌 공통의 규칙
	  	
	  	# 자바에서 정규표현식을 활용하기 위한 클래스
	  	
	  	- java.util.regex.Pattern
	*/
	
	public static void main(String[] args) {
		
		// Pattern.matches(regex, input) 
		// : input이 regex에 해당하는 문자열인지 검사하는 메서드
		System.out.println(Pattern.matches("sleep", "sleep"));
		
		System.out.println("----------------------------------");
		// [] : 해당 위치에 허용할 문자를 정의하는 정규표현식 문법 
		System.out.println(Pattern.matches("s[lh]eep", "sleep"));
		System.out.println(Pattern.matches("s[lh]eep", "sheep"));
		System.out.println(Pattern.matches("s[lh]eep", "aheep"));
		System.out.println(Pattern.matches("s[lh]eep", "saeep"));
		System.out.println(Pattern.matches("[cs][lh]eep", "cleep"));
		
		System.out.println("----------------------------------");
		System.out.println(Pattern.matches("01[01679]-", "019-"));
		System.out.println(Pattern.matches("01[01679]-", "012-"));
		System.out.println(Pattern.matches("01[01679]-", "013-"));
		
		System.out.println("-----------------\\\\---------------");
		// \는 정규표현식 내부에서도 특수문법으로 활용되기 때문에
		// 정규표현식에서 \\가 되도록 자바 문자열에서는 4개를 적어줘야 한다 
		System.out.println(Pattern.matches("s[1h\\\\]eep", "s\\eep"));
		
		/*
		   # []내부에서 사용하는 문법들
		   
		   [abc] : a 또는 b 또는 c를 허용
		   [a-z] : a 부터 z까지 모두 허용
		   [A-Z] : A 부터 Z까지 모두 허용. 대문자 구분함.
		   [a-zA-Z] : 모든 알파벳 허용
		   [a-f&&c-g] : 두 조건을 모두 만족하는 문자만 허용
		*/
		
		System.out.println("---------------문법들---------------");
		System.out.println(Pattern.matches("[a-z]at", "cat"));
		System.out.println(Pattern.matches("[a-z]at", "Tat"));
		System.out.println(Pattern.matches("[a-zA-Z]at", "Cat"));
		System.out.println(Pattern.matches("[a-e&&c-y]at", "eat"));
		System.out.println(Pattern.matches("[a-e&&c-y]at", "fat"));
		
		/*
		  	# 하나로 여러 문자를 나타내는 것들
		  	
		  	. : 모든 문자 허용, [.] 또는 \.은 .만 허용한다는 뜻
		  	\d : 모든 숫자 허용
		  	\D : 숫자를 제외한 모든 것을 허용
		  	\s : 모든 공백 허용 (\t, \n, \r, ' ')
		  	\S : 공백을 제외한 모든 것을 허용
		  	\w : 일반적인 문자들을 허용 ([a-zA-Z0-9_]와 같음)
		  	\W : \w를 제외한 모든 것을 허용
		*/
		
		System.out.println("------------하나로 여러 문자-----------");
		System.out.println(Pattern.matches(".at", "#at"));
		System.out.println(Pattern.matches(".at", ".at"));
		System.out.println(Pattern.matches("[.]at", "$at"));
		System.out.println(Pattern.matches("\\.at", "&at"));
		
		System.out.println(Pattern.matches("\\dat", "9at"));
		System.out.println(Pattern.matches("\\Dat", "9at"));
	
		System.out.println("공백문자");
		System.out.println(Pattern.matches("\\d\\d\\s\\d", "12\t4"));
		System.out.println(Pattern.matches("\\d\\d\\s\\d", "12\n4"));
		System.out.println(Pattern.matches("\\d\\d\\s\\d", "12 4"));
		System.out.println(Pattern.matches("\\d\\d\\s\\d", "12\r4"));
		
		/*
		 	# 해당 패턴이 적용될 문자의 개수를 지정하기
		 	
		 	※ 정규표현식 내에서 보기좋으라고 띄어쓰기하면 에러남
		 	
		 	.{n}	: {} 앞의 패턴이 n개 일치해야 한다
		 	.{n,m}	: {} 앞의 패턴이 n개 이상 m개 이하 일치해야 한다
		 	.{n,} 	: {} 앞의 패턴이 n개 이상 일치해야 한다
		 	.?		: ? 앞의 패턴이 0번 또는 한 번 나와야 한다
		 	.+		: + 앞의 패턴이 최소 한 번 이상 나와야 한다
		 	.*		: * 앞의 패턴이 0번 이상 나와야 한다
		*/
		
		System.out.println("패턴이 적용될 문자의 개수 지정하기");
		System.out.println(Pattern.matches("\\d{4}[.]jpg", "1234.jpg"));
		System.out.println(Pattern.matches("a{1,4}[.]jpg", "a.jpg"));
		System.out.println(Pattern.matches("a{1,4}[.]jpg", "aa.jpg"));
		System.out.println(Pattern.matches("a{1,4}[.]jpg", "aaa.jpg"));
		System.out.println(Pattern.matches("a{1,4}[.]jpg", "aaaa.jpg"));
		System.out.println(Pattern.matches("a{1,4}[.]jpg", "aaaaa.jpg"));
		
		System.out.println(Pattern.matches("b?[.]jpg", ".jpg"));
		System.out.println(Pattern.matches("b+[.]jpg", "bbbb.jpg"));
		System.out.println(Pattern.matches("b*[.]jpg", ".jpg")); // 안씀 true
		System.out.println(Pattern.matches("b*[.]jpg", "b.jpg")); // 하나 씀 true
		System.out.println(Pattern.matches("b*[.]jpg", "bbbbbb.jpg")); // 많이 씀 true
		System.out.println(Pattern.matches("b*[.]jpg", "a.jpg")); // 다른 패턴 false
		
		// 문법을 소괄호로 묶어서 적용하는 것이 가능
		System.out.println("소괄호 묶기 : " + Pattern.matches("([.]\\w+)?", ""));
		
		// 여러개 중 하나를 선택하게 만들기
		System.out.println("하나 선택 : "
				+ Pattern.matches("255|168|123", "168")); 
		
		// 연습1 : 해당 문자열이 핸드폰 번호인지 검사할 수 있는 정규표현식을 만들어보세요.
		//		 (옛날 번호 포함)
		
		// 연습2 : 해당 문자열이 이메일인지 검사할 수 있는 정규표현식을 만들어보세요
		
		// 연습3 : 해당 문자열이 IP주소(IPv4)인지 검사할 수 있는 정규표현식을 만들어보세요.
		// 		  (0.0.0.0 ~ 255.255.255.255)
		
		String practice1 = "010-1234-1234";
		
		String practice2 = "pica0818@hanmail.com";
				
		String practice3 = "196.0.8.255";
		
		System.out.println("");
		
		boolean result1 = Pattern.matches("01[019]-?\\d{4}-?\\d{4}", practice1);
		
		boolean result2 = Pattern.matches("\\w+@\\w+[.]\\w+([.]\\w+)?", practice2);
		
		boolean result3 = Pattern.matches("(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])[.]"
				+ "(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])[.]"
				+ "(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])[.]?"
				+ "(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])"
				, practice3); 
		
		System.out.println("====연습문제====");
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		
		System.out.println("====연습문제 해답====");
		String regex1 = "01[01679](-\\d{3,4}-|\\d{3,4})\\d{4}";
		System.out.println(Pattern.matches(regex1, "010-1234-1234"));
		
		String regex2 = "[\\w\\d]+@[\\w\\d]+\\.[\\w]+(\\.[\\w]+)?";
		System.out.println(Pattern.matches(regex2, "abc213@abc.co"));
		
		String regex3 = "((25[0-5]|2[0-4][0-9]|1?\\d?\\d)\\.){3}"
				+ "(25[0-5]|2[0-4][0-9]|1?\\d?\\d)";
		System.out.println(Pattern.matches(regex3, "0.0.0.0"));
		
		// # Pattern - 전체 문자열이 정규 표현식과 일치하는지 검사한다
		// # Matcher - 전체 문자열을 탐색하면서 정규 표현식과 매치하는 부분을 찾는다
		String fruits = "apple/banana/kiwi/pineapple/mango/kiwi/orange"
				+ "apple/banana/redkiwi/goldkiwi+/purplekiwi/watermelon"
				+ "redkiwi+/redkiwi+/redkiwi/redkiwi";

		// 1. 전달한 정규 표현식을 컴파일하여 Pattern 인스턴스 생성
		Pattern kiwiRegex = Pattern.compile("(\\w*)(kiwi)(\\+?)");

		// 2. 생성한 Pattern 인스턴스로 Matcher를 생성
		// 	  (해당 패턴으로 검사할 문자열을 전달)
		Matcher m1 = kiwiRegex.matcher(fruits);
		
		// 3. 반복문을 통해 패턴과 매치되는 위치를 모두 찾을 수 있다
		while(m1.find()) {
			System.out.println("이번에 find()로 찾은 것: " + m1.group(3));
			System.out.println("시작 위치: " + m1.start(3));
			System.out.println("끝 위치: " + m1.end(3));
		}
	}
}
