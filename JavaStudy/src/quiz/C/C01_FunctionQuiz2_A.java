package quiz.C;

import java.util.Arrays;

public class C01_FunctionQuiz2_A {
	
	/*
	  	1. 사과의 개수와 바구니의 크기를 전달하면 필요한 바구니의 개수를 리턴하는 함수
	  	
	  	2. 문자열을 전달하면 해당 문자열을 랜덤으로 뒤섞은 결과를 반환하는 함수
	  	
	  	3. 문자열을 전달하면 해당 문자열을 거꾸로 한 문자열을 반환하는 함수
	  	
	  	4. 메서드를 호출하면 1 ~ 45 사이의 중복없는 숫자 7개로 이루어진 배열을 
	  	   반환하는 함수
	*/

	/** 사과의 개수와 바구니의 크기를 전달하면 필요한 바구니의 개수를 리턴하는 함수 */
	public static int getBasket (int appleNumber, int basketSize) {
		int basket = appleNumber % basketSize == 0 ?
				appleNumber / basketSize : appleNumber / basketSize + 1;
		return basket;
	}
	
	/** 문자열을 전달하면 해당 문자열을 랜덤으로 뒤섞은 결과를 반환하는 함수 */
	public static String shuffleString(String text) {
		char[] letterSet = text.toCharArray();
		boolean[] check = new boolean[letterSet.length];
		String result = "";
		for (int i = 0; i < letterSet.length; ++i) {
			int num = (int)(Math.random() * letterSet.length);
			if (!check[num]) {
				result += letterSet[num];
				check[num] = true;
			} else {
				--i;
			}
		}
		return result;
	}
	
	/** 문자열을 전달하면 해당 문자열을 거꾸로 한 문자열을 반환하는 함수 */
	public static String reverseString(String text) {
		char[] letterSet = text.toCharArray();
		String result = "";
		for (int i = letterSet.length - 1; i >= 0; --i) {
			result += letterSet[i];
		}
		return result;
	}
	
	/** 메서드를 호출하면 1 ~ 45 사이의 중복없는 숫자 7개로 이루어진 배열을 
	  	   반환하는 함수 */
	public static int[] randomNumbers() {
		int[] numbers = new int[7];
		for (int i = 0; i < 7; ++i) {
			int num = (int)(Math.random() * 45) + 1;
			numbers[i] = num;
			for (int j = 0; j < i; ++j) {
				if (num == numbers[j]) {
					--i;
				}
			}
		}
		return numbers;
	}
	
	public static void main(String[] args) {
		
		String text = "abcdefg";
		
		System.out.println(getBasket(2,10));
		System.out.println(shuffleString(text));
		System.out.println(reverseString(text));
		
		int[] data = randomNumbers();
		System.out.println(Arrays.toString(data));
		
	}

}
