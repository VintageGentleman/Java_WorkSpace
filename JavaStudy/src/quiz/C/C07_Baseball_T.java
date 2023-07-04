package quiz.C;

import java.util.Scanner;

import myobj.Baseball;

public class C07_Baseball_T {
	
	/*
  		# 숫자 야구 게임
  	
	  	- 게임이 시작되면 정답이 랜덤으로 생성된다
	  	- 정답은 랜덤 4자리의 중복없는 숫자
	  	- 플레이어에게는 9번의 기회가 주어지며 4자리의 숫자를 마음대로 입력할 수 있다
	  	- 플레이어가 입력한 숫자의 번호와 위치가 모두 맞으면 스트라이크라고 한다
	  	- 플레이어가 입력한 숫자의 번호는 맞되 위치가 틀리면 볼이라고 한다
	  	- 플레이어가 9번의 기회 안에 모든 숫자와 위치를 맞추면 사용자의 승리
	  	- 모든 기회 소진시 플레이어 패배
	  	
	  	ex> 정답이 3791인 경우
	  	
	  		사용자 - 9081이라고 입력하면 1strike 1ball
	*/

	public static void main(String[] args) {
		Baseball game = new Baseball();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자 야구 시작!!");
		
		while(!game.isEnd()) {
			
			System.out.printf("숫자 4개 (기회: %d) >> ", game.chance);
			
			String number = sc.nextLine();
			
			if(Baseball.isBaseballGameString(number)) {
				int[] count = game.check(number);
				System.out.printf("%dstrike %dball\n", count[0], count[1]);
			} else {
				System.out.println("올바른 숫자를 입력해주세요...");
			}
		}
		
		System.out.printf("게임이 끝났습니다. 플레이어의 %s입니다.", game.result);
		sc.close();
	}

}
