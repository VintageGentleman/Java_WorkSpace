import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class D02_HashSet {

	/*
	  	# Set
	  	
	  	- 집합을 클래스로 구현해 놓은 것
	  	- 중복을 허용하지 않는다
	  	
	  	# Hash
	  	
	  	- 같은 값을 넣으면 항상 일정한 값이 나와야 하는 단방향성 알고리즘
	  	- 중복 체크에 많이 사용된다
	  	- 해쉬의 결과는 규칙적이지 않기 때문에 순서를 알 수 없다	
	  	
	  		"apple" 	-> "F1234123"
	  		"airplane"	-> "DD323211"
	  		"cat"		-> "13323433"
	  		
	  	# java.util.HashSet
	  	
	  	- 해쉬 알고리즘을 사용하는 Set
	  	- 중복된 데이터를 허용하지 않으며 순서가 없다 (index가 없다)
	*/
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		HashSet<Integer> numbers = new HashSet<>();
		Set<Integer> numbers2 = new HashSet<>();
		
		// add(item)
		numbers.add(10);
		numbers.add(20);
		numbers.add(30);
		numbers.add(40);
		numbers.add(50);
		numbers.add(60);
		numbers.add(70);
		numbers.add(80);
		
		System.out.println(numbers);
		
		// forEach : 값을 하나씩 꺼내서 대입하며 반복한다
		for(Integer num : numbers) {
			System.out.println(num);
		}
		
		// remove(item) : 인덱스가 없기 때문에 값으로만 지울 수 있다
		numbers.remove(40);
		System.out.println(numbers);
		
		// addAll(Collection) : 리스트를 더해 중복을 제거하는 것도 가능하다
		List<Integer> numList = new ArrayList<>();
		
		numList.add(100);
		numList.add(100);
		numList.add(100);
		numList.add(200);
		numList.add(300);
		numList.add(300);
		
		numbers.addAll(numList);
		System.out.println(numbers);
		
		// removeAll(Collection) :
		// 전달한 컬렉션에 들어있는 값과 일치하는 값을 지운다
		numbers.removeAll(numList);
		System.out.println(numbers);

		// 컬렉션은 다른 컬렉션으로의 변환이 자유롭다
		List<Integer> list1 = new ArrayList<>(numbers);
		System.out.println(list1);
	}
	
}
