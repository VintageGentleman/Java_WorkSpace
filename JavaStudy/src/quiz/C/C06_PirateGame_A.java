package quiz.C;

import java.util.Scanner;

import myobj.Pirate;

public class C06_PirateGame_A {
	
	/*
	  	통아저씨 게임을 만들어보세요
	  	
	  	(1) 게임이 시작되면 꽝 자리가 정해진다
	  	
	  	(2) 플레이어는 아저씨가 발사될때까지 계속 자리를 선택해야 한다
	  	
	  	(3) 칼을 찌를 수 있는 홈은 20개가 있고 그 중 4개가 꽝이 된다
	  	    (꽝의 위치는 매 판마다 랜덤으로 재설정되어야 한다)
	  	    
	  	(4) 아저씨가 발사되면 몇 번만에 발사되었는지 알려주는 메세지가 나온다   
	*/

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Pirate pirate = new Pirate(4);
		
		System.out.println("게임 시작");
		while (pirate.alive) {
			pirate.viewScreen();
			System.out.print("어디를 찌를까요?(0 ~ 19)\n>> ");
			pirate.pokeSpot(sc.nextInt());
		}
		System.out.println(pirate.count + "번만에 성공했습니다");
		pirate.getBoomSpot();
		sc.close();
	}
}
