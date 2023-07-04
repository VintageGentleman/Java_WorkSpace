import java.util.Arrays;

public class C07_ReferencesDataType {
	
	/*
	  	# 기본형 데이터 타입
	  	
	  	- int, float, short, double, boolean, ... 등 소문자로 시작하는 타입들
	  	- 기본형 데이터 타입 변수에는 실제 값이 저장된다
	  	- 기본형 데이터 타입에는 .을 찍어 사용할 수 없다
	  	
	  	ex) 3.length(); <- [X]
	  	
	  	# 참조형 데이터 타입
	  	
	  	- String
	  	- 배열
	  	- 모든 클래스들
	  	- 참조형 데이터 타입의 변수에는 주소값이 저장된다
	  	- 참조형 데이터 타입에는 .을 찍어 저장된 주소를 참조할 수 있다
	*/

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		String str1 = new String("apple");
		String str2 = "apple";
		
		// 배열 타입 변수에는 해당 배열의 맨 앞(index 0번)의 주소가 들어있다
		int[] numbers = new int[] {1, 2, 3, 4, 5};
		
		// 모든 클래스는 데이터 타입이다..
		// Apple 타입 인스턴스(실체의 주소)를 Apple 타입 변수에 담을 수 있다
		Apple a1 = new Apple();
		
		// 기본형 변수타입의 대입은 값을 옮기는 것이기 때문에
		// 같은 실체를 참조하는 것이 아니다
		int a = 10;
		int b = a;
		
		a = 99;
		
		System.out.println("b: " + b);
		
		// 참조형 변수타입은 주소값을 옮기는 것이기 때문에 
		// 같은 실체를 참조하게 된다
		int[] numbers2 = numbers;
		Apple a2 = a1;
		
		numbers2[2] = 99;
		a2.price = 99;
		a2.taste = 100;
		
		System.out.println(Arrays.toString(numbers));
		System.out.println(a1.price + ", " + a1.taste);
		
		// 이러한 특징은 다른 함수의 매개변수로 전달될 때에도 다른 결과를 초래한다
		
		// 기본형 테스트
		int test = 5;
		plusPrimitive(test);
		System.out.println(test);
		
		// 참조형 테스트
		int[] tests = {5, 5, 5, 5, 5};
		plusReferences(tests);
		System.out.println(Arrays.toString(tests));
		
		Apple a3 = new Apple();
		
		a3.price = -5;
		a3.taste = 9;
		
		changeApple(a3);
		
		System.out.println(a3.price);
		System.out.println(a3.taste);
	}
	
	// 매개변수에 기본형 변수 타입을 활용할 때에는 값이 전달된다 (같은 실체를 참조하지는 않음)
	public static void plusPrimitive(int num) {
		num = num + 100;
	}
	
	// 매개변수에 참조형 변수 타입을 활용할 때에는 주소값이 전달된다 (같은 실체를 참조함)
	public static void plusReferences(int[] nums) {
		nums[0] += 100;
		nums[1] -= 50;
	}
	
	public static void changeApple(Apple apple) {
		apple.price = 99999;
		apple.taste = 99999;
	}
}
