
public class B13_Array {
	
	/*
  		# 배열 (Array)
  		
  		- 같은 타입 변수를 여러개 선언하고 싶을 때 사용하는 문법
  		- 배열을 선언할 때 선언과 동시에 배열의 크기를 정해야 한다
  		- 배열을 선언한 후 각 변수를 방 번호(index)로 구분한다
  		- 배열의 인덱스는 0 ~ 길이 -1번까지 있다 (문자열과 유사함)
  		- 배열은 변수와는 다르게 처음 선언할 때 모든 방의 값을 초기화 해준다
  		  (정수:0, 실수:0, boolean:false, 참조형:null)
  		  
  		# 배열 선언 방식
  		
  		1. 타입[] 변수명 = new 타입[크기];
  		2. 타입[] 변수명 = { v1, v2, v3, v4, ... };
  		3. 타입[] 변수명 = new 타입[]{ v1, v2, v3, v4, ...};
	*/

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		char[] text = new char[15]; // 문자 배열 (문자열)
		
		text[0] = 'h';
		text[1] = 'e';
		text[2] = 'l';
		text[3] = 'l';
		text[4] = 'o';
		text[5] = 0;

		System.out.println(text);
		
		// int타입 변수를 1000개 선언하기
		int[] a = new int[1000];
		
		// ※ 초기화하지 않은 변수는 사용할 수 없다
		int num;
		
		// 배열 크기가 1000일 때 인덱스는 0 ~ 999까지 존재한다
		
		// 배열에 값 넣기
		a[0] = 5;
		a[1] = 10;
		a[2] = 99;
		
		// 배열에 들어있는 값 꺼내 쓰기
		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(a[2]);
		System.out.println(a[555]); // 값을 넣은 적 없는 배열에는 0이 들어있다
		
		// double타입 변수를 100개 선언하기
		double[] d = new double[100];
		
		String[] words =
			{"apple", "banana", "kiwi", "mango", "grape", "melon"};
		
		System.out.println(words[0]);
		System.out.println(words[1]);
		System.out.println(words[2]);
		
		// 배열은 반복문과 함께 사용하기 아주 좋은 형태로 되어있다
		for (int i = 0; i < words.length; ++i) {
			System.out.print(words[i] + " ");
		}
		System.out.println();
		
		// boolean의 초기값 : false
		boolean[] passExam = new boolean[30];
		System.out.println(passExam[7]);
		
		// String(참조형)의 초기값 : null (참조형)
		String[] snacks = new String[10];
		System.out.println(snacks[5]);
		
		String[] animals = new String[] {"cat", "dog", "lion"};
		System.out.println(animals[2]);
		
	}

}
