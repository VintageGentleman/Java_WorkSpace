package properties;

public class GameWord {

	public static String nowCategory;
	public static String nowWord;

	public GameWord() {
		String[] arr = firstWord();
		GameWord.nowCategory = arr[0];
		GameWord.nowWord = arr[1].trim().toLowerCase();
	}
	
	/** 정답 단어를 바꾸는 메서드 */
	public static void setRanWord() {
		String[] arr = firstWord();
		
		if(!arr[1].equals(nowWord)) {
			nowCategory = arr[0];
			nowWord = arr[1].trim().toLowerCase();
		} else {
			setRanWord();
		}
	}
	
	/** 
	 * 단어풀에서 랜덤 단어 뽑아주는 메서드. 
	 * 반환된 배열의 0번째 인덱스는 카테고리, 1번째 인덱스는 단어다.
	 */
	private static String[] firstWord() {
		int ran = (int)(Math.random() * words.length);
		
		return words[ran].split(":");
	}
	
	// 카테고리:이름 형태로 넣어야함
	private static String[] words = {
			"animal:lion", "animal:cat", "animal:dog", "animal:tiger", "animal:giraffe",
			"animal:bear", "animal:Deer", "animal:fox", "animal:Horse", "animal:Monkey",
			"fruit:apple", "fruit:banana", "fruit:avocado", "fruit:cherry", "fruit:coconut",
			"fruit:kiwi", "fruit:guava", "fruit:mandarin", "fruit:strawberry", "fruit:melon",
			"fruit:peach", "fruit:Orange", "fruit:Grape", "fruit:Pear",
			"season:spring", "season:summer", "season:winter", "season:fall",
			"programming language:Python", "programming language:Java", "programming language:Swift", 
			"programming language:JavaScript", "programming language:PHP", "programming language:TypeScript",
			"country:korea", "country:america", "country:japan", "country:china", "country:norway",
			"country:peru", "country:vietnam"
	};
}
