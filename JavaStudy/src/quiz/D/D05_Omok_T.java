package quiz.D;

public class D05_Omok_T {
	
	final private static char[] icons = 
		{'┌', '┬', '┐', '├', '┼', '┤', '└', '┴', '┘', '○', '●'};
	
	final public static int WHITE_STONE = 9;  
	final public static int BLACK_STONE = 10;  
	
	int[][] board = {
			{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2},
			{3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5},
			{3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5},
			{3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5},
			{3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5},
			{3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5},
			{3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5},
			{3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5},
			{3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5},
			{3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5},
			{3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5},
			{3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5},
			{3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5},
			{3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5},
			{6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8},
	};
	
	public boolean put(String location, int color) {
		if(color != WHITE_STONE && color != BLACK_STONE) {
			System.out.println("[ERROR] "
					+ "3번째 파라미터에는 D05_Omok.WHITE_STONE 또는 "
					+ "D05_Omok.BLACK_STONE을 사용해주세요.");
			return false;
		}
		
		int[] index = getIndexes(location);
		
		int row = index[0];
		int col = index[1]; 
		
		if(row < 0 || row > 14 || col < 0 || col > 14) {
			System.out.println("[ERROR] 잘못된 위치를 입력하셨습니다.");
			return false;
		}
		
		board[row][col] = color;
		
		return true;
	}
	
	public void print() {
		System.out.println(" ①  ②  ③  ④  ⑤  ⑥  ⑦  ⑧  ⑨  ⑩  ⑪  ⑫  ⑬  ⑭  ⑮");
		for(int i = 0; i < board.length; ++i) {
			System.out.print((char)('A' + i));
			for(int j = 0; j < board[i].length; ++j) {
				if(j == 14) {
					System.out.print(icons[board[i][j]] + "\n");
				} else {
					System.out.print(icons[board[i][j]] + "──");
				}
			}
		}
	}
	
	// location EX) A5
	private int[] getIndexes(String location) {
		return new int[] {
				location.charAt(0) - 'A',
				// "".substring(index) : 해당 위치부터 마지막까지 문자열을 자른다
				Integer.parseInt(location.substring(1)) - 1 
		};
	}
	
	public boolean checkWin(String location, int color) {
		int[] rowCol = getIndexes(location);
		
		int row = rowCol[0];
		int col = rowCol[1];
		
		// 현재 돌의 위치로부터 가로로 오목 체크
		int count = 1;
		// (1) 현재 돌의 위치로부터 가로 오른쪽 체크
		for(int i = col + 1; i < board[0].length; ++i) {
			if(board[row][i] == color) {
				++count;
			} else {
				break;
			}
		}
		// (2) 현재 돌의 위치로부터 가로 왼쪽 체크
		for(int i = col - 1; i >= 0; --i) {
			if(board[row][i] == color) {
				++count;
			} else {
				break;
			}
		}
		
		if(count == 5) {
			return true;
		}
		
		// 현재 돌의 위치로부터 세로로 오목 체크
		count = 1;
		// (1) 현재 돌의 위치로부터 세로 위쪽 체크
		for(int i = row - 1; i >= 0; --i) {
			if(board[i][col] == color) {
				++count;
			} else {
				break;
			}
		}
		// (2) 현재 돌의 위치로부터 세로 아래쪽 체크
		for(int i = row + 1; i < board.length; ++i) {
			if(board[i][col] == color) {
				++count;
			} else {
				break;
			}
		}
		
		if(count == 5) {
			return true;
		}
		
		// 현재 돌의 위치로부터 대각선으로 오목 체크
		count = 1;
		// (1) 오른쪽 위 (행은 감소, 열은 증가)
		for(int i = row - 1, j = col + 1;
				i >= 0 && j < board[0].length; --i, ++j) {
			if(board[i][j] == color) {
				++count;
			} else {
				break;
			}
		}
		// (2) 왼쪽 아래 (행은 증가, 열은 감소)
		for(int i = row + 1, j = col - 1;
				i < board.length && j >= 0; ++i, --j) {
			if(board[i][j] == color) {
				++count;
			} else {
				break;
			}
		}
		
		if(count == 5) {
			return true;
		}
		
		count = 1;
		// (3) 오른쪽 아래 (행, 열 증가)
		for(int i = row + 1, j = col + 1;
				i < board.length && j < board[0].length; ++i, ++j) {
			if(board[i][j] == color) {
				++count;
			} else {
				break;
			}
		}
		// (4) 왼쪽 위 (행, 열 감소)
		for(int i = row - 1, j = col - 1;
				i >= 0 && j >= 0; --i, --j) {
			if(board[i][j] == color) {
				++count;
			} else {
				break;
			}
		}
		
		if(count == 5) {
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		D05_Omok_T game = new D05_Omok_T();
		
		game.put("A1", BLACK_STONE);
		game.put("B2", BLACK_STONE);
		game.put("C3", BLACK_STONE);
		game.put("D4", BLACK_STONE);
		game.put("E5", BLACK_STONE);
		
		game.put("F5", WHITE_STONE);
		game.put("G4", WHITE_STONE);
		game.put("H3", WHITE_STONE);
		game.put("I2", WHITE_STONE);
		game.put("J1", WHITE_STONE);
		
		game.print();
		System.out.println("검은돌이 이겼나? : " + game.checkWin("C3", BLACK_STONE));
		System.out.println("흰돌이 이겼나? : " + game.checkWin("H3", WHITE_STONE));
	}

}
