package quiz.B;

import java.util.Scanner;

public class B10_DownloadTime_A {
	
	/*
	  	다운로드에 필요한 시간이 초 단위로 입력된다면
	  	몇일 몇시간 몇분 몇초 남았는지 환산하여 출력해보세요
	  	(단, 필요 없는 단위는 출력하지 않아야 한다)
	  	
	  	>> 600
	  	-> 10분 0초
	  	
	  	>> 86450
	  	-> 1일 0시간 0분 50초
	*/

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int time = sc.nextInt();
		
		int day = 0;
		int hour = 0;
		int minute = time / 60;
		int second = time % 60;
		
		if (minute >= 60) {
			hour += minute / 60;
			minute = minute % 60;
		}
		
		if (hour >= 24) {
			day += hour / 24;
			hour = hour % 24;
		}
		
		
		if (day > 0) {
			System.out.printf("%d일 %d시간 %d분 %d초",
					day, hour, minute, second);
		} else if (hour > 0) {
			System.out.printf("%d시간 %d분 %d초",
					 hour, minute, second);
		} else if (minute > 0) {
			System.out.printf("%d분 %d초",
					  minute, second);
		} else {
			System.out.printf("%d초", second);
		}
		sc.close();
	}
}
