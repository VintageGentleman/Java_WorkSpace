package quiz.D;

import java.util.ArrayList;
import java.util.List;

public class D01_ArrayListPractice_A {
	
	/*
	  	1. 리스트에 1000 ~ 2000 사이의 랜덤 정수를 100개 추가하기
	  	
	  	2. 원본에서 짝수를 모두 제거한 후 총합을 구하기
	  	
	  	3. 원본에서 홀수를 모두 제거한 후 총합을 구하기
	*/
	
	public static void main(String[] args) {
		
		List<Integer> numbers = new ArrayList<>();
		
		for(int i = 0; i < 100; ++i) {
			numbers.add((int)(Math.random() * 1001) + 1000);
		}
		
		System.out.println("원본 : " + numbers);
		
		int oddNumTotal = 0;
		int evenNumTotal = 0;
		
		while(numbers.size() > 0) {
			if(numbers.get(0) % 2 == 0) {
				evenNumTotal += numbers.remove(0);
			} else { 
				oddNumTotal += numbers.remove(0);
			}
		}
		
		System.out.println("홀수 총합 : " + oddNumTotal);
		System.out.println("짝수 총합 : " + evenNumTotal);
		System.out.println("원본 : " + numbers);
		
	}
}
