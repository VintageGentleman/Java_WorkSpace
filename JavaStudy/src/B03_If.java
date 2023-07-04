

import java.util.Scanner;

public class B03_If {

	/*
	  	# if문
	  	
	  	- ()안의 값이 true면 {}안의 코드를 실행하는 문법
	  	- ()안의 값이 false면 {}안의 코드를 무시한다
	  	
	  	# else if문
	  	
	  	- 위의 if문에서 조건이 맞지 않아 실행되지 않았다면 if문처럼 동작한다
	  	- else if는 여러번 사용할 수 있다
	  	- else if는 단독으로 사용할 수 있다
	  	
	  	# else문
	  	
	  	- 위의 if, else if가 모두 실행되지 않았을 때 {}안의 내용을 무조건 실행
	  	- if문 바로 다음에 사용할 수도 있다
	  	- if문 없이 단독으로 사용할 수 없다
	  	- else가 붙어있는 if문은 최소한 한 번은 반드시 실행된다
	*/
	
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("사과의 개수를 입력 > ");
		int apple = sc.nextInt();
		
		// true/false를 요구하는 ()안에 비교 연산을 넣어서 사용할 수 있다
		if(apple > 10) {
			System.out.println("너무 무거워요.");			
		} else if(apple < 0) {
			System.out.println("사과가 0보다 작을 수 없습니다");
		} else if(apple % 2 == 0) {
			System.out.println("사과의 개수가 10개 이하의 짝수입니다..");				
		} else{
			System.out.println("위의 조건을 모두 만족하지 못했습니다");		
		}
		
		int num;
		
		// if문에 else가 있어야 반드시 초기화 된다는 것이 보장된다
		if(apple == 7) {
			num = 0;			
		} else if (apple > 5) {
			num = 0;
		} else if (apple < 8) {
			num = 0;
		} else {
			num = 0;
		}
		
		System.out.println(num);
		
		System.out.println("프로그램 종료");
	
		sc.close();
	}

}
