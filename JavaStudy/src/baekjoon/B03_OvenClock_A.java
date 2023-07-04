package baekjoon;

import java.util.Scanner;

public class B03_OvenClock_A {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		sc.close();
		
		B = B + C;
		
		if (C >= 60) {
			A = A + C / 60;
			B = B + C % 60 - C;		
		}
		
		if (B >= 60) {
			A = A + 1;
			B = B - 60;
		}
		
		if (A >= 24) {
			A = A - 24;
		}
		
		System.out.printf("%d %d", A, B);
		
	}
	
}
