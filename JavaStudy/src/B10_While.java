
public class B10_While {
	
	/*
	  	# while
	  	
	  	- for문과 사용법이 약간 다른 반복문
	  	- 초기값과 증감값의 위치가 정해져 있지 않아 더 자유롭다
	  	- ()안의 내용이 true라면 {}안의 내용을 계속해서 반복한다
	  	- 증감값의 위치에 따라 결과가 달라질 수 있으므로 주의해야 한다
	*/

	public static void main(String[] args) {
		int i = 0;
		while (i < 10) {
			System.out.println(i++);
		}
		
		i = 0;
		while (i < 10) {
			System.out.println(++i);
		}
		
		i = 0;
		while (i++ < 10) {
			System.out.println(i);
		}
		
		// 절대 쓰지 않음 (10이라고 써있지만 9번 반복하므로 가독성이 떨어짐)
		i = 0;
		while (++i < 10) {
			System.out.println(i);
		}
	}

}
