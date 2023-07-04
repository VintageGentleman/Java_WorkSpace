import java.util.Random;

public class B11_Random {
	
	/*
	  	#무작위 숫자 생성하기
	  	
	  	1. java.util.Random 클래스 사용하기
	  	
	  	2. Math.random() 함수 사용하기
	*/

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		// 새로운 랜덤 시드 생성(이 시점에서 랜덤이 이미 결정된다)
		Random ran1 = new Random();
		Random ran2 = new Random();
		
		// nextInt() : 랜덤 정수 생성
		for (int i = 0; i < 10; ++i) {
			System.out.println(ran1.nextInt());
		}
		
		// nextInt(bound) : 원하는 범위의 랜덤 정수를 생성 (0 ~ n-1)
		for (int i = 0; i < 20; ++i) {
			System.out.println(ran1.nextInt(10));
		}
		
		// nextInt()로 음수 포함하여 생성하기
		// (1) 원하는 숫자의 개수를 bound에 입력
		// (2) 원하는 숫자 중 가장 작은 수를 더하거나 빼면 원하는 범위를 설정할 수 있다
		System.out.println(ran1.nextInt(81) - 50); // -50 ~ +30
		System.out.println(ran1.nextInt(81) + 50); // +50 ~ +130
		
		// true와 false가 랜덤으로 나온다
		for (int i = 0; i < 10; ++i) {
			System.out.println(ran1.nextBoolean());
		}
		
		// Math.random() : 0 <= x < 1의 랜덤 실수를 생성한다
		for (int i = 0; i < 10; ++i) {
			System.out.println(Math.random());
		}
		
		/*
		  	# Math.random()으로 원하는 범위의 숫자 만들기
		  	
		  	(1) 원하는 숫자의 개수를 곱한다 (bound 역할)
		  		0 <= x < 1 * 20
		  		
		  	(2) 소수점 아래를 잘라 정수로 만든다
		  		(int 타입캐스팅 또는 Math.floor()를 사용)
		  		
		  	(3) 더하거나 빼서 원하는 범위를 만든다
		*/
		
		for (int i = 0; i < 10; ++i) {
			System.out.println((int)(Math.random() * 20) + 30);
		//	System.out.println(Math.floor(math.random() * 20) + 30);
		}
		
	}
}
