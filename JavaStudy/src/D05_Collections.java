import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class D05_Collections {

	/*
	  	# java.util.Arrays
	  	
	  	- 배열을 편하게 다룰 수 있는 메서드들을 모아놓은 클래스
	  	
	  	# java.util.Collections
	  	
	  	- 컬렉션을 편하게 다룰 수 있는 메서드들을 모아놓은 클래스
	*/
	
	public static void main(String[] args) {
		
		// Arrays.fill(arr, value) : 전달한 배열을 원하는 값으로 초기화 한다 
		int[] intArr = new int[10];
		
		Arrays.fill(intArr, -5);
		
		System.out.println(Arrays.toString(intArr));
		
		intArr[3] = 9;
		intArr[8] = 9;
		
		// Arrays.binarySearch(arr, value) 
		// : 원하는 값을 찾고 해당 인덱스를 반환한다.
		// 	 값이 여러개라면 무엇이 찾아질지는 보장할 수 없다
		System.out.println(Arrays.binarySearch(intArr, 9));	
		
		// Arrays.copyOf(origin, newLength)
		// : 전달한 배열의 복사본을 만들어준다. 주로 배열의 크기를 늘리는데 사용한다
		int[] arr2 = Arrays.copyOf(intArr, 20);
		System.out.println(Arrays.toString(arr2));
		
		int[] stu1 = {10, 20, 30, 40, 50};
		int[] stu2 = {10, 20, 30, 990, 50, 60, 1, 2, 3};
		int[] stu3 = {10, -20, -30, 40, -50};
		
		// Arrays.compare(arr1, arr2)
		// : 두 배열을 비교해 결과를 알려준다
		//   왼쪽이 더 크면 1, 두 배열이 같으면 0, 오른쪽이 더 크면 -1
		//   각 인덱스를 순차적으로 비교하여 먼저 큰 값이 나오는 쪽이 큰 걸로 계산, 길이 무관.
		// 어떤 메서드에 unsigned가 붙어있으면 부호를 무시하는 메서드이다
		int compareResult = Arrays.compare(stu1, stu2);
		System.out.println("compareResult: " + compareResult);
		
		// Arrays.sort(arr) : 전달한 배열을 크기순으로 정렬해준다.
		Arrays.sort(stu3);
		System.out.println(Arrays.toString(stu3));
		
		// Collecions.addAll(Collections, values...)
		// : 값을 한 번에 추가할 때 사용한다
		List<Integer> nums = new ArrayList<>();  
				
		Collections.addAll(nums, 99, -1, 550, 33, 2, 7, 70, 80);
		System.out.println(nums);
		
		// Collections.sort(Collection) 
		// : 해당 리스트를 크기순으로 정렬한다 (Set은 순서가 없기 때문에 정렬 불가능)
		Collections.sort(nums);
		System.out.println(nums);
		
		// Collections.copy(dest, src)
		// : src에서 dest로 값을 복사한다
		//   dest의 크기가 src보다 작다면 에러가 발생할 수 있다.
		List<String> snacks = new ArrayList<>();
		List<String> snacks2 = new ArrayList<>();
		
		Collections.addAll(snacks, "초코파이", "오예스", "프링글스", "쿠크다스");
		Collections.addAll(snacks2, "a", "b", "c", "d");
		
		Collections.copy(snacks2, snacks);
		
		System.out.println(snacks2);
		
		// Collections.shuffle(list) : 전달한 리스트의 순서를 섞는다
		snacks.addAll(snacks);
		snacks.addAll(snacks);
		
		Collections.shuffle(snacks);
		System.out.println(snacks);
		
		// Collections.fill(List, value) : 전달한 값으로 해당 리스트를 초기화한다
		Collections.fill(snacks2, "아폴로");
		System.out.println(snacks2);
		
		// Collections.frequency(Collections, value)
		// : 해당 값이 몇 번 나오는지 세어준다
		int howMany = Collections.frequency(snacks, "허니버터칩");
		System.out.println(howMany);
		
	}
	
}
