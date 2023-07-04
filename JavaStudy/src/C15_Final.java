
public class C15_Final {
 
	/*
	  	# final
	  	
	  	- 변수 앞에 final을 붙이면 이후로는 변경할 수 없는 값이 된다 (변하지 않을 상수)
	  	- 메서드 앞에 final을 붙이면 오버라이드가 금지된다
	  	- 클래스 앞에 final을 붙이면 상속이 금지된다
	*/
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		// 변수 선언 시 앞에 final을 붙여주면 해당 변수는 이후 변경 불가능
		final int num = 10;
		final double GA = 9.80665;
		final double PI = 3.14;
		final String GOAT = "메시";
		
		// 나중에 프로젝트가 복잡해졌을 때 실수하는 것을 방지하는 용도 
		
	}
}
