import myinterface.Runner;
import myinterface.Swimmer;
import myobj2.Bear;
import myobj2.Shark;

public class C17_Interface {

	/*
	  	# 인터페이스(Interface)
	  	
	  	- 추상 클래스처럼 내부에 추상 메서드를 지닐 수 있다
	  	- 인터페이스 내부에 선언하는 모든 변수들은 자동으로 final static이 된다
	  	- 인터페이스 내부에 선언하는 메서드는 모두 자동으로 abstract public이 된다
	  	- 추상 클래스는 하나밖에 상속받을 수 없지만, 인터페이스는 여러개 구현 받을 수 있다.
	  	- 인터페이스를 통해 하나의 클래스가 더욱 다양한 형태를 지닐 수 있게 된다 
	  	- 추상 클래스에서는 인스턴스 영역이 존재하지만 인터페이스에는 인스턴스 영역이 아예 없다
	*/

	// 뭐가 올지 모르겠지만 뛸 수 있는 것은 모두 전달될 수 있는 메서드
	public static void run(Runner r) {
		r.run();
	}
	
	// 뭐가 올지 모르겠지만 수영할 수 있는 것은 모두 전달될 수 있는 메서드
	public static void swim(Swimmer s) {
		s.swim();
		s.dive(10);
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Bear b = new Bear();
		Shark s = new Shark();
		
		// 인터페이스 타입으로 변수를 선언할 수 있고 업캐스팅이 가능
		Swimmer swim1 = b;
		Swimmer swim2 = s;
		
		Runner run1 = b;
		
		run(new Bear());
		run(new Bear());
		
		swim(new Bear());
		swim(new Shark());
	}
}
