package quiz.C;

import java.util.Arrays;
import java.util.Scanner;

public class C01_LottoGame_A {
	
	/*
	 	# 로또 게임 만들기
	 	
	 	1. 당첨 번호는 7개 매 판 무작위로 선정
	 	
	 	2. 플레이어는 번호 6개를 입력해 숫자를 맞춰야한다
	 	
	 	3. 1등, 앞에 6개의 숫자를 모두 맞춤 (+10억)
	 	   2등, 보너스 번호를 포함한 6개의 숫자를 모두 맞춤 (+1억)
	 	   3등, 5개의 숫자를 맞춤 (보너스 번호 미포함) (+1000만원)
	 	   4등, 4개의 숫자를 맞춤 (보너스 번호 미포함) (+100만원)
	 	   5등, 3개의 숫자를 맞춤 (보너스 번호 미포함) (+5000원)
	 	   
	 	4. 플레이어가 게임을 종료할때까지 게임이 계속 반복되어야 한다
	 	
	 	ex>
	 	 	1. 수동구매
	 	 	2. 자동구매
	 	 	3. 현재까지의 당첨금 확인
	 	 	   (현재 사용금액 현황, 당첨횟수, 손익계산)
	 	 	4. 게임종료
	 	 	>>   
	*/
	
	public static void menu() {
		System.out.println("=================================");
		System.out.println("1. 수동구매");
		System.out.println("2. 자동구매");
		System.out.println("3. 현재까지의 당첨금 확인");
		System.out.println("   (현재 사용금액 현황, 당첨횟수, 손익계산)");
		System.out.println("4. 게임종료");
		System.out.println("=================================");
		System.out.print(">> ");
	}
	
	public static int[] makeLotto(int num) {
		int[] lotto = new int[num];
		
		for (int i = 0; i < num; ++i) {
			int newNum = (int)(Math.random() * 45) + 1;
			for (int j = 0; j < i; ++j) {
				if (lotto[j] == newNum) {
					newNum = (int) (Math.random() * 45) + 1;
					j = -1;
				}
			}
			lotto[i] = newNum;
		}
		return lotto;
	}
	
	/**
	 * 1등부터 5등까지 각 등수별 상금과 당첨회수를 반환합니다.
	 * checkLotto[0]은 상금, checkLotto[1]은 당첨회수입니다.
	 * @param winNum = 로또 당첨번호 
	 * @param playersLotto = 당첨번호와 비교할 번호  
	 * @param bonusNum  = 보너스 번호
	 * @return
	 */
	public static int[][] checkLotto(int[] winNum, int[] playersLotto, int bonusNum) {
		int winCount = 0;
		boolean hasBonus = false;
		for (int i = 0; i < playersLotto.length; ++i) {
			hasBonus |= playersLotto[i] == bonusNum;
			
			for (int j = 0; j < winNum.length; ++j) {
				if (playersLotto[i] == winNum[j]) {
					++winCount;
				}
			}
		}
		
		int[] cash = new int[5];
		int[] prize = new int[5];
		
		if (winCount == 6) {
			System.out.println("====2등 당첨====");
			++prize[1];
			cash[1] += 100000000;
		} else if (winCount == 6 && !hasBonus) {
			System.out.println("=====1등 당첨=====");
			++prize[0];
			cash[0] += 1000000000;
		} else if (winCount == 5 && !hasBonus) {
			System.out.println("===3등 당첨===");
			++prize[2];
			cash[2] += 10000000;
		} else if (winCount == 4 && !hasBonus) {
			System.out.println("==4등 당첨==");
			++prize[3];
			cash[3] += 1000000;
		} else if (winCount == 3 && !hasBonus) {
			System.out.println("=5등 당첨=");
			++prize[4];
			cash[4] += 5000;
		} else {
			System.out.println("낙첨입니다");
		}
		
		int[][] result = {
				cash,
				prize,
		};
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int price = 1000;
		int buyCount = 0;
		int spent = 0;
		int[] prize = new int[5];
		int[] cash = new int[5];
		
		boolean running = true;
		while (running) {
			
			int[] winNum = makeLotto(7);
			int bonusNum = winNum[6];
			menu();
			
			int[] playersLotto = new int[6];
			
			switch (sc.nextInt()) {
			case 1:
				System.out.println("번호를 입력하세요(6개) (1~45 사이의 숫자) (중복X)");
				for (int i = 0; i < playersLotto.length; ++i) {
					int num = sc.nextInt();
					if (num >= 1 && num <= 45) {
						for (int j = 0; j < i; ++j) {
							if (playersLotto[j] == num) {
								System.err.println("중복된 숫자입니다. 다시 입력하세요");
								num = sc.nextInt();
								j = -1;
							}
						}
						playersLotto[i] = num;
					} else {
						System.err.println("범위 밖의 숫자입니다. 다시 입력하세요.");
						--i;
					}
				}
				System.out.println("당신의 로또 번호는" + Arrays.toString(playersLotto));
				++buyCount;
				spent += price;
				
				int[][] result = checkLotto(winNum, playersLotto, bonusNum);
				for (int i = 0; i < prize.length; ++i) {
					cash[i] += result[0][i];
					prize[i] += result[1][i];
				}
				break;

			case 2:
				System.out.print("구입할 회수를 입력하세요\n>> ");
				int num = sc.nextInt();
				for (int i = 0; i < num; ++i) {
					playersLotto = makeLotto(playersLotto.length);
					System.out.println("당신의 로또 번호는" + Arrays.toString(playersLotto));
					++buyCount;
					spent += price;
					
					result = checkLotto(winNum, playersLotto, bonusNum);
					for (int j = 0; j < prize.length; ++j) {
						cash[j] += result[0][j];
						prize[j] += result[1][j];
					}
				}
				break;
				
			case 3:
				int totalCash = 0;
				System.out.printf("총 구매회수 : %d\n", buyCount);
				System.out.printf("총 사용금액 : %d\n", spent);
				System.out.println("-- 당첨결과(등수별) --");
				for (int i = 0; i < prize.length; ++i) {
					System.out.printf("%d등 : %d회, %d원\n",
							i + 1, prize[i], cash[i]);
					totalCash += cash[i];
				}	
				System.out.printf("총 당첨금액 : %d원\n", totalCash);
				System.out.printf("손익 : %d원\n", totalCash - spent);
				break;
				
			case 4:
				running = false;
				System.out.println("프로그램을 종료합니다");
				break;
			}
 		}
		sc.close();
	}
}
