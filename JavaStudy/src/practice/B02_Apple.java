package practice;

import java.util.Scanner;

public class B02_Apple {
	/*
		사과를 10개씩 담을 수 있는 바구니가 있을 때
		
		사용자가 사과의 개수를 입력하면 사과를 모두 담기 위해 필요한
		바구니의 개수를 알려주는 프로그램을 만들어보세요
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int appleCount = sc.nextInt();
		int basketSize = 10;
		int basketCount = appleCount % basketSize == 0 ?
				appleCount / basketSize : appleCount / basketSize + 1;  
		System.out.println(basketCount);
		
		sc.close();
	}
}
