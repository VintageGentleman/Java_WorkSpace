
public class C02_Overloading {
	
	/*
	  	# 함수(메서드) 오버로딩 (Overloading)
	  	
	  	- 같은 이름의 함수를 여러개 선언할 수 있는 문법
	  	- 매개 변수의 타입 또는 개수가 다르면 함수 이름이 같아도
	  	  각 함수를 구분할 수 있기 때문에 또 선언할 수 있다
	*/

	public static int add(int num1, int num2) {
		return num1 + num2;
	}
	
	// 리턴 타입으로는 오버로딩이 불가능하다
//	public static double add(int num1, int num2) {
//		return num1 + 3.3;
//	}
	
	// 매개변수의 개수가 다르면 같은 이름의 함수를 또 선언할 수 있다
	public static int add(int num1, int num2, int num3) {
		return num1 + num2 + num3;
	}
	
	// 매개변수의 개수가 똑같아도 타입이 다르면 같은 이름의 함수를 또 선언할 수 있다
	public static int add(double num1, double num2) {
		return (int)(num1) + (int)(num2);
	}
	
	public static void main(String[] args) {
		
		System.out.println(add(10.5, 11.5));
		
		add(11.5, 13.3);

	}

}
