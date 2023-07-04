package quiz.A;

public class A03_Personalinfo_T {

	/*
	  	Q. 선생님 복습을 어떤 식으로 해야할까요?

	  	A. 문제의 답을 지우고 다시 풀어보는 것이 좋다.
	  	복습은 복기하는 방식으로 하는 것이 좋다. 놓친 것이 무엇이었는지.
	*/
	
	public static void main(String[] args) {
		
		// 요즘은 메모리 용량이 넉넉하기 때문에 메모리 절약을 위한 선택은 거의 하지 않는다
		String title = "출력 결과";
		String name = "홍길동";
		int age = 20;
		String tel = "010-1234-1234";
		double height = 178.5;
		double weight = 75;		// 소수점 단위까지 쓰일수 있기 때문에 정수 대신 실수 타입 사용
		String bloodType = "O";	// AB형을 염두해두고 char가 아닌 String 타입 사용
		
		System.out.println("==========" + title + "==========");
		System.out.println("이름\t: " + name);
		System.out.println("나이\t: " + age);
		System.out.println("Tel\t: " + tel);
		System.out.println("키\t: " + height);
		System.out.println("몸무게\t\t: " + weight);
		System.out.println("혈액형\t\t: " + bloodType);
		
		// 정수 앞에 0b를 붙이는 것은 2진수로 인식한다
		// 정수 앞에 0을 붙이는 것은 8진수로 인식한다
		// 정수 앞에 0x를 붙이는 것은 16진수로 인식한다
//		int tel1 = 010; // 8진수로 인식해서 8로 나온다
//		int tel2 = 1234;
//		int tel3 = 1234;
		
	}
}
