
public class B14_Array2 {
	
	/*
	  	배열 안에 배열을 넣을 수 있다
	  	(배열을 요소로 가지는 배열을 만들 수 있다)
	*/

	public static void main(String[] args) {
		
		int[] arr1 = {1, 3, 5, 7, 9};
		int[] arr2 = {10, 20, 30, 40, 50, 60, 70, 80, 90};
		
		int[][] arr3 = {
				arr1,
				arr2,
				arr1,
				new int[] {9, 9, 9, 9, 9, 1, 9, 9},
				{8, 88, 888, 8888, 88888}, //마지막 쉼표는 찍어도 안찍어도 무방
				arr1,
		};
		
		// arr4에 arr1이 가리키고 있던 배열의 주소를 넘겼으므로
		// arr4를 수정하면 원래 arr1이 가리키고 있던 배열의 값을 바꾼다
		int[] arr4 = arr1;
		
		// arr5는 있던 배열의 주소를 넘겨받은 것이 아니라
		// 새로운 배열을 메모리상에 만든 것이므로 arr5를 아무리 수정해도
		// arr1의 배열은 변하지 않는다
		int[] arr5 = new int[] {1,3,5,7,9};
		arr5[0] = 512;
		
		System.out.println(arr4[0]);
		System.out.println(arr3[0][0]);
		System.out.println(arr3[2][0]);
		System.out.println(arr1[0]);
		
		// n차원 배열은 n중 반복문으로 모두 탐색할 수 있다
		int[][] nums = {
				{1, 2, 3},
				{4, 5, 6, 7, 8, 9},
				{99, 100, 15, 20},
				{1, 2, 3},
		}; // 2차원 배열
		
		// nums.length : 배열 안에 들어있는 배열이 몇 개인지
		for (int i = 0; i < nums.length; ++i) {
			// nums[i].length : i번째 배열의 요소가 몇 개인지
			for (int j = 0; j < nums[i].length; ++j) {
				System.out.printf("nums[%d][%d] : %d\n",
						i, j, nums[i][j]);
			}
		}
	}

}
