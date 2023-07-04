
public class B06_For {

	/*
	  	# 반복문 (Loop)
	  	
	  	- for, while, forEach, do-while(X)
	  	- 똑같은 코드를 여러번 반복하고 싶을 때 사용한다
	  	
	  	# for문
	  	
	  	  for (초기값; 반복조건; 증감값){
	  	   가운데의 반복 조건이 참인 동안 반복할 코드
	  	  }
	  	  
	  	- 초기값 : for문을 처음 시작하면 딱 한번 실행되는 장소. 주로 값을 초기화한다.
	  	- 반복조건 : 가운데의 반복 조건이 true인 동안 {}안의 내용을 계속 실행한다
	  			  가운데의 반복 조건이 false라면
	  			  {}안의 내용을 실행하지 않고 반복문을 끝낸다
	  	- 증감값 : {}안의 반복 내용을 모두 실행하고 나면 도착하는 장소.
	  			 주로 반복조건에 사용되는 값을 변화시키는 용도로 사용한다.
	*/
	
	public static void main(String[] args) {
		
		/*
		  	# {}와 들여쓰기
		  	
		  	- {} 내부에 포함된 내용은 1단계 더 들여쓰기 하여 작성한다
		  	- {}와 나란히 있는 내용은 같은 단계의 들여쓰기를 지닌다
		*/
		
		for (int i = 0; i < 10; ++i) {
			System.out.println(" /)/)");
			System.out.println("(  ..)");
			System.out.println("(  >$   " + i);
		}
		
		/*
			1. 가장 기본적인 for문
			
			- 초기값에 0을 주고, 조건에는 반복하고 싶은 횟수를 적는 방식
			- 증가는 1씩
			- 원하는 횟수만큼 반복하고 싶을 때 가장 많이 사용하는 형태
		*/
		
		for (int i = 0; i < 150; ++i) {
			System.out.println(i);
		}
		
		/*
		 	2. 초기값, 조건, 증감값을 자유롭게 설정한 for문
		 	
		 	- for문을 자유롭게 변경하여 용도에 맞게 사용할 수 있다
		 	- 증감값 자리에는 모든 연산을 사용할 수 있다
		*/
		
		for (int i = 7; i < 100000; i *= 7) {
			System.out.println(i);
		}
		
		for (int i = 1000; i > 0; --i) {
			System.out.println(i);
		}
		
		// Integer.MAX_VALUE == 2147483647
		
		// 2147480000 다음 계산이 최대값을 넘어감
		// -214748000 음수로 전환됨. 오버플로우 발생해서 계산이 다시 반복됨.
		
//		for (byte b = 0; b <= Byte.MAX_VALUE; b += 1) {
//			System.out.println(b);
//		}
		
		/*
		  	3. 각 자리에 값을 생략한 for문
		  	
		  	- 값을 넣지 않아도 for문은 돌아간다
		  	- 조건을 생략하면 무한 반복하게 된다
		  	- 값을 생략하더라도 ;;은 꼭 넣어야 한다
		*/
		
		for (int i = 0; i < 3 ; ++i) {
			System.out.println("Hello, world!" + i);
		}
	}
}
