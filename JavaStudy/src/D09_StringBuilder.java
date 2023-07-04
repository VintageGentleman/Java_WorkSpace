
public class D09_StringBuilder {

	/*
	  	# StringBuilder
	  	
	  	- 문자열을 조립할 때 쓰는 기능들이 모여있는 클래스
	  	- += 연산을 통해 문자열을 조립하는 것보다 속도가 훨씬 빠르다
	*/
	
	public static void main(String[] args) {
		String str = "";
		
		str += 'a';
		str += 'b';
		str += 'c';
		str += 'd';
		
		System.out.println(str);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append('a');
		sb.append('b');
		sb.append('c');
		sb.append('d');
		
		@SuppressWarnings("unused")
		// 다 만들고 나면 toString();
		String s = sb.toString();
		
		System.out.println(sb);
		
		// 조립하던 문자열을 뒤집는다
		sb.reverse();
		sb.append('a');
		sb.append('b');
		sb.append('c');
		sb.append('d');
				
		System.out.println(sb);
		
		// delete(start, end) : 원하는 만큼 문자를 지운다
		// : 원하는 만큼 문자를 지운다 (start 이상, end 미만)
		sb.delete(3, 5);
		
		System.out.println(sb);
		
		// substring(start, end) 
		// : 조립하던 문자열을 잘라서 반환한다 (원본은 그대로 남아있음)
		String sub = sb.substring(3, 5);
		
		System.out.println(sb);
		System.out.println(sub);
		
		// 다른 타입 값도 추가 가능 (해당 타입의 toString() 결과를 추가)
		sb.insert(3, true);
		sb.append(false);
		
		System.out.println(sb);
	}
	
}
