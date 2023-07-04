package blackjack;

public class GameSystem {
	static int[] chips = {1, 10, 100, 500};
	
	Player_Computer computer;
	Player player1;
	CardSet cardSet;
	int stake = 0;
	boolean powerOn = true;
	boolean drawTurn = true;
	char winner;
	
	public GameSystem() {
		this.computer = new Player_Computer();
		this.player1 = new Player();
		this.cardSet = new CardSet();
	}
	
	public void startGame() {
		computer.declareHit(cardSet.drawCard());
		computer.declareHit(cardSet.drawCard());
		player1.declareHit(cardSet.drawCard());
		player1.declareHit(cardSet.drawCard());

		System.out.println("=================");
		computer.showCard();
		player1.showCard();
		System.out.println("=================");
	}
	
	public void bettingNotice() {
		System.out.println("플레이어의 보유금: " + player1.getHandMoney()); 
		System.out.println("배팅. 칩 번호를 입력하세요. 보유금이 0 미만이 되면 패배합니다.");
		System.out.println("딜러는 플레이어와 같은 금액의 칩을 배팅합니다.");
		System.out.printf("1.[%d] 2.[%d] 3.[%d] 4.[%d]\n>> "
				, chips[0], chips[1], chips[2], chips[3]);
	}
	
	public void bettingPhase(int chipNumber) {
		int chipValue = chips[chipNumber - 1]; 
		computer.betMoney(chipValue);
		if(computer.getHandMoney() < 0) {
			System.out.println("=============== $$$$ =============");
			System.out.println("딜러 보유금이 떨어졌습니다. 플레이어의 게임 승리");
			System.out.println("=============== $$$$ =============");
			powerOn = false;
		}
		player1.betMoney(chipValue);
		if(player1.getHandMoney() < 0) {
			System.out.println("=============== ****** ==============");
			System.out.println("플레이어 보유금이 떨어졌습니다. 게임에서 패배했습니다");
			System.out.println("=============== ****** ==============");
			powerOn = false;
		}
		stake += (chipValue * 2);
	}
	
	public void drawNotice() {
		System.out.println("=================");
		System.out.println("1.[hit] 2.[stand]");
		System.out.print("번호를 입력하세요.\n>> ");
	}
	
	public void drawPhase(int select) {
		switch(select) {
		case 1:
			player1.declareHit(cardSet.drawCard());
			System.out.println("=================");
			player1.showCard();
			break;
		case 2:
			player1.declareStand();
			computer.openCard();
			if(computer.getCardSum() < 17) {
				System.out.println("\n딜러가 카드를 뽑을 차례.\n");
				while(computer.getCardSum() < 17) {
					computer.declareHit(cardSet.drawCard());
					computer.openCard();
				}
			}
			break;
		}
		checkPhaseEnd(player1);
	}
	
	public void conclusionPhase() {
		boolean CD = computer.isCheckDefeated();
		boolean PD = player1.isCheckDefeated();
		int CGS = computer.getCardSum();
		int PGS = player1.getCardSum();
		if(PD) {
			System.out.println("플레이어 버스트. 딜러 승리");
			computer.openCard();
			winner = 'C';
		} else if(CD) {
			System.out.println("딜러 버스트. 플레이어 승리.");
			player1.showCard();
			winner = 'P';
		} else if(CGS > PGS) {
			if(CGS == 21) {
				System.out.println("딜러 블랙잭!");
			}
			System.out.println("딜러 승리");
			winner = 'C';
		} else if(CGS < PGS) {
			if(PGS == 21) {
				System.out.println("플레이어 블랙잭!");
			}
			System.out.println("플레이어 승리");
			winner = 'P';
		} else {
			System.out.println("동점. 무승부.");
			winner = 'D';
		}
		System.out.println();
	}

	public void allocationPhase() {
		if(winner == 'P') {
			System.out.println("총 배팅금 " + stake + "원은 플레이어에게 돌아갑니다.");
			player1.earnPrize(stake);
			stake = 0;
		} else if(winner == 'C') {
			System.out.println("총 배팅금 " + stake + "원은 딜러에게 돌아갑니다.");
			computer.earnPrize(stake);
			stake = 0;
		} else {
			System.out.println("총 배팅금 " + stake + "원은 다음 경기로 이어집니다.");
		}
		System.out.println();
	}
	
	public void noticeCheckRestartGame() {
		System.out.println("=================");
		System.out.println("[1]다음 게임 [2]게임 종료");
		System.out.print("선택하세요\n>> ");
	}
	
	public void checkRestartGame(int select) {
		switch(select) {
		case 1:
			System.out.println("\n...\n카드 섞는 중\n...\n");
			player1.backToStart();
			computer.backToStart();
			cardSet.cardReset();
			drawTurn = true;
			break;
		case 2:
			System.out.println("게임을 종료합니다.");
			System.out.println("플레이어의 최종 보유금: " + player1.getHandMoney());
			powerOn = false;
			break;
		}
	}
	
	private void checkPhaseEnd(Player player1) {
		if(player1.isCheckStand() || player1.isCheckDefeated()) {
			drawTurn = false;
		}
	}
	
	// get메서드는 이 아래
	
	public boolean isDrawTurn() {
		return drawTurn;
	}
	
	public boolean isPowerOn() {
		return powerOn;
	}
	
}
