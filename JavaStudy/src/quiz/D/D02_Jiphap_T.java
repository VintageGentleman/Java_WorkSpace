package quiz.D;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class D02_Jiphap_T {

	/*
		1. 두 컬렉션을 매개변수로 전달받으면 두 컬렉션의 합집합을 Set으로 반환하는 메서드
		   [1, 2, 3] + [2, 3, 4, 5] => [1, 2, 3, 4, 5]
		   
		2. 두 컬렉션을 매개변수로 전달받으면 두 컬렉션의 교집합을 Set으로 반환하는 메서드
		   [1, 2, 3] 교 [2, 3, 4, 5] => [2, 3]
		   
		3. 두 컬렉션을 매개변수로 전달 받으면 두 컬렉션의 차집합을 Set으로 반환하는 메서드
		   [1, 2, 3] - [2, 3, 4, 5] => [1]
		   [2, 3, 4, 5] - [1, 2, 3] => [4, 5]
	*/

	// List, Set은 Collection타입으로 업캐스팅이 가능하다
	public static Set union(Collection A, Collection B) {
		// 원본을 훼손시키지 않도록 새 컬렉션에 담아서 합집합을 구한다
		Set hap = new HashSet();
		hap.addAll(A);
		hap.addAll(B);
		return hap;
	}
	
	public static Set intersection(Collection A, Collection B) {
		Set inter = new HashSet<>();
		
		inter.addAll(A);
		
		// retainAll(Collection) : 일치하는 값만 남긴다 
		inter.retainAll(B);
		
//		for(Object a : A) {
//			for(Object b : B) {
//				if(a.equals(b)) {
//					inter.add(a);
//				}
//			}
//		}
		
		return inter;
	}
	
	public static Set difference(Collection A, Collection B) {
		Set s = new HashSet<>();
		
		s.addAll(A);
		s.removeAll(B);
		
		return s;
	}
	
	public static void main(String[] args) {
		
		List<String> animals1 = new ArrayList<>();
		Set<String> animals2 = new HashSet<>();
				
		animals1.add("lion");
		animals1.add("tiger");
		animals1.add("pig");
		animals1.add("cow");
		
		animals2.add("pig");
		animals2.add("cow");
		animals2.add("turkey");
		animals2.add("duck");
		
		Set hap = union(animals1, animals2);
		System.out.println(hap);
		
		System.out.println("aniaml1: " + animals1);
		
		Set gyo = intersection(animals1, animals2);
		System.out.println(gyo);
		
		Set cha1 = difference(animals1, animals2);
		System.out.println(cha1);
		
		Set cha2 = difference(animals2, animals1);
		System.out.println(cha2);
	}
	
}
