package quiz.C;

import java.util.Arrays;

public class C01_FunctionQuiz {
	
	/*
	  	# 다음 함수를 정의하고 올바르게 동작하는지 테스트 해보세요
	  	
	  	1. 전달한 문자가 알파벳이면 true를 반환, 아니면 false를 반환하는 함수
	  	
	  	2. 전달한 문자가 3의 배수이면 true를 반환, 아니면 false를 반환하는 함수
	  	
	  	3. 숫자를 하나 전달하면 문자열 "짝수입니다" 또는 "홀수입니다"를 반환하는 함수
	  	
	  	4. 숫자를 전달하면 해당 숫자의 모든 약수 int[]를 반환하는 함수
	  	
	  	5. 전달한 정수가 소수라면 ture를 반환하고 아니면 false를 반환하는 함수
	  	
	  	6. 메세지와 횟수를 전달하면 해당 메세지를 전달한 횟수만큼 반복하는 함수
	*/
	
	public static boolean checkAlphabet(char letter) {
		return letter >= 'A' && letter <= 'Z' || letter >= 'a' && letter <= 'z' ?
				true : false;
	}
	
	public static boolean mul3(int num) {
		return num % 3 == 0 ? true : false;
	}
	
	public static String oddEven(int num) {
		return num % 2 == 0 ? "짝수입니다" : "홀수입니다";
	}
	
	public static int[] aliquot(int num) {
		int[] temp = new int[num];
		int count = 0;
		for (int i = 1; i <= num; ++i) {
			if (num % i == 0) {
				temp[count] = i;
				++count;
			}
		}
		
		int[] result = new int[count];
		for (int i = 0; i < count; ++i) {
			result[i] = temp[i];
		}
		
		return result;
	}
	
	public static boolean checkPrime(int num) {
		boolean result = true;
		for (int i = 2; i < num; ++i) {
			if (num % i == 0) {
				result = false;
			}
		}
		return result;
	}
	
	public static void echo(String message, int num) {
		for (int i = 0; i < num; ++i) {
			System.out.println(message);
		}
	}
	
	public static void main(String[] args) {
		char temp = 'a';
		System.out.println(temp + " 이것은 알파벳입니까? " + checkAlphabet(temp));
		
		int num = 3;
		System.out.println(num + "은 3의배수입니까? " + mul3(num));
		
		int num2 = 5;
		System.out.println(num2 + "은 홀수입니까, 짝수입니까? " + oddEven(num2));
		
		int num3 = 10;
		System.out.println(num3 + "의 약수를 모두 구하시오 " + Arrays.toString(aliquot(num3)));
		
		int num4 = 20;
		System.out.println(num4 + "은 소수입니까? " + checkPrime(num4));
		
		int repeat = 5;
		String message = "야호~!";
		echo(message, repeat);
	}

}
