package quiz.B;

import java.util.Scanner;

public class B09_Prime {
	
	/*
	  	사용자가 숫자를 입력하면
	  	1부터 입력한 숫자 사이에 존재하는 모든 소수를 출력해보세요
	  	
	  	>> 10
	  	2, 3, 5, 7
	  	
	  	>> 20
	  	2, 3, 5, 7, 11, 13, 17
	  	
	  	※ 소수(Prime) : 나누어 떨어지는 수가 1과 자기 자신밖에 없는 수
	  	※ 사용자가 1이하의 정수를 입력하는 경우 다시 입력하게 만들 것
	*/

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 >> ");
		
		int num;
		for (num = sc.nextInt(); num < 2; num = sc.nextInt());
		
		/*
		  	다른 형태의 재입력 반복문
		  	int num;
		  	for (;(num = sc.nextInt()) < 2;);
		*/
		
		sc.close();
		
		System.out.println("=== 소수 계산 ===");
		
		for (int target = 2; target <= num; ++target) {
			
			System.out.printf("이번에 소수인지 검사해야 하는 숫자: %d\n", target);
			
			boolean sosu = true;
			
			double targetRoot = Math.sqrt(target);
			
			// 2부터 target의 제곱근까지 나누면서 약수가 하나라도 존재하면 소수가 아니다
			for (int divider = 2; sosu && divider <= targetRoot; ++divider) {
				sosu &= target % divider != 0;
			}
			
			if (sosu) {
				System.out.printf("%d(sosu). \n", target);
			} else {
				System.out.printf("%d(sosu). \n", target);
			}
			
//			int yaksuCount = 0;
//			
//			// target을 1부터 자기 자신까지의 숫자로 나눠본다
//			for (int divider = 1; divider <= target; ++divider) {
//				System.out.printf("%d %% %d = %d\n",
//						target, divider, target % divider);
//				
//				if (target % divider == 0) {
//					++yaksuCount;
//				}
//			}
//			
//			// 검사가 끝났을 때 약수가 2개인 숫자가 소수다
//			if (yaksuCount == 2) {
//				System.out.printf("%d은 소수입니다 \n", target);
//			}
					
		}
		
	}
}
