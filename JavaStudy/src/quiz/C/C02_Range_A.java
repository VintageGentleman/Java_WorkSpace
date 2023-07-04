package quiz.C;

import java.util.Arrays;

public class C02_Range_A {
	
	/*
	  	1. 최대값을 인자로 전달하면
	  	   0부터 최대값 미만의 int[]을 생성하여 반환하는
	  	   range 함수를 만들어 보세요
	  	   
	  	   ex> range(8)의 결과 -> [0, 1, 2, 3, 4, 5, 6, 7]
	  	   
	  	2. 최소값과 최대값을 인자로 전달하면
	  	   최소값부터 최대값 미만의 int[]을 생성하여 반환하는
	  	   range 함수를 만들어 보세요
	  	   
	  	   ex> range(10, 15)의 결과 -> [10, 11, 12, 13, 14]
	  	   	   range(15, 10)의 결과 -> [15, 14, 13, 12, 11]
	  	   
	  	3. 최소값 최대값 증가값을 인자로 전달하면
	  	   최소값부터 최대값 미만까지 증가값만큼 증가하는 int[]을 반환하는
	  	   range 메서드를 만들어 보세요
	  	   
	  	   ex> range(30, 40, 2) -> [30,32,34,36,38]
	  	       range(50, 40,-3) -> [50,47,44,41]
	  	       range(50, 40, 5) -> []	   
	*/
	
	public static int[] range(int num) {
		int[] answer = new int[num];
		for(int i = 0; i < num; ++i) {
			answer[i] = i;
		}
		return answer;
	}
	
	public static int[] range(int min, int max) {
		int[] answer = new int[Math.abs(min - max)];
		if (min < max) {
			int index = 0;
			for (int i = min; i < max; ++i) {
				answer[index++] = i;
			}
		} else {
			int index = 0;
			for (int i = min; i > max; --i) {
				answer[index++] = i;
			}
		}
		return answer;
	}
	
	public static int[] range(int start, int end, int upDown) {
		int count = 0;
		if (start < end) {
			for (int i = start; i < end; i += upDown) {
				++count;
			}
		} else {
			for (int i = start; i > end; i += upDown) {
				++count;
			}
		}
		
		int[] answer = new int[count];
		int index = 0;
		if (start < end && upDown > 0) {
			for (int i = start; i < end; i += upDown) {
				answer[index++] = i;
			}
		} else if (start > end && upDown < 0) {
			for (int i = start; i > end; i += upDown) {
				answer[index++] = i;
			}
		} else {
			return new int[] {};
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] result = range(50, 40, -3);
		
		System.out.println(Arrays.toString(result));
	}

}
