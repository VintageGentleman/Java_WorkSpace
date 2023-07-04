package quiz.B;

import java.util.Scanner;

public class B11_Updown {

	/*
	  	# Updown 게임을 만들어보세요
	  	
	  	1. 게임이 시작되면 1 ~ 100 사이의 랜덤 숫자를 정답으로 선택한다
	  	
	  	2. 사용자가 숫자를 입력하면 Up인지 Down인지 알려준다
	  	
	  	3. 만약 사용자가 범위를 벗어나는 숫자를 입력했다면
	  	   기회를 소진하지 않고 다시 입력할 수 있어야 한다
	  	 
	  	4. 5번 안에 못맞추면 정답이 뭐였는지 출력해주고 프로그램을 종료한다
	  	
	  	5. 또는 사용자가 정답을 맞추면 몇 번만에 맞췄는지 출력해주고 프로그램을 종료한다
	*/
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Game Start");
		
		int random = (int)(Math.random() * 100) + 1;
		int chance = 5;
		
		while (chance != 0) {
			
			System.out.print(">> ");
			
			int answer;
			while((answer = sc.nextInt()) < 1 || answer > 100) {
				System.err.println("범위를 벗어나는 숫자입니다. 재입력하세요");
			}
			
			--chance;
			
			if (answer == random) {
				System.out.printf("정답입니다. 시도 회수 : %d번\n", 5 - chance);
				break;
			} else if (answer < random) {
				System.out.println("UP");
			} else {
				System.out.println("DOWN");
			}
		}
		System.out.println("정답은 " + random + "입니다.");
		sc.close();
	}

}
