package omok;

public class Omokpieces {
	static char[] typeColor = {'○', '●'}; // ○ ●
	int type;
	int column;
	int row;
	
	public Omokpieces(int typeColor, int row, int column) {
		this.type = typeColor;
		this.row = row;
		this.column = column;
	}
	
	@Override
	public String toString() {
		return "[" + row + "행 " + column + "열의 "  + typeColor[type] +"]";
	}

	// get 메서드는 이 아래
	
	public String getTypeColorName() {
		if(typeColor[type] == '○') {
			return "백돌";
		} else {
			return "흑돌";
		} 
 	}
	
	public char getTypeColor() {
		return typeColor[type];
	}
	
	public int getType() {
		return type;
	}
	
	public int getColumn() {
		return column;
	}
	
	public int getRow() {
		return row;
	}
}
