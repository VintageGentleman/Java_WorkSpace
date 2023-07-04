
public class A02_Variable {

	/*
	  # 변수 (Variable)
	  
	   - 프로그래밍 언어에서 데이터를 저장해 둘 수 있는 공간
	   - 변수에 어떤 데이터를 보관할 것인지 타입을 지정해야 한다
	   - 값을 한 번도 대입한 적 없는 변수는 사용하려고 하면 에러가 발생한다
	   (초기화 하지 않은 변수는 사용할 수 없다)	 
	  
	  # 변수의 선언(declare)
	  
	  * 타입 변수명;
	  
	   - 해당 변수에 어떤 타입의 데이터를 저장할 것인지 결정한다
	   - 변수명에는 사용하고 싶은 이름을 적는다
	   - 변수를 선언할 때 같은 {} 내부에서 같은 이름의 변수를 다시 선언할 수 없다
	   
	  # 대입 연산 (=)
	  
	   - 원래 알고 있던 =의 의미 : 왼쪽과 오른쪽의 값이 같다 (비교)
	   - 프로그래밍 언어에서 =의 의미 : 왼쪽의 변수에 오른쪽의 값을 넣어라 (대입)
    */

	public static void main(String[] args) {
		String text = "I like pizza";
		String text2 = text;
		
		// 이미 값이 있는 변수에 대입하면 내용을 덮어쓴다
		text = "apple";
		
		// 변수에 String만 담기로 했는데 약속을 어기면 에러가 발생한다
		text = "123";
		
		System.out.println(text); // 변수에 담긴 값을 출력
		System.out.println(text2);
		
		// String : 이 변수에는 문자열만 담겠다
		// int : 이 변수에는 정수만 담겠다
		
		// 초기화(X), 값을 한 번도 대입하지 않음
		int apple;
		
		apple = 10; // 나중에 하는 초기화도 초기화로 인정된다
		
		System.out.println(apple);// 초기화 하지 않은 변수는 사용할 수 없다
		
		// 변수를 선언하는 여러 방식들
		
		// (1) 선언과 동시에 대입		
		int x = 10;
		
		// (2) 선언만 하는 경우 (초기화 하지 않음)
		String Str;
		
		// (3) 한번에 여러 변수를 선언하기 (같은 타입만 가능)
		int a1, a2, a3;
		
		// (4) 한번에 여러 변수 선언과 동시에 대입		
		String s1 = "dog", s2 = "cat", s3 = "lion";
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		// {} 내부에서는 같은 변수 이름을 쓸 수 없다
		{
			String menu = "짬뽕";
			
			System.out.println(menu);
		}
		
		// {} 를 벗어나면 {} 내부의 변수는 모두 사라진다(release)
		// {} 내부의 변수엔 menu가 사라졌기 때문에 다시 menu라는 변수명을 사용할 수 있다
		String menu = "짜장면";
		
		System.out.println(menu);		
		
		Str = "10";	a1 = 1; a2 = 2; a3 = 3;
		System.out.println(x + Str + a1 + a2 + a3);
	}
}
