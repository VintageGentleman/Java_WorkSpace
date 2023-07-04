package quiz.B;

import java.util.Scanner;

public class B06_ForQuiz2_T {

	/*
	  	사용자로부터 숫자를 입력받으면
	  	0부터 해당 숫자 사이에 존재하는 모든 5의 배수를 한 줄에 10개씩 출력해보세요
	  	(단, 음수를 입력 받는 경우에도 올바르게 동작해야 합니다)
	*/
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("input number > ");
		int num = sc.nextInt();
		sc.close();
		
		boolean minus = num < 0;
		
		num = Math.abs(num);
		
		// 숫자의 자리수 구하기
		int size = 0;
		
		for (int i = num; i > 0; i/=10) {
			++size;
		}
		
		for (int i = 0, count = 1; i <= num; ++i) {
			
			if(i % 5 == 0) {
				if (!minus) {
					System.out.printf("%" + size + "d ", i);
				} else if(minus && i != 0) {
					System.out.printf("-%" + size + "d ", i);
					// System.out.printf("%d ", -i);
				} else {
					System.out.printf("%" + (size + 1) + "d ", i);
				}
				
				if (count++ == 10) {
					System.out.println();
					count = 1;
				}				
			}			
		}		
	}
}
