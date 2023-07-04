
public class A01_Escape {

	/*
	  #Escape 문자
	  
	   - 합쳐져서 특수한 기능을 하는 문자
	   - 코드에 그냥 사용하기에는 문제가 있는 문자들을 표현하기 위한 방식
	   - \ 와 하나의 문자가 합쳐져서 특수한 기능을 한다
	   - \ 와 문자를 합쳐서 두 문자가 되었지만 하나의 문자로 인식된다
	*/
	public static void main(String[] args) {
	    // \n : 줄 바꿈의 기능을 가진 이스케이프 문자	
		System.out.println("안녕하세요! 반갑습니다.");
		System.out.println("안녕\n하세요!\n 반갑습니다.");
		
		// \t : Tab키의 기능을 가진 특수 문자
		System.out.println("안녕하세요! 반\t갑습니다.");
		
		// \\ : 그냥 역슬래시를 출력하고 싶을 때 사용하는 이스케이프 문자
		System.out.println("안녕하세요! 반\\갑습니다.");
		System.out.println("C:\\program Files\\Java\\JDK 17");
		
		// \" : 문자열의 기능을 사용하지 않고 그냥 큰 따옴표를 출력할 때 사용
		System.out.println("오늘 점심은 \"피자\"를 먹었다.");
		
		// \' : 그냥 작은 따옴표를 출력할 때 사용
		System.out.println("오늘 저녁은 '치킨'을 먹을것이다.");
		System.out.println('A');
		System.out.println('B');
		System.out.println(',');
		System.out.println('\'');
		System.out.println('\t');
		
		// 이스케이프 문자는 두 문자가 합쳐져 하나의 문자가 된다
		System.out.println('\\');
		
		System.out.println(' '); // 공백도 문자다
	}
	
}
