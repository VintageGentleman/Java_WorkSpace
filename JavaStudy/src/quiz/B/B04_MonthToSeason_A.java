package quiz.B;

import java.util.Scanner;

public class B04_MonthToSeason_A {

	/*
	  	사용자로부터 몇 월인지 입력받으면 해당하는 계절을 출력해보세요
	  	(switch-case문으로 한번, if문으로 한번)
	 
	*/
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("month > ");
		
		int month = sc.nextInt();
		sc.close();
		
		switch(month){
		case 1: case 2: case 12:
				System.out.println("겨울");
				break;
		case 3: case 4: case 5:
			System.out.println("봄");
			break;		
		case 6: case 7: case 8:
			System.out.println("여름");
			break;	
		case 9: case 10: case 11:
			System.out.println("가을");
			break;	
		default:
			System.out.println("잘못된 입력입니다");
			break;				
		}
		
		if(month >= 3 && month <= 5) {
			System.out.println("봄");
		} else if(month >= 6 && month <= 8) {
			System.out.println("여름");
		} else if(month >= 9 && month <= 11) {
			System.out.println("가을");
		} else if(month == 12 || month == 1 || month == 2) {
			System.out.println("겨울");
		} else {
			System.out.println("잘못된 입력입니다");
		}	
		
	}
	
}
