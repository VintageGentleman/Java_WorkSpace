package quiz.D;

import java.util.Scanner;

import blackjack2.Deck;
import blackjack2.Player;

public class D05_Blackjack_T {
	public static void main(String[] args) {
		Deck deck = new Deck();
		
		Player player = new Player();
		Player dealer = new Player();
		
		player.plusMoney(2500);
		
		Scanner sc = new Scanner(System.in);
		
		int betMoney = 0;
		
		while(true) {
			boolean playerBust = false;
			
			// 베팅 금액 설정
			while(betMoney < 1) {
				System.out.print("베팅 금액을 설정해주세요 : ");
				betMoney = sc.nextInt();
			}
			
			// 딜러에게 2장
			dealer.addCard(deck.getCard());
			dealer.addCard(deck.getCard());
			dealer.reverse(1);
			
			// 플레이어에게 2장
			player.addCard(deck.getCard());
			player.addCard(deck.getCard());
		
			while(true) {
				System.out.println("현재 남은 금액: " + player.getMoney());
				System.out.println("현재 베팅 금액: " + betMoney);
				
				System.out.println("딜러: ");
				dealer.printCardsWithNoValue();
				
				System.out.println("플레이어: ");
				player.printCards();
				
				System.out.println("1. Hit\t2. Stand");
				int select = sc.nextInt();
				
				if(select == 1) {
					player.addCard(deck.getCard());
					
					if(player.getValue() > 21) {
						System.out.println("플레이어: ");
						player.printCards();
						System.out.println("플레이어의 버스트로 패배입니다.");
						playerBust = true;
						break;
					}
				} else if(select == 2) {
					break;
				} else {
					System.out.println("잘못 고르셨습니다. 다시 고르세요.");
				}
			}
			
			dealer.reverse(1);
			
			// 플레이어의 버스트로 탈출하거나, 스탠드로 탈출하거나
			if(playerBust) {
				// 돈계산
				player.minusMoney(betMoney);
			} else {
				// 딜러의 카드 뽑기
				while(dealer.getValue() < 17) {
					dealer.addCard(deck.getCard());
				}
				
				// 계산 시작하기전에 한 번 더 출력
				System.out.println("딜러: ");
				dealer.printCards();
				
				System.out.println("플레이어: ");
				player.printCards();
				
				int dealerScore = dealer.getValue();
				int playerScore = player.getValue();
				
				if(dealerScore > 21) {
					System.out.println("딜러의 버스트");
					player.plusMoney(betMoney);
					betMoney = 0;
				} else if(dealerScore == playerScore) {
					System.out.println("비김");
					// 비겼을 때는 베팅금액 유지 (추가 가능)
					System.out.println("[INFO] 베팅 금액이 그대로 유지됩니다.");
					int additional = 0;
					while(additional < 1) {
						System.out.print("추가 베팅 금액 : ");
						additional += sc.nextInt();
					}
					betMoney += additional;
				} else if(dealerScore > playerScore) {
					System.out.println("딜러 승");
					player.minusMoney(betMoney);
					betMoney = 0;
				} else if(dealerScore < playerScore) {
					System.out.println("플레이어 승");
					player.plusMoney(betMoney);
					betMoney = 0;
				}	
			}
			// 카드 초기화
			player.reset();
			dealer.reset();

			System.out.println("----------------------------");
			System.out.println("더 하시겠습니까? 1.더한다 2.그만한다");
			System.out.print(">> ");
			int select = sc.nextInt();
			System.out.println("----------------------------");
			
			if(select == 2) {
				System.out.println(player.getMoney() + "원으로 마무리 되었습니다.");
				System.out.println("감사합니다.");
				break;
			}
			
		}

		sc.close();
	}
}
