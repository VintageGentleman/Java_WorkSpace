package blackjack2;

public class Card {
	
	private static char[] suits = {'♠', '♡', '◇', '♣'};
	private static String[] ranks =
		{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	private static int[] rankValues =
		{11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
	
	int suit;
	int rank;
	boolean hide;
	
	public Card(int suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public void reverse() {
		hide = !hide;
	}
	
	@Override
	public String toString() {
		if(hide) {
			return "[" + suits[suit] + " ?]";
		} else {
			return "[" + suits[suit] + ' ' + ranks[rank] + "]";
		}
	}
	
	public int getRankValue() {
		return rankValues[rank];
	}

	public int getRank() {
		return rank;
	}
	
	public static void main(String[] args) {
		System.out.println(new Card(0, 0));
		System.out.println(new Card(0, 1));
		System.out.println(new Card(2, 5));
	}
	
}
