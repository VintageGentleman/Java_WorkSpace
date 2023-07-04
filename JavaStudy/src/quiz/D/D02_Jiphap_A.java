package quiz.D;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class D02_Jiphap_A {

	/*
	  	1. 두 컬렉션을 매개변수로 전달받으면 두 컬렉션의 합집합을 Set으로 반환하는 메서드
	  	   [1, 2, 3] + [2, 3, 4, 5] => [1, 2, 3, 4, 5]
	  	   
	  	2. 두 컬렉션을 매개변수로 전달받으면 두 컬렉션의 교집합을 Set으로 반환하는 메서드
	  	   [1, 2, 3] 교 [2, 3, 4, 5] => [2, 3]
	  	   
	  	3. 두 컬렉션을 매개변수로 전달 받으면 두 컬렉션의 차집합을 Set으로 반환하는 메서드
	  	   [1, 2, 3] - [2, 3, 4, 5] => [1]
	  	   [2, 3, 4, 5] - [1, 2, 3] => [4, 5]
	*/
	
	/** 1번 */
	public static Set<Integer> sumSet(Collection<Integer> set1, Collection<Integer> set2) {
		Set<Integer> temp = new HashSet<Integer>();
		temp.addAll(set1);
		temp.addAll(set2);
		return temp;
	}
	
	/** 2번 */
	public static Set<Integer> intersection(Collection<Integer> set1, Collection<Integer> set2) {
		Set<Integer> temp = new HashSet<>();
		for(Integer num1 : set1) {
			for(Integer num2 : set2) {
				if(num1 == num2) {
					temp.add(num1);
				}
			}
		}
		return temp;
	}
	
	/** 3번 */
	public static Set<Integer> difference(Collection<Integer> set1, Collection<Integer> set2) {
		Set<Integer> temp = new HashSet<Integer>(); 
		temp = sumSet(set1, set2);
		temp.removeAll(set2);
		return temp;
	}
	
	/** Collection에 넣길 원하는 연속된 숫자의 시작과 끝을 입력하면 instance에 그 값을 입력해주는 메서드 */
	public static void setNumber(Collection<Integer> set1, int startNum, int endNum){
		for(int i = startNum; i <= endNum; ++i) {
			set1.add(i);
		}
	}
	
	public static void main(String[] args) {
		// 1번
		System.out.println("1번");
		HashSet<Integer> set1 = new HashSet<>();
		HashSet<Integer> set2 = new HashSet<>();
		
		setNumber(set1, 1, 3);
		setNumber(set2, 2, 5);
		
		System.out.println(set1);
		System.out.println(set2);
		System.out.println(sumSet(set1, set2)); 
		
		// 2번
		System.out.println("\n2번");
		
		System.out.println(set1);
		System.out.println(set2);
		System.out.println(intersection(set1, set2));
		
		// 3번
		System.out.println("\n3번 - 1");
		
		System.out.println(set1);
		System.out.println(set2);
		System.out.println(difference(set1, set2));
		
		System.out.println("\n3번 - 2");
		
		System.out.println(set2);
		System.out.println(set1);
		System.out.println(difference(set2, set1));
	}
}
