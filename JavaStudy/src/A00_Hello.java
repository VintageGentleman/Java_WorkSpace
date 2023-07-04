/*
  #주석 (Comment)
   - 개발자가 하고 싶은 말을 적어 놓는 것
   - 컴파일시에 무시되기 때문에 프로그램 실행에 영향을 미치지 않는다
   - 프로그래밍 언어마다 주석을 사용하는 방법이 다를 수 있다
   - 자바에는 한 줄 주석과 여러 줄 주석이 있다
*/

//한 줄 주석

/*
  여러 줄
  주석
*/

/**
  파란
  여러 줄
  주석(메서드나 클래스에 대한 설명을 적을 때 사용)
*/

// Ctrl + [+,-] : 글자 크기 조절
/*
 워크스페이스 내부 > 프로젝트 내부 > src 폴더 내부에 소스코드(.java)를 작성한다
 
 Ctrl + F11을 눌렀을 때
 컴파일 결과물(.class)은 프로젝트 폴더 내부의 bin 폴더에 보관되며
 이클립스가 그곳의 파일을 자동으로 실행해준다
*/

// ※public class의 이름은 반드시 파일명과 같아야 한다

public class A00_Hello {
	
// Eclipse에서 빨간 줄이 생겼을 때(에러) 그곳에 커서를 두고 F2를 누르면
// 해당 에러가 발생한 원인과 간단한 해결책을 볼 수 있다

/*
  #main() 함수
 
   - 자바에서 어떤 단어 뒤에 ()가 있으면 무조건 함수다
   - main() 함수는 프로그램의 시작 지점이다
   - 사용자가 프로그램을 실행하면 가장 먼저 main()을 찾아 실행한다
   - main() 함수가 종료되면 프로그램도 종료된다
   - 자바의 main() 함수 정의 부분에 하나라도 다른 것이 있다면
   프로그램의 시작 지점으로 인정되지 않는다
   - main() 함수의 범위는 {}로 지정한다
   - {}를 지정할 때는 들여쓰기를 반드시 맞춰야 한다  
*/
	public static void main(String[] args) {
		//프로그램의 시작
	
		/*
		  # System.out.println() 함수
		  
		   - () 안에 전달한 데이터를 콘솔 화면에 출력해주는 함수
		   
		  # 콘솔
		  
		   - 각 운영체제에 탑재되어 있는 글자만 나오는 화면
		   - Comman Line Interface (CLI <=> GUI)
		   
		  # 세미콜론(;)
		  
		   - 한 명령어가 끝났음을 컴파일러에게 알리는 문자
		*/
		System.out.println("Hello World!"); // Ctrl + F11
		/*
		 # ()안에 전달할 수 있는 자바의 데이터 종류(자바의 리터럴)
		 
		  1. "" 사이에 적는 것 : 문자열(Srting), 문자를 여러개 적을 수 있다
		  2. '' 사이에 적는 것 : 문자(Character), 문자를 하나만 적을 수 있다
		  3. 숫자를 적는 것 : 정수(Integer), 계산 가능
		  4. 소수를 적는 것 : 실수(Float, Double), 계산 가능
		  5. true 또는 false를 적는 것 : 참/거짓(Boolean)
		  6. 숫자 뒤에 L을 적는 것 : 아주 큰 정수들 (Long)
		*/
		System.out.println("안녕하세요, 반갑습니다~!!!");
		System.out.println('요');
		System.out.println(12345);
		System.out.println(123 + 456);
		System.out.println(123 * 45678);
		System.out.println(3.3333 * 99.99);
		System.out.println(true);
		System.out.println("true"); // 문자열
		System.out.println(false);
		System.out.println("false"); // 문자열
		
		// 문자열과 다른 타입을 + 하면 이어붙이기를 해준다 (결과는 문자열 타입)
		
		System.out.println("오늘의 메뉴 : " + "햄치즈볶음밥");
		System.out.println("가격 : " + 9800 * 3 + "원");
		System.out.println("가격 : " + 4000 + 4500 + "원"); // 앞에서부터 덧셈을함 문자열이 되어버림
		System.out.println("가격 : " + (4000 + 4500) + "원"); // 올바른 것은 아니지만 원하는 결과값은 출력함

		System.out.println("안경을 썼는가?" + true);
		System.out.println("밥값을 계산하였는가? " + true); // 예, 아니오 답변이 가능한 것에 사용
			
		// 필기 시에 원노트 활용해 볼 것
		// Win + Shift + s : 스크린샷 단축키		
		
		// 프로그램의 끝	
	}
	
}
