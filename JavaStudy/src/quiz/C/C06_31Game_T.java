package quiz.C;

import java.util.Scanner;

import myobj.BaskinGame;

public class C06_31Game_T {
	
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
		
		BaskinGame game = new BaskinGame();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("몇인용 >> ");
		game.setAllPlayer(sc.nextInt());
		
		while(true) {
			game.screen();
			
			// 내가 입력할 수 있는 숫자의 범위를 벗어나면 다시 입력
			int select;
			while(true) {
				System.out.printf("[플레이어%d의 차례]\n"
						, game.getPlayer());
				System.out.printf("숫자를 고르세요 (%d ~ %d)>> "
						, game.getSelectAbleMinNum()
						, game.getSelectAbleMaxNum());
				select = sc.nextInt();
				
				if (game.checkSelectAbleNum(select)) {
					break;
				}
				System.out.println("다시 골라주세요!");
			}
			
			// 100% 올바른 숫자가 도착함
			boolean end = game.next(select);
			
			if (end) {
				System.out.printf("플레이어%d의 패배!!\n", game.getPlayer());
				break;
			}
		}
		
		sc.close();
	}

}
