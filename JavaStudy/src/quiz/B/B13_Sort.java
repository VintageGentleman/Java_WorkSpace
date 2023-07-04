package quiz.B;

import java.util.Arrays;

public class B13_Sort {
	
	/*
	  	1 ~ 100 사이의 랜덤 정수 값이 30개 들어있는 배열을 생성한 후
	  	
	  	(1) 해당 배열의 내용을 작은 값부터 차례대로 저장한 새로운 배열을 만들어서 출력
	  		(오름차순, Ascending)
	  	
	  	(2) 해당 배열의 내용을 큰 값부터 차례대로 저장한 새로운 배열을 만들어서 출력
	  		(내림차순, Descending)
	*/

	public static void main(String[] args) {
		
		int[] nums = new int[30];
		
		for (int i = 0; i < nums.length; ++i) {
			nums[i] = (int)(Math.random() * 100 + 1);
		}
		System.out.println("원본: " + Arrays.toString(nums));

		// 1. 제일 작은 숫자를 찾는다
		// 2. 맨 앞(i번째)에 넣는다
		// 3. 위 과정을 반복한다
		for (int i = 0; i < 29; ++i) {
			
			// 제일 작은 값과 제일 작은 값이 있던 위치를 찾는다
			int min = nums[i];
			int min_index = i;
			
			for (int j = i + 1; j < nums.length; ++j) {
				if (min > nums[j]) {
					min = nums[j];
					min_index = j;
				}
			}
			
			// 찾은 값을 맨 앞으로 옮긴다 (원래 있던 값은 최소값이 있던 곳으로)
			int temp = nums[i];
			nums[i] = nums[min_index];
			nums[min_index] = temp;
		}
		
		System.out.println("잘 됐나? " + Arrays.toString(nums));
	}
}
