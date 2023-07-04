package quiz.B;

import java.util.Scanner;

public class B03_ScoreToGrade_A {

	/*
	  	국어, 영어, 수학 점수를 차례대로 입력받아 평균 점수를 구한 후에
	  	각 과목의 점수와 등급, 평균 점수를 출력해주는 프로그램을 만들어보세요
	  	
	  	1. 90점 이상 A
	  	   80점 이상 B
	  	   70점 이상 C
	  	   60점 이상 D
	  	   그 외 F

	  	2. 각 과목의 유효한 점수는 0 ~ 100점이다
	  	   유효하지 않은 점수가 하나라도 있다면 모든 과목이 F이고 평균 점수는 0점
	  	   
	  	3. 평균 점수는 소수 둘째 자리에서 반올림하여 저장 후 출력(.2f를 쓰지 않아도 되도록)   
	*/
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 점수를 입력하세요 >");
		
		int korean = sc.nextInt();
		
		System.out.print("영어 점수를 입력하세요 >");
		
		int english = sc.nextInt();
		
		System.out.print("수학 점수를 입력하세요 >");
		
		int math = sc.nextInt();
		sc.close();
		
		double average = Math.round((korean + english + math) / 3.0
				* 100) / 100.0;
		
		if(korean < 0 || korean > 100) {
			System.out.println("국어 점수가 유효하지 않습니다. \n모든 과목 F, 평균 점수 0");
		} else if(english < 0 || english > 100) {
			System.out.println("영어 점수가 유효하지 않습니다. \n모든 과목 F, 평균 점수 0");
		} else if(math < 0 || math > 100) {
			System.out.println("수학 점수가 유효하지 않습니다. \n모든 과목 F, 평균 점수 0");
		} else {
		
			if(korean >= 90) {
				System.out.printf("국어 등급 > A, %d \n", korean);
			} else if(korean >= 80) {
				System.out.printf("국어 등급 > B, %d \n", korean);
			} else if(korean >= 70) {
				System.out.printf("국어 등급 > C, %d \n", korean);
			} else if(korean >= 60) {
				System.out.printf("국어 등급 > D, %d \n", korean);
			} else {
				System.out.printf("국어 등급 > F, %d \n", korean);
			}
			
			if(english >= 90) {
				System.out.printf("영어 등급 > A, %d \n", english);
			} else if(english >= 80) {
				System.out.printf("영어 등급 > B, %d \n", english);
			} else if(english >= 70) {
				System.out.printf("영어 등급 > C, %d \n", english);
			} else if(english >= 60) {
				System.out.printf("영어 등급 > D, %d \n", english);
			} else {
				System.out.printf("영어 등급 > F, %d \n", english);
			}
			
			if(math >= 90) {
				System.out.printf("수학 등급 > A, %d \n", math);
			} else if(math >= 80) {
				System.out.printf("수학 등급 > B, %d \n", math);
			} else if(math >= 70) {
				System.out.printf("수학 등급 > C, %d \n", math);
			} else if(math >= 60) {
				System.out.printf("수학 등급 > D, %d \n", math);
			} else {
				System.out.printf("수학 등급 > F, %d \n", math);
			}
			
			System.out.printf("평균 점수는 %s입니다", average);
			
		}
	}
}
