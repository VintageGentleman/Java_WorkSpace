package omok;

public class Omokboard {
	char[][] board;
	Omokpieces[][] peices;
	
	public Omokboard() {
		this.board = new char[][] {
				{'┌','┬', '┬', '┬', '┬', '┬', '┬', '┬', '┬', '┬', '┬', '┬', '┐'},
				{'├','┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'},
				{'├','┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'},
				{'├','┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'},
				{'├','┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'},
				{'├','┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'},
				{'├','┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'},
				{'├','┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'},
				{'├','┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'},
				{'├','┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'},
				{'├','┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'},
				{'├','┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤'},
				{'└','┴', '┴', '┴', '┴', '┴', '┴', '┴', '┴', '┴', '┴', '┴', '┘'},
		};
		this.peices = new Omokpieces[board.length][board[0].length];
	}

	public void showBoard() {
		for(int i = -1; i < board.length; ++i) {
			if(i == -1) {
				System.out.print("  ");
				for(int j = 0; j < board[0].length; ++j) {
					System.out.print(j + " ");
				}
			} else {
				for(int j = 0; j < board[i].length; ++j) {
					if(j == 0) {
						System.out.printf("%2d", i);
					}
					System.out.printf("%c ", board[i][j]);
				
				}
			}
			System.out.println();
		}
	}
	
	public boolean playGostone(int color, int row, int column) {
		if(row >= peices.length || row < 0
				|| column >= peices.length || column < 0) {
			System.out.println("돌이 바둑판(0 ~ 12)을 벗어났습니다.\n다시 두세요.");
			return true;
		} else if(peices[row][column] == null) {
			peices[row][column] = new Omokpieces(color, row, column);
			board[row][column] = peices[row][column].getTypeColor();
			return false;
		} else {
			System.out.println("이미 돌이 있는 자리입니다.\n다시 두세요.");
			return true;
		}
	}

	public boolean conclusion(int row, int column) {
		int colorType = peices[row][column].getType();
		String colorName = peices[row][column].getTypeColorName();
		
		// 행 체크
		int rowCheck = 0;
		for(int i = column; i < peices[row].length; ++i) {
			if(peices[row][i] == null ||
					peices[row][i].getType() != colorType) {
				break;
			} 
			++rowCheck;
		}
		for(int i = column; i >= 0; --i) {
			if(peices[row][i] == null ||
					peices[row][i].getType() != colorType) {
				break;
			} 
			++rowCheck;
		}
		if(rowCheck - 1 == 5) {
			System.out.println(colorName + "의 승리\n"
					+ "가로 5줄 완성");
			return false;
		}
		
		// 열 체크
		int columnCheck = 0;
		for(int i = row; i < peices.length; ++i) {
			if(peices[i][column] == null ||
					peices[i][column].getType() != colorType) {
				break;
			} 
			++columnCheck;
		}
		for(int i = row; i >= 0; --i) {
			if(peices[i][column] == null ||
					peices[i][column].getType() != colorType) {
				break;
			} 
			++columnCheck;
		}
		if(columnCheck - 1 == 5) {
			System.out.println(colorName + "의 승리\n"
					+ "세로 5줄 완성");
			return false;
		}
		
		// 왼쪽-오른쪽대각
		int diagonal_right = 0;
		int plusColumn = column;
		for(int i = row; plusColumn < peices.length && i < peices.length; ++i) {
			if(peices[i][plusColumn] == null ||
					peices[i][plusColumn].getType() != colorType) {
				break;
			} 
			++plusColumn;
			++diagonal_right;
		}
		int minusColumn = column;
		for(int i = row; minusColumn > 0 && i >= 0; --i) {
			if(peices[i][minusColumn] == null ||
					peices[i][minusColumn].getType() != colorType) {
				break;
			} 
			--minusColumn;
			++diagonal_right;
		}
		if(diagonal_right - 1 == 5) {
			System.out.println(colorName + "의 승리\n"
					+ "대각선 5줄 완성");
			return false;
		}
		
		// 오른쪽-왼쪽대각
		int diagonal_left = 0;
		int minusRow = row;
		for(int i = column; minusRow > 0 && i < peices.length; ++i) {
			if(peices[minusRow][i] == null ||
					peices[minusRow][i].getType() != colorType) {
				break;
			} 
			--minusRow;
			++diagonal_left;
		}
		int plusRow = row;
		for(int i = column; plusRow < peices.length && i >= 0; --i) {
			if(peices[plusRow][i] == null ||
					peices[plusRow][i].getType() != colorType) {
				break;
			} 
			++plusRow;
			++diagonal_left;
		}
		if(diagonal_left - 1 == 5) {
			System.out.println(colorName + "의 승리\n"
					+ "대각선 5줄 완성");
			return false;
		}
		
		return true;
	}

}
