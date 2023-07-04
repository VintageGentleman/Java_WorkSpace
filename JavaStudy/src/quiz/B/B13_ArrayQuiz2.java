package quiz.B;

import java.util.Arrays;

public class B13_ArrayQuiz2 {

	public static void main(String[] args) {
		
		int[][] myArr = {
				{1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1},
				{1, 1, 1, 1, 1},
				{1, 1},
				{1, 1, 1, 1},
		};
		
		// 1. myArr의 모든 값을 100 ~ 200 사이의 랜덤 정수로 바꾸기
		for (int i = 0; i < myArr.length; ++i) {
			for (int j = 0; j < myArr[i].length; ++j) {
				myArr[i][j] = (int)(Math.random() * 101) + 100;
			}
			System.out.println(Arrays.toString(myArr[i]));
		}
		
		// 2. 랜덤으로 바뀐 모든 값의 총합과 평균을 구하기
		int sum = 0;
		int count = 0;
		for (int i = 0; i < myArr.length; ++i) {
			for (int j = 0; j < myArr[i].length; ++j) {
				sum += myArr[i][j];
				++count;
			}
		}
		System.out.println("모든 요소의 총합: " + sum);
		System.out.println("평균: " + Math.round(sum/(double) count * 100) / 100.0);
		
		// 3. myArr은 각 행(row)의 합을 구해서 출력하기
		// 행의 합은 행의 개수만큼 있다
		int[] rowSum = new int[myArr.length];
		
		for (int i = 0; i < myArr.length; ++i) {
			for (int j = 0; j < myArr[i].length; ++j) {
				rowSum[i] += myArr[i][j];
			}
		}
		System.out.println("각 행의 합: " + Arrays.toString(rowSum));
		
		// 4. myArr의 각 열(column)의 합을 구해서 출력하기
		// 열의 합은 각 배열 중 가장 긴 배열의 길이만큼 있다
		int maxLen = 0;
		for (int i = 0; i < myArr.length; ++i) {
			int len = myArr[i].length;
			maxLen = len > maxLen ? len : maxLen;
		}	
		
		int[] colSum = new int[maxLen];
		
		for (int col = 0; col < maxLen; ++col) {
			for (int row = 0; row < myArr.length; ++row) {
				if (col < myArr[row].length) {
					colSum[col] += myArr[row][col];
				}
			}
		}
		System.out.println("각 열의 합: " + Arrays.toString(colSum));
		
		/*
		// row는 행, 배열의 개수
		for (int row = 0; row < myArr.length; ++row){
			// col은 열, 해당 줄의 길이만큼 있다
			for (int col = 0; col < myArr[row].length; ++col) {
				colSum[col] += myArr[row][col];
			}
		}
		System.out.println("열의 합: " + Arrays.toString(colSum));
		*/

	}

}
