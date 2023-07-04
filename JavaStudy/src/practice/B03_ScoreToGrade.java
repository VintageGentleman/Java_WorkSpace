package practice;

import java.util.Scanner;

public class B03_ScoreToGrade {
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
	static class Subject {
		String name;
		int score;
		boolean validScore = true;
		char grade;
		
		public Subject(String name, int score) {
			this.name = name;
			this.score = score;
			setGrade();
		}
		
		private void setGrade() {
			if(score < 0 || score > 100) {
				grade = 'F';
				validScore = false;
			} else {
				if(score >= 90) {
					grade = 'A';
				} else if(score >= 80) {
					grade = 'B';
				} else if(score >= 70) {
					grade = 'C';
				} else if(score >= 60) {
					grade = 'D';
				} else {
					grade = 'F';
				}
			}
		}
		
		public int getScore() {
			return score;
		}

		public boolean isValidScore() {
			return validScore;
		}
		
		public void detectError() {
			grade = 'F';
			score = 0;
		}
		
		@Override
		public String toString() {
			return String.format("%s / %d / %c", name, score, grade);
		}
		
		public static double calAvgScore(Subject[] arr) {
			double total = 0;
			for(int i = 0; i < arr.length; ++i) {
				total += arr[i].getScore();
			}
			return Math.round(total / arr.length * 100) / 100.0;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Subject[] subject = new Subject[3];
		
		for(int i = 0; i < subject.length; ++i){
			System.out.print("과목명과 점수 입력\n");
			String name = sc.next();
			int score = sc.nextInt();
			subject[i] = new Subject(name, score);
		}
		sc.close();
		
		for(int i = 0; i < subject.length; ++i){
			if(!subject[i].isValidScore()) {
				for(int j = 0; j < subject.length; ++j) {
					subject[j].detectError();
				}
				System.out.println("유효하지 않은 점수가 포함되어 있습니다.");
				break;
			}
		}
		
		System.out.println("평균점수 : " + Subject.calAvgScore(subject));
		
		for(int i = 0; i < subject.length; ++i) {
			System.out.println(subject[i]);
		}
	}
}
