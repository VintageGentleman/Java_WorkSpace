package quiz.C;

import java.util.Arrays;
import java.util.Scanner;

public class C01_LottoGame_T {
	
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
	
	/** 원하는 길이의 중복없는 랜덤 숫자 배열을 생성하는 함수 */
	public static int[] getRandomNumbers(int len) {
		int[] arr = new int[len];
		for (int i = 0; i < arr.length; ++i) {
			arr[i] = (int)(Math.random() * 45) +1;
			for (int j = 0; j < i; ++j) {
				if (arr[i] == arr[j]) {
					--i;
					break;
				}
			}
		}
		return arr;
	}
	
	/** 당첨 번호와 사용자의 번호를 비교해 몇 등인지 알려주는 함수 */
	public static int getRank(int[] winNum, int[] userNum) {
		boolean bonus = false;
		int count = 0;
		
		for (int i = 0; i < userNum.length; ++i) {
			for (int j = 0; j < winNum.length; ++j) {
				// 사용자의 번호와 당첨 번호가 일치하는 경우 count 1증가
				if (userNum[i] == winNum[j]) {
					++count;
					// 일치하는 와중에 j가 6이면 (보너스 번호)가 있다고 표시
					if (j == 6) {
						bonus = true;
					}
					break;
				}
			}
		}
		
		if (bonus) {
			if (count == 6) {
				return 2;
			} else if (count == 5) {
				return 4;
			} else if (count == 4) {
				return 5;
			}
		} else {
			if (count == 6) {
				return 1;
			} else if (count == 5) {
				return 3;
			} else if (count == 4) {
				return 4;
			} else if (count == 3) {
				return 5;
			}
		}
		// 함수는 반드시 리턴을 해야하기 때문에
		// 아무 조건에도 걸리지 않는 경우에 대한 리턴도 반드시 있어야 한다
		return 0; // 0은 당첨x로 여기겠다
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int buyCount = 0; // 구매 회수
		int[] winCount = new int[6]; // 0등, 1등, 2등, 3등, 4등, 5등 회수 저장
		
		// 각 등수마다 받게되는 상금을 저장
		int[] winMoney = {0, 1000000000, 70000000, 1500000, 50000, 5000};
		
		while (true) {
			int[] winNum = getRandomNumbers(7);
			
			System.out.print("1. 수동구매\n"
					+ "2. 자동구매\n"
					+ "3. 현재까지의 당첨금 확인\n"
					+ "(현재 사용금액 현황, 당첨횟수, 손익계산)\n"
					+ "4. 게임종료\n>> ");
			int select = sc.nextInt();
			
			if (select == 4) {
				break;
			} else if (select == 1) {
				int[] userNum = new int[6];
				
				System.out.print("숫자 6개를 입력해주세요 >> ");
				for (int i = 0; i < userNum.length; ++i) {
					userNum[i] = sc.nextInt();
				}
				
				System.out.print("입력하신 숫자는 ");
				System.out.println(Arrays.toString(userNum) + "입니다.");
				
				int rank = getRank(winNum, userNum);
				
				System.out.printf("결과는 %d등입니다. 당첨번호는 %s였습니다.\n",
						rank, Arrays.toString(winNum));
				
				++buyCount;
				++winCount[rank];
			} else if (select == 2) {
				System.out.print("몇 회 구매하시겠습니까? ");
				int ticketsCount = sc.nextInt();
				
				for (int i = 0; i < ticketsCount; ++i) {
					int[] autoNum = getRandomNumbers(6);
					int rank = getRank(winNum, autoNum);
					System.out.printf("%s vs %s 결과 %d등\n",
							Arrays.toString(winNum),
							Arrays.toString(autoNum),
							rank);
					++buyCount;
					++winCount[rank];
				}
			} else if (select == 3) {
				int buyMoney = 0;
				int totalMoney = 0;
				
				System.out.println("##### LOTTO GAME 전적 #####");
				System.out.printf("구매 회수 : %d회\n", buyCount);
				buyMoney = buyCount * 1000;
				totalMoney -= buyMoney;
				for (int i = 1; i < winCount.length; ++i) {
					System.out.printf("%d등: %d회\n", i, winCount[i]);
					totalMoney += winMoney[i] * winCount[i];
				}
				System.out.printf("구매 금액 : %d원\n", buyMoney);
				System.out.printf("현재 손익 : %d원\n", totalMoney);
				System.out.println("##########################");
				System.out.println("");
			}
		}
		System.out.println("게임 끝~");
		sc.close();
	}
	
}