package myobj;

public class Card {

	public static int width = 80;
	public static int height = 150;
	
	public static char[] shapes = {'◇', '♡'};
	
	public static char getRandomShapes() {
		return shapes[(int)(Math.random() * shapes.length)];
	}
	
	public static int getRandomNumber() {
		return (int)(Math.random() * 13);
	}
	
	public static Card getRandomCard() {
		return new Card(getRandomShapes(), getRandomNumber());
	}
	
	public static void changeCardSize(int width, int height) {
		// 스태틱 자원은 클래스당 하나이기 때문에
		// 클래스 이름 뒤에 .을 찍고 사용할 수 있다
		Card.width = width;
		Card.height = height;
	}
	
	public char shape;
	public int number;
	
	public Card(char shape, int number) {
		this.shape = shape;
		this.number = number;
	}
	
}
