package baekjoon;

import java.util.Scanner;

public class B03_FastAlarm_T {

	/*
	  	사용자로부터 시간과 분을 입력 받으면
	  	45분 이른 시간을 출력해주는 프로그램을 만들어보세요
	  	(단, 시간은 0 ~ 23 사이 분은 0 ~ 59 사이의 값이 입력되어야 한다)	  
	*/
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int hour = sc.nextInt();
		int minute = sc.nextInt();
		sc.close();
		
		minute = minute - 45;
		
		if (minute < 0) {
			hour = hour - 1;
			minute = minute + 60;
		}
		
		if (hour < 0) {
			hour = hour + 24;
		}
		
		System.out.printf("%d %d", hour, minute);
		
	}
}
