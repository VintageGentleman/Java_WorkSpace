package quiz.B;

import java.util.Scanner;

public class B04_MonthToSeason_T {

	/*
	  	사용자로부터 몇 월인지 입력받으면 해당하는 계절을 출력해보세요
	  	(switch-case문으로 한번, if문으로 한번)
	 
	*/
	
	public static void main(String[] args) {
		
		// 스캐너를 만든 후 변수에 저장하지 않으면 다시 쓸 수 없다
		Scanner sc = new Scanner(System.in);
	
		// 이렇게 만든 스캐너는 다시 재사용(reuse)할 수 없다
		// int value = new Scanner(System.in).nextInt();
		
		System.out.print("월을 입력 > ");
		int month = sc.nextInt();
		
		switch (month) {
			case 1: case 2: case 12: case 11:
				System.out.println("겨울");
				break;
			case 9: case 10:
				System.out.println("가을");
				break;
			case 8: case 7: case 6:
				System.out.println("여름");
				break;
			case 5: case 4: case 3:
				System.out.println("봄");
				break;				
			default:
				System.out.println("그런 월은 없습니다");
				break;
		}
		
		month = sc.nextInt();
		sc.close();
		
		if (month == 1 || month == 2 || month == 12 || month == 11) {
			System.out.println("겨울");
		} else if (month == 9 || month == 10) {
			System.out.println("가을");
		} else if (month >= 6 || month <= 8) {
			System.out.println("여름");
		} else if (month >= 3 || month <= 5) {
			System.out.println("봄");
		} else {
			System.out.println("그런 월은 없습니다.");
		}
		
	}
	
}
