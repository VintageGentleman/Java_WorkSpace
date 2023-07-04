package quiz.B;

import java.util.Scanner;

public class B00_AgeCalculater_A {

	/*
	  	사용자가 태어난 해를 입력하면 한국 나이를 알려주는 프로그램을 만들어보세요
	*/
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);	
		
		System.out.print("태어난 해를 입력해주세요 > ");		

		int birthyear = sc.nextInt();
		int presentyear = 2023;
		
		System.out.printf("%d년도에 태어난 사람은 %d년도에 한국나이로 %d살입니다"
				, birthyear, presentyear, presentyear - birthyear + 1);
		
		sc.close();
	}
}
