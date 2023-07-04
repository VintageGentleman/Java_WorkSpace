package quiz.C;

import java.util.Arrays;

public class C01_FunctionQuiz_T {
	
	/*
	  	# 다음 함수를 정의하고 올바르게 동작하는지 테스트 해보세요
	  	
	  	1. 전달한 문자가 알파벳이면 true를 반환, 아니면 false를 반환하는 함수
	  	
	  	2. 전달한 문자가 3의 배수이면 true를 반환, 아니면 false를 반환하는 함수
	  	
	  	3. 숫자를 하나 전달하면 문자열 "짝수입니다" 또는 "홀수입니다"를 반환하는 함수
	  	
	  	4. 숫자를 전달하면 해당 숫자의 모든 약수 int[]를 반환하는 함수
	  	
	  	5. 전달한 정수가 소수라면 ture를 반환하고 아니면 false를 반환하는 함수
	  	
	  	6. 메세지와 횟수를 전달하면 해당 메세지를 전달한 횟수만큼 반복하는 함수
	*/
	
	public static boolean isAlphabet (char ch) {
		return ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z';
	}
	
	public static boolean isNumMul3 (int num) {
		return num % 3 == 0;
	}
	
	public static String checkEvenOdd (int num) {
		return num % 2 == 0 ? "짝수입니다" : "홀수입니다";
	}

	public static int[] yaksu(int num) {
		// null : 아직 가리키는게 없음
		// 배열 또는 대문자로 시작하는 타입을 초기화할때 사용한다
		int[] yaksuArr = null;
		int size = 0;
		
		for (int i = 0; i <= num; ++i) {
			if (num % i == 0) {
				// 새로운 약수가 발견될 때마다 크기가 1증가한 배열을 새로 생성
				int[] newArr = new int[++size];
				
				// 이전 배열의 내용을 모두 새로운 배열에 복사 (비어있지 않다면)
				if (yaksuArr != null) {
					for (int j = 0; j < yaksuArr.length; ++j) {
						newArr[i] = yaksuArr[i];
					}
				}
				// 새로운 배열의 맨 마지막에 새로 발견한 약수를 추가
				newArr[newArr.length - 1] = i;
				
				// 방금 새로 만든 배열을 약수 배열로 만든다
				yaksuArr = newArr;
			}
		}
		
		return yaksuArr;
	}

	public static boolean isSosu(int num) {
		// 해당 숫자를 2부터 제곱근까지 나누어 봤을때 나누어떨어지는게 존재하면 false
		for (int i = 2; i <= Math.sqrt(num); ++i) {
			if (num % i == 0) {
				return false; // 함수 내부에서 return을 만나면 함수가 종료됨
			}
		}
		return true;
	}
	
	public static void repeat(String message, int num) {
		for (int i = 0; i < num; ++i) {
			System.out.println(message);
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(yaksu(20)));
		
		System.out.println(isSosu(10));
				
		repeat("hello", 5);
	}

}
