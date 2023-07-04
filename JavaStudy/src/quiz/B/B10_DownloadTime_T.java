package quiz.B;

import java.util.Scanner;

public class B10_DownloadTime_T {
	
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
		
		System.out.print("시간(초) >> ");
		int second = sc.nextInt();
		
		System.out.printf("%d초\n", second);
		
		int oneDay = 60 * 60 * 24;
		int oneHour = 60 * 60;
		int oneMinute = 60;
		
		if (second >= oneDay) {
			// 초가 1일 이상
			System.out.printf("%d일 %d시간 %d분 %d초\n",
					second / oneDay,
					second % oneDay / oneHour,
					second % oneHour / oneMinute,
					second % oneMinute);
		} else if (second >= oneHour) {
			// 초가 1시간 이상
			System.out.printf("%d시간 %d분 %d초\n",
					second / oneHour,
					second % oneHour / oneMinute,
					second % oneMinute);
		} else if (second >= oneMinute) {
			// 초가 1분 이상
			System.out.printf("%d분 %d초\n",
					second / oneMinute,
					second % oneMinute);
		} else {
			System.out.printf("%d초\n",
					second % oneMinute);
		}
		sc.close();
	}

}
