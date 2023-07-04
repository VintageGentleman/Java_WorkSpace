package quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class E01_InputRightThing {

	/*
	  	사용자로부터 스캐너의 nextInt()로 숫자를 입력받되
	  	숫자가 아닌 문자를 입력하더라도 다시 입력받을 수 있는 프로그램을 만들어보세요
	*/
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num;
		
		while(true) {
			try {
				System.out.print("숫자만 > ");
				num = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("다시");
				String trash = sc.nextLine();
				System.out.println(trash);
			}
		}
	
		System.out.println("숫자를 제대로 입력했습니다. " + num);
		sc.close();
	}
}
