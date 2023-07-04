package quiz.D;

import java.util.Scanner;

import blackjack.GameSystem;

public class D05_Blackjack_A {
	
	/*
	  	# www.247blackjack.com
	  	
	  	0. 배팅기능도 있어야함(1, 10, 100, 500)
	  	
	  	1. 컴퓨터(딜러)와 사람(플레이어)가 카드를 뽑는다.
	  	
	  	2. 처음에는 둘 모두 2장씩 받는다. 이 때 딜러의 카드는 한장 가려놓는다.
	  	
	  	3. 플레이어는 카드를 받은 후 상황을 보고 
	  	   더 뽑을지(hit) 그만 뽑고 여기서 멈출지(stand)를 결정한다.
	  	   hit를 선택하면 플레이어만 카드를 한 장 더 받는다.
	  	
	  	4. 플레이어가 stand를 선택하면 정해진 규칙에 따라 딜러가
	  	   뒤집어놨던 카드를 오픈하고 카드를 마저 뽑는다.
	  	   딜러는 의사 결정을 할 수 없고 정해진 규칙에만 따라야 한다.
	  	   
	  	   ※ 딜러의 규칙 - 가진 카드 합이 16이하라면 뽑는다. 17이상이면 멈춘다.
	  	   
	  	5. A는 1로 쓸 수도 있고 11로 쓸 수도 있다.
	  	   (A는 11의 가치를 가지고 있다가 들고있는 채로 버스트를 당하면 1로 바뀐다)
	  	
	  	6. J, Q, K는 모두 10의 가치를 지닌다.
	  	
	  	7. 가진 카드의 합이 21을 넘으면 버스트 (무조건 패배)
	  	   플레이어가 버스트를 당하면 딜러는 카드를 뽑지도 않고 승리한다.
	  	 
	  	8. 합이 21이면 Blackjack 
	  	   
	  	9. 동점이면 배팅금을 다음 게임으로 이월시킨다.
	*/
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GameSystem gm = new GameSystem();
		
		while(gm.isPowerOn()) {
			gm.startGame();
			
			int select;
			while(true) {
				gm.bettingNotice();
				select = sc.nextInt();
				if(select == 1 || select == 2 || select == 3 || select == 4) {
					break;
				}
			}
			
			gm.bettingPhase(select);
			if(!gm.isPowerOn()) {
				break;
			}
			
			while(gm.isDrawTurn()) {
				gm.drawNotice();
				gm.drawPhase(sc.nextInt());
			}
			
			gm.conclusionPhase();
			gm.allocationPhase();
			
			int select2;
			while(true) {
				gm.noticeCheckRestartGame();
				select2 = sc.nextInt();
				if(select2 == 1 || select2 == 2) {
					break;
				}
			}
			gm.checkRestartGame(select2);
		}
		
		sc.close();
	}
}
