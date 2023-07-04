package myobj;

public class Game_Baseball {
	
	boolean gameRunning = true;
	boolean numCheck = true;
	int[] winNumber = new int[4];
	int[] playerNumber = new int[winNumber.length];
	int chance = 9;
	
	public Game_Baseball() {
		for (int i = 0; i < winNumber.length; ++i) {
			winNumber[i] = (int)(Math.random() * 10);
			for (int j = 0; j < i; ++j) {
				if(winNumber[i] == winNumber[j]) {
					--i;
					break;
				}
			}
		}
	}
	
	public boolean getGameRunning() {
		return gameRunning;
	}
	
	public boolean getNumCheck() {
		return numCheck;
	}
	
	private boolean checkValidNumber(String number) {
		boolean dupliCheck = true;
		for(int i = 0; i < number.length(); ++i) {
			for (int j = i + 1; j < number.length(); ++j) {
				if(number.charAt(i) == number.charAt(j)) {
					dupliCheck = false;
					break;
				}
			}
			if(!dupliCheck) {
				break;
			}
		}
		return number.length() == winNumber.length && dupliCheck;
	}
	
	public void choiceNumber(String number) {
		String temp = "";
		for(int i = 0; i < number.length(); ++i) {
			char num = number.charAt(i);
			if(num >= '0' && num <= '9') {
				temp += number.charAt(i);
			}
		}
		if (checkValidNumber(temp)) {
			numCheck = false;
			for (int i = 0; i < temp.length(); ++i) {
				playerNumber[i] = temp.charAt(i) - '0';
			}
		} else {
			System.err.println("번호를 잘못 입력했습니다");
		}
	}
	
	public void playerNotice() {
		System.out.print("번호를 입력하세요.\n"
				+ "숫자는 중복되어서는 안되며 "
				+ winNumber.length
				+ "자리수와 동일한 자리수를 입력해야합니다.\n>> ");
	}
	
	public void checkNumber() {
		int strikeCount= 0;
		int ballCount = 0;
		
		for(int i = 0; i < playerNumber.length; ++i) {
			if(playerNumber[i] == winNumber[i]) {
				++strikeCount;
			} else {
				for(int j = 0; j < playerNumber.length; ++j) {
					if(playerNumber[i] == winNumber[j]) {
						++ballCount;
					}
				}
			}
		}
		--chance;
		
		if (strikeCount == winNumber.length) {
			System.out.printf("%dStrike, 당신의 승리입니다"
					, strikeCount);
			gameRunning = false;
		} else {
			System.out.printf("Strike: %d, ball : %d\n 남은기회 : %d\n"
					, strikeCount, ballCount, chance);
		}
		numCheck = true;
	}
	
	public void checkChance() {
		if (gameRunning) {
			if (chance == 0) {
				System.out.print("모든 기회를 소진했습니다. 당신의 패배입니다.\n"
						+ "정답번호는 ");
				getWinNumber();
				gameRunning = false;
			} else {
				System.out.printf("기회가 %d번 남았습니다\n\n", chance);
			}
		}
	}
	
	private void getWinNumber() {
		for(int i = 0; i < winNumber.length; ++i) {
			System.err.printf("[%d]", winNumber[i]);
			System.out.println();
		}
	}
}
