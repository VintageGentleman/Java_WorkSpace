package myobj;

public class Game31 {
	
	public boolean running = true;
	public int player = 0;
	
	int choiceNumber;
	int number = 0;
	int turn = 1;
	
	/** @param num 2이상이어야 한다 */
	public void settingPlayer(int num) {
		if (num < 2) {
			System.out.print("인원은 2명 이상이어야 합니다.\n"
					+ "다시 입력하세요\n>> ");
		} else {
			player = num;
		}
	}
	
	public void startNotice() {
		System.out.println("게임을 시작합니다.\n숫자가 31을 넘으면 패배합니다.");
		System.out.print("게임 참여 인원을 설정하세요(최소 2명 이상)\n>> ");
	}
	
	public void notice () {
		System.out.println(turn +"번의 차례입니다");
		System.out.printf("숫자는 %d부터 %d사이의 값이어야 합니다\n",
				 number + 1, number + 3);
		System.out.print("숫자를 입력하세요.\n>> ");
	}
	
	public void numberCheck(int num) {
		if (num >= number + 1 && num <= number + 3) {
			number = num;
			choiceNumber = number;
			if (checkLose()) {
				running = false;
				System.out.println(turn + "번, 당신의 패배입니다");
			}
		} else {
			System.out.println("범위 밖의 숫자입니다. 다시 입력하세요");
			--turn;
		}
		overTurn();
	}
	
	boolean checkLose() {
		return choiceNumber >= 31; 
	}
	
	void overTurn () {
		++turn;
		if (turn > player) {
			turn = 1;
		}
	}
}
