package myobj;

public class BaskinGame {
	
	int gameSize;
	int currPlayer;
	int currNum;
	int allPlayer;
			
	/** 기본크기(31)의 게임 생성 */
	public BaskinGame() {
		gameSize = 31;
	}
	
	public void setAllPlayer(int num) {
		allPlayer = num;
	}
	
	public void screen() {
		for (int i = 0; i < gameSize; ++i) {
			if (currNum - 1 == i) {
				System.out.printf("[%02d] ", i + 1);
			} else {
				System.out.printf("%02d ", i + 1);
			}
			
			if (i % 10 == 9) {
				System.out.println();
			}
		}
		System.out.println("\n----------------------------");
	}
	
	/** 현재 숫자를 보고 고를 수 있는 가장 큰 수를 만들어서 리턴 */
	public int getSelectAbleMaxNum() {
		return currNum + 3 > 31 ? 31 : currNum + 3;
	}
	
	/** 현재 숫자를 보고 고를 수 있는 가장 작은 수를 만들어서 리턴 */
	public int getSelectAbleMinNum() {
		return currNum + 1;
	}

	/** 전달받은 숫자가 골라도 되는 숫자인지 여부를 판단하여 리턴 */
	public boolean checkSelectAbleNum(int select) {
		return select <= getSelectAbleMaxNum()
				&& select >= getSelectAbleMinNum();
	}

	public int getPlayer() {
		return currPlayer % allPlayer + 1;
	}
	
	public boolean next(int select) {
		// currNum이 0일 때 3이 들어오면?
		// currNum이 5일 때 7이 들어오면?
		currNum = select;

		// 31이면 다음 플레이어로 넘어가지 않는다
		if (currNum == 31) {
			return true;
		} else {
			++currPlayer;
			return false;	
		} 
	}
}
