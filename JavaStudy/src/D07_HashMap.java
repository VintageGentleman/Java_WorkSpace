import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class D07_HashMap {

	/*
	  	# Map 
	  
	  	- 데이터를 Key-Value 방식으로 저장하는 자료구조
	  	- 인덱스 번호 대신 Key값을 이용해 가독성을 높인다
	  	- Key값은 중복이 허용되지 않는다
	  	- Value는 중복이 허용된다
	  	- 제네릭을 두 개 사용한다
	*/
	
	public static void main(String[] args) {
		
		HashMap<String, Object> p1 = new HashMap<>();
		
		// map.put(K, V) : 맵에 데이터를 넣는다
		p1.put("name", "홍길동");
		p1.put("age", 17);
		p1.put("math", 99);

		// 이미 존재하는 키값에 데이터를 넣는 경우 값을 덮어쓴다
		p1.put("name", "김철수");
		p1.put("Name", "연개소문");
		
		// "같은 키 값이다"의 기준은 hashCode()메서드의 결과를 통해 판단한다
		p1.put(new String("name"), "이순신");
		
		System.out.println("name".hashCode());
		System.out.println("Name".hashCode());
		System.out.println(new String("name").hashCode());
		
		System.out.println(p1);
		
		// map.get(K) : 키값을 통해 값을 꺼낸다
		System.out.println(p1.get("name"));
		System.out.println(p1.get("age"));
		System.out.println(p1.get("math"));
		System.out.println(p1.get("Name"));

		HashMap<String, String> navigation = new HashMap<>();
		
		navigation.put("우리집", "무슨시 무슨구 무슨동 ... ");
		navigation.put("맛집1", "무슨북도 무슨리 무슨읍 ... ");
		
		// putIfAbsent(K, V)
		// : 최초 추가일 때는 값을 추가하고, 이미 있을 때는 들어있는 값을 꺼내준다
		//   값을 꺼내고 싶을 때 사용하되, 값이 없을까봐 걱정되는 경우 사용
		navigation.putIfAbsent("마트", "서울시 영등포구 여의도동 ..");
		String result 
			= navigation.putIfAbsent("마트", "경기도 구리시 ...");
		
		System.out.println(navigation);
		System.out.println(result);

		// 게임 기록을 저장할 때 최초 기록이라면 데이터를 0으로 초기화하고
		// 이미 점수가 있다면 꺼내주는 역할
		HashMap<String, Integer> scoreboard = new HashMap<>();
		
		scoreboard.put("권영준", 880);
		
		System.out.println(scoreboard.putIfAbsent("권영준", 0));
		System.out.println(scoreboard.putIfAbsent("박정준", 0));
		
		// Map 반복문 사용하기
		
		// map.keySet() : Key들로 이루어진 Set을 반환한다
		Set<String> keys = scoreboard.keySet();
		
		for (String key : keys) {
			System.out.println("Key: " + key);
			System.out.println("Value: " + scoreboard.get(key));
		}
		
		// map.values() : 해당 맵의 값들로 이루어진 Collection을 반환한다
		List<Integer> scoreList =
				new ArrayList<>(scoreboard.values());
		
		System.out.println(scoreList);

		// Value는 반복문을 통해 바로 꺼내볼 수도 있다. 
		for(Integer value : scoreboard.values()) {
			System.out.println(value);
		}
		
		// map.containsKey(K) : 맵에 해당 키값이 있는지 여부를 확인
		System.out.println(scoreboard.containsKey("장영민"));
		System.out.println(scoreboard.containsKey("박정준"));
		
		// map.containsValue(V) : 맵에 해당 값이 있는지 여부를 확인
		System.out.println(scoreboard.containsValue(90));
		System.out.println(scoreboard.containsValue(880));

		// map.putAll(Map) : 맵에 다른 맵을 합친다
		
		// map.remove(K)
		// : 키를 통해 키/값을 지운다. 없는 키값이면 null을 리턴
		// 	 있는 키값이면 삭제하면서 값을 리턴
		System.out.println(scoreboard.remove("이종현")); 
		System.out.println(scoreboard.remove("권영준"));
	}
	
}
