package quiz.B;

import java.util.Scanner;

public class B03_AppleQuiz_T {
	
	/*
		사과를 10개씩 담을 수 있는 바구니가 있을 때
	
	  	사용자가 사과의 개수를 입력하면 사과를 모두 담기 위해 필요한
	  	바구니의 개수를 알려주는 프로그램을 만들어보세요
	*/
	
	public static void main(String[] args) {
		
		int basketSize = 10;
		int appleQty;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("사과의 개수? ");
		appleQty = sc.nextInt();
		sc.close();
		
		// 잘못된 값을 위에서 먼저 체크한 후에 하고 싶은 일을 하는 것이 좋다
		if (appleQty < 0) {
			System.out.println("사과의 개수가 이상합니다... 프로그램을 종료합니다.");		
		} else {
			System.out.printf("필요한 바구니의 개수는 모두 %d개 입니다. \n",
					(int)Math.ceil(appleQty / (double)basketSize));
			/*
			  	(1) 사과의 개수와 바구니의 크기를 나눈다
			  	
			  	(2) 정수끼리 나누면 몫만 구하므로 하나를 double로 바꾼다
			  		Math.ceil(31 / 10) => Math.ceil(3) => 3개 필요
			  		Math.ceil(31 / 10.0) => Math.ceil(3.1) => 4개 필요
			  	
			  	(3) Math.ceil() 함수의 실행 결과는 double타입이므로
			  		%d로 출력하기 위해서 결과를 다시 int타입으로 변환한다
			*/
		}
		/*
		  else if (appleQty % basketSize != 0){
			 // 바구니에 담은 후 남는 사과가 있는 경우
			System.out.printf("필요한 바구니의 개수는 모두 %d개 입니다. \n",
					appleQty / basketSize + 1);
		} else {
			System.out.printf("필요한 바구니의 개수는 모두 %d개 입니다 \n",
					appleQty / baksetSize);
		}
		*/
	}

}
