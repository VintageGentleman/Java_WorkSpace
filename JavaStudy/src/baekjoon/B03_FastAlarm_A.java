package baekjoon;

import java.util.Scanner;

public class B03_FastAlarm_A {

	/*
	  	사용자로부터 시간과 분을 입력 받으면
	  	45분 이른 시간을 출력해주는 프로그램을 만들어보세요
	  	(단, 시간은 0 ~ 23 사이 분은 0 ~ 59 사이의 값이 입력되어야 한다)	  
	*/
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		int m = sc.nextInt();
		sc.close();
		
		boolean valid = h >= 1 && h <= 23 && m >= 0 && m <= 59;
		boolean special = h >= 0 && h < 1 && m >= 0 && m < 45;
		boolean special2 = h >= 0 && h < 1 && m >= 45 && m <= 59;
		
		int time = (h * 60 + m) - 45;
		int time2 = (h * 60 + m) + 24 * 60 - 45;
		
		int h1 = time / 60;
		int m1 = time % 60;
		
		int h2 = time2 / 60;
		int m2 = time2 % 60;
		
		int h3 = h;
		int m3 = m - 45;
		
		if (valid) {
			System.out.printf("%d %d", h1, m1);
		} else if (special) {
			System.out.printf("%d %d", h2, m2);
		} else if (special2) {
			System.out.printf("%d %d", h3, m3);
		} else {
			System.out.println("23 15");
		}
	}
}
