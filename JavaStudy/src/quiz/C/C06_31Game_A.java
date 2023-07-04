package quiz.C;

import java.util.Scanner;

import myobj.Game31;

public class C06_31Game_A {
	
	/*
	  	# 31 Game
	  	
	  	1. 처음에 게임에 참여하는 인원을 설정한다
	       (최소 2명 이상)
	       
	    2. 이전 사람이 골랐던 숫자로부터 +1 ~ +3의 숫자까지
	       입력할 수 있어야 한다
	       (숫자를 처음 부르는 사람도 1 ~ 3 중에 골라야 한다)
	    
	    3. 31을 말하게 되는 사람이 패배한다
	*/

	public static void main(String[] args) {
		
		Game31 play = new Game31();
		
		Scanner sc = new Scanner(System.in);
		
		play.startNotice();
		while(play.player < 1) {
			play.settingPlayer(sc.nextInt());
		}
		
		while (play.running) {
			play.notice();
			int num = sc.nextInt();
			play.numberCheck(num);
		}
		
		System.out.println("게임 끝");
		sc.close();
	}

}
