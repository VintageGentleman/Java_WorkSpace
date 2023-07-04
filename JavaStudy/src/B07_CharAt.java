
public class B07_CharAt {

	/*
	  	# "문자열".charAt(index);
	  	
	  	- 해당 문자열에서 원하는 인덱스의 문자를 char타입으로 꺼내는 함수
	  	- 시작 인덱스는 0번이다
	  	
	  	# "문자열".length();
	  	
	  	- 해당 문자열이 몇 글자인지(길이가 얼마인지) int타입으로 반환하는 함수
	  	- 마지막 인덱스는 '문자열 길이 -1'
	*/

	public static void main(String[] args) {

		String str = "ABCDEFG";
		
		System.out.println("길이 " + str.length());
		
		// 시작 인덱스는 0번이다
		System.out.println("문자열의 첫 번째 문자: " + str.charAt(0));
		
		// 마지막 인덱스는 length - 1번이다
		System.out.println("문자열의 마지막 문자: "
				+ str.charAt(str.length() - 1));
		
		// for문을 통해 문자열을 쉽게 탐색할 수 있다
		for (int index = 0; index < str.length(); ++index) {
			System.out.printf("%d번째 문자: %c\n", index, str.charAt(index));
		}
	}
}
