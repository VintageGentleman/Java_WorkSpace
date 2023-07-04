package quiz.B;

import java.util.Arrays;

public class B13_BubbleSort {

	public static void main(String[] args) {
		
		int[] nums = new int[30];
		
		for (int i = 0; i < nums.length; ++i) {
			nums[i] = (int)(Math.random() * 100 + 1);
		}
		System.out.println("원본: " + Arrays.toString(nums));
		
		// 29번만 반복하면 모두 정렬했다고 확신할 수 있다
		for (int i = 0; i < nums.length - 1; ++i) {
			for (int j = 0; j < nums.length - 1 - i; ++j) {
				if (nums[j] > nums[j + 1]) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
			System.out.printf("[정렬 %d단계]: %s\n", i + 1, Arrays.toString(nums));
		}
		System.out.println("결과? " + Arrays.toString(nums));
		
	}
}
