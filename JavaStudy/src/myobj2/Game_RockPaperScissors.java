package myobj2;

import java.util.InputMismatchException;
import java.util.regex.Pattern;

public class Game_RockPaperScissors {

	private final static String[] refer = {"바위", "보", "가위"};
	int totalRecord;
	int win;
	int lose;
	int draw;
	
	public Game_RockPaperScissors() {
		this(0, 0, 0);
	}
	
	public Game_RockPaperScissors(int win, int lose, int draw) {
		this.win = win;
		this.lose = lose;
		this.draw = draw;
		this.totalRecord = win + lose + draw;
	}
	
	public int[] saveRecord() {
		int[] gameRecord = {win, lose, draw};
		
		return gameRecord;
	}
	
	public void showRecord() {
		System.out.printf("<총 경기 수> : %d\n"
				+ "[승리] : %d, [패배] : %d, [무승부] : %d\n",
				totalRecord, win, lose, draw);
	}
	
	public void playGame(String handSign)
			throws InputMismatchException {
		
		handSign = handSign.trim();
		
		String regex = "가위|바위|보";
		
		if(!Pattern.matches(regex, handSign)) {
			throw new InputMismatchException("가위, 바위, 보 중에 입력해야합니다.");
		} else {
			++totalRecord;
			
			int computer;
			int player;
			
			computer = (int)(Math.random() * refer.length);
			
			switch(handSign) {
			case "바위":
				player = 0;
				break;
			case "보":
				player = 1;
				break;
			default :
				player = 2;
				break;
			}
			
			System.out.printf("\n당신 [%s] : 컴퓨터 [%s]\n",
					refer[player], refer[computer]);
			
			switch(outcome(computer, player)) {
			case -1:
				++lose;
				System.out.println("당신의 [패배]입니다.");
				break;
			case 1:
				++win;
				System.out.println("당신의 [승리]입니다.");
				break;
			default:
				++draw;
				System.out.println("[무승부]입니다.");
				break;
			};
		}
		
	}
	
	// 0 주먹 1 보 2 가위
	/** 승 : 1, 무 : 0, 패 : -1 */
	private int outcome(int computer, int player) {
		switch(computer) {
		case 0: 
			switch(player) {
			case 0:
				return 0;
			case 1:
				return 1;
			default:
				return -1;
			}
		case 1:
			switch(player) {
			case 0:
				return -1;
			case 1:
				return 0;
			default:
				return 1;
			}
		default:
			switch(player) {
			case 0:
				return 1;
			case 1:
				return -1;
			default:
				return 0;
			}
		}
	}
	
}
