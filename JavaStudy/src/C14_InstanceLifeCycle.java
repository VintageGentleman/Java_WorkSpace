
public class C14_InstanceLifeCycle {
	
	/*
	  	#인스턴스 생명 주기
	  	
	  	- 인스턴스가 생성될 때 실행되는 코드의 순서를 알아보자
	      	
	  	  1. 스태틱 영역 (첫 인스턴스 생성시에 딱 한번 실행)
	  	  2. 인스턴스 영역 (새 인스턴스 생성시 마다 실행)
	  	  3. 생성자 (새 인스턴스 생성시 마다 실행)
	  	
	  	- 매개변수로 전달받을 필요없는 값들 - 각 영역을 사용
	  	- 생성자의 매개변수로 전달받아서 초기화 해야하는 경우 - 생성자
	*/
	
	public static void main(String[] args) {
		TestClass t = new TestClass();
		
		t.doSomething();
		
		for(int i = 0; i < 3; ++i) {
			t = new TestClass();
			t.doSomething();
		}
	}
	
}

class TestClass {
	
	// 스태틱 영역
	static int a = 10;
	static int[] numArr = new int[100];
	
	// 스태틱 블록
	static {
		for(int i = 0; i < numArr.length; ++i) {
			numArr[i] = i;
		}
		System.out.println("스태틱 블록이 실행되었습니다. (이 클래스의 최초 실행시점)");
	}
	
	// 인스턴스 영역
	String text = "Hello!";
	
	// 인스턴스 영역에 중괄호로 블록을 만들 수 있다
	{
		System.out.println("인스턴스 블록이 실행되었습니다.");
	}
	
	// 생성자
	public TestClass() {
		System.out.println("생성자가 실행되었습니다." + text);
	}

	// 인스턴스 메서드
	public void doSomething() {
		System.out.println("메서드가 실행되었습니다.");
	}
}