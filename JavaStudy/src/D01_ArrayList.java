import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import school.ProgrammingStudent;

public class D01_ArrayList {
	
	/*
	  	# java.util.ArrayList
	  	
	  	- 배열과 유사하지만 크기가 자동으로 조절된다는 장점이 있는 자료구조
	  	- 배열처럼 데이터를 순차적으로 저장한다
	  	- 모든 데이터를 순차적으로 읽는 속도가 가장 빠른 자료구조이다 
	  	
	  	# 자료구조(Data Structure)
	  	
	  	- 데이터를 효율적으로 보관할 수 있는 여러가지 방식들
	  	- 상황마다 데이터를 가장 효율적으로 다룰 수 있는 방법에 대해 연구해놓은 
	  	  결과물 (데이터 검색, 탐색, 정렬, 추가, 삭제... 등등)
	*/

	
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public static void main(String[] args) {
		
		// 새 리스트를 하나 생성 (타입을 지정하지 않고 생성)
		ArrayList list1 = new ArrayList();
		ArrayList list2 = new ArrayList();
		
		// list.add(item) : 리스트의 맨 뒤에 데이터를 추가하는 메서드
		list1.add("apple");
		list1.add("kiwi");
		list1.add("mango");
		list1.add("딸기");
		list1.add("오렌지");
		list1.add(10);
		list1.add(99);
		list1.add(new ProgrammingStudent());
		
		System.out.println(list1);
		System.out.println(list2);
		
		// list.get(index) : 리스트의 해당 번째의 요소를 꺼내서 반환해주는 메서드
		// list.size() : 해당 리스트의 크기를 반환
		System.out.println(list1.get(0));
		
		// size()를 통해 리스트의 모든 요소를 쉽게 탐색할 수 있다
		for(int i = 0; i < list1.size(); ++i) {
			System.out.println(list1.get(i));
		}
		
		// 모든 타입은 Object 타입으로 업캐스팅이 가능함
		// 리스트 생성시 타입을 지정하지 않으면 어떤 타입값인지 따로 체크해야하므로
		// 사용하기에 불편하다
		Object obj = list1.get(5);

		// 타입을 지정하면서 리스트 만들기 (제네릭 설정)
		ArrayList<String> countries = new ArrayList<>();
		
		countries.add("America");
		countries.add("South Korea");
		countries.add("Japan");
		countries.add("China");
		
		// 타입을 지정하면 해당 리스트의 메서드들이 요구하는 타입이 전부 변한다
		countries.add("india");
		
		System.out.println(countries);
		System.out.println(countries.get(2));
		
		// add(index, item) : 아이템을 원하는 위치에 추가한다
		countries.add(2, "Franch");
		
		System.out.println(countries);
		// contains(item) : 해당 요소가 리스트에 포함되어 있는지 여부를 리턴해준다
		System.out.println(countries.contains("England"));
		System.out.println(countries.contains("Japan"));
		System.out.println(countries.contains("Korea"));
		System.out.println(countries.contains("South Korea"));
		
		if(countries.contains("Germany")) {
			System.out.println("있습니다.");
		} else {
			System.out.println("없습니다."); 
		}
		
		// remove(index) : 해당 번째의 요소를 지운다,
		// 				   방금 리스트에서 제거한 요소의 값을 반환한다
		// remove(item) : 해당 값을 지닌 요소를 하나 지운다
		String removed = countries.remove(5);
		System.out.println("지워진 것 : " + removed);
		System.out.println(countries);
		
		removed = countries.remove(countries.size() - 1);
		System.out.println("지워진 것 : " + removed);
		System.out.println(countries);
		
		/*
		  	# Java Collection Interface
		  	
		  	- 자바에서 제공하는 자료구조 인터페이스
		  	- Collection은 언제든지 다른 컬렉션으로 쉽게 반환이 가능하다
		  	- Collection은 인터페이스를 구현한 클래스로는 List, Set등이 있다
		*/
		
		ArrayList<String> commies = new ArrayList<>(); 
		
		// 기본형 타입은 <> 내부에 쓸 수 없다. int -> Integer, double -> Double
		ArrayList<Integer> numbers = new ArrayList<>();
	
		numbers.add(10);
		numbers.add(20);
		numbers.add(30);
		
		System.out.println(numbers);
		
		commies.add("North Korea");
		commies.add("China");
		commies.add("Sobiet");
		
		// addAll(Collection) : 다른 컬렉션을 전달하면 모두 더해준다 
		countries.addAll(commies);
		countries.addAll(countries);
		
		System.out.println(countries);
		
		// 값을 전달해 해당 값을 지울 때는 삭제 성공여부가 반환
		boolean delete = countries.remove("Japan");

		System.err.println("삭제 성공 여부 : " + delete);
		System.out.println(countries);
		
		// set(index, item) : 해당 번째의 요소를 수정한다
		countries.set(3, "apple");
		System.out.println(countries);

		// subList(start, end) : 리스트를 원하는 만큼 잘라서 반환한다
		List<String> result = countries.subList(2, 5);
		System.out.println(result);

		// 리스트의 업캐스팅
		// 실제 구현은 다르지만 우리는 신경 안쓰고 똑같은 메서드로 두 클래스를 다룰 수 있음
		List<String> l1 = new ArrayList<>();
		List<String> l2 = new LinkedList<>();
		
		l1.add("AA");
		l2.add("ABC");
	}
	
}
