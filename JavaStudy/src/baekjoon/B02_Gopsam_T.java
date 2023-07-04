package baekjoon;

import java.util.Scanner;

public class B02_Gopsam_T {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		
		int b1 = b / 100; // 몫만 구하므로 백의 자리 숫자가 나옴
		int b2 = b % 100 / 10; // 십의 자리 숫자를 구함
		int b3 = b % 10; // 일의 자리 숫자를 구함
		
		System.out.println(a * b3);
		System.out.println(a * b2);
		System.out.println(a * b1);
		System.out.println(a * b);
		
	}

}
