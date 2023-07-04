@SuppressWarnings("unused")
public class C12_InnerClass {
	
	/*
	  	# 클래스 내부에도 클래스를 만들 수 있다
	  	
	  	- 인스턴스 클래스 : 인스턴스 변수에 영향을 받는다
	  	- 스태틱 클래스 : 인스턴스와 무관하다
	*/

	class Bus {
		int fee;
		int num;
	}
	
	static class Subway {
		int fee;
		int num;
	}
	
	public static void main(String[] args) {
		
		// 바깥 클래스의 실체가 생길 때 내부의 인스턴스 클래스를 사용할 수 있게 된다
		C12_InnerClass.Bus b = new C12_InnerClass().new Bus();
		
		// 스태틱 클래스는 바깥 클래스의 인스턴스 없이도 사용할 수 있다
		C12_InnerClass.Subway s = new C12_InnerClass.Subway();
		
	}
}
