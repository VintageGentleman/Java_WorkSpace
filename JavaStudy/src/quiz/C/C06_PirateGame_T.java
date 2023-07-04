package quiz.C;

import java.util.Scanner;

import myobj.Tong;

public class C06_PirateGame_T {
	
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
		Tong t = new Tong();
		
		int count = 0;
		while (true) {
			// 통의 현황을 보여주는 기능
			t.screen();
			
			System.out.printf("어디를 찌르실래요(%d회 생존) >> ", t.count);
			int num = sc.nextInt();
			
			// 통의 원하는 위치를 찌르는 기능 (승/패 여부 확인)
			t.stab(num);
			
			if (t.die) {
				System.out.println("아저씨는 " + count + "회 생존했습니다.");
				break;
			}
		}
		
		sc.close();
	}
}
