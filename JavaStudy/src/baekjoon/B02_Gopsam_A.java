package baekjoon;

import java.util.Scanner;

public class B02_Gopsam_A {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int C = A*(B % 10);
		int D = A*(B % 100 / 10);
		int E = A*(B / 100);
		
		int F = A * B;
		
		System.out.println(C);
		System.out.println(D);
		System.out.println(E);
		System.out.println(F);
	
		sc.close();
	}
	
}
