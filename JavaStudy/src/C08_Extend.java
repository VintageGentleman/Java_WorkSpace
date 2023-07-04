
public class C08_Extend {
	
	/*
	  	# 클래스 상속
	  	
	  	- 이미 만들어져 있는 클래스를 그대로 물려받아 사용하는 문법
	  	- 자식 클래스는 부모 클래스의 모든 변수와 메서드를 물려받아 가지고 있다
	  	- 부모 클래스에게 물려받은 기능을 그대로 사용할 수도 있지만
	      자식 클래스에서 마음대로 고쳐서 사용할 수도 있다.
	      (기존의 변수, 메서드를 수정해서 사용하기 - 오버라이드)
	    - 부모 클래스에 없는 기능을 자식 클래스에서 새로 추가해서 사용할 수도 있다
	      (새로운 변수, 메서드를 추가해서 사용하기)
	    - 자식 클래스는 반드시 부모 클래스의 생성자를 가장 먼저 호출해야 한다  
	    
	    # super
	    
	    - 자식 클래스로 생성된 인스턴스는 두 부분으로 분류할 수 있다
	    - this는 해당 인스턴스의 자식 클래스 부분을 의미한다
	    - super는 해당 인스턴스의 부모 클래스 부분을 의미한다
	    - this()는 현재 클래스의 다른 생성자를 의미한다
	    - super()는 부모 클래스의 생성자를 의미한다
	    
	    연습문제 : myobj 패키지에 상속 관계에 있는 클래스들을 정의해보세요
	*/

	public static void main(String[] args) {
		Americano c1 = new Americano();
		Coffee c2 = new Coffee(3, 3500, "진한 커피");
		
		// 부모 클래스인 Coffee 클래스의 변수와 메서드를 그대로 물려받아 사용중
		c1.shot = 3;
		c2.shot = 4;
		
		c2.drink();
		
		// 자식 클래스에서 마음대로 덮어쓴 기능이 우선적으로 동작한다
		c1.drink();
		// 자식 클래스에만 존재하는 새로운 기능
		c1.putWater(100);
		// 부모 클래스에서는 자식 클래스에서 추가한 기능을 사용할 수 없다
		// c2.putWater(100);
		
		System.out.println(c1.water);
		
		c1.thisDrink();
		c1.superDrink();
	}

}

class Coffee {
	int shot;
	int price;
	String name;
	
	// 생성자를 하나도 정의하지 않았을 때는 아무것도 없는 기본 생성자를 제공하지만
	// 생성자를 하나라도 만든 경우에는 기본 생성자를 자동으로 제공해주지 않는다
	public Coffee(int shot, int price, String name) {
		this.shot = shot;
		this.price = price;
		this.name = name;
	}
	
	void drink() {
		System.out.println("커피를 마셔서 " + this.shot + "만큼 잠이 깼습니다");
	}
	
	void addShot(int toAdd) {
		this.shot += toAdd;
	}
}

class CafeLatte extends Coffee {
	public CafeLatte(int shot, int price, String name) {
		super(shot, price, name);
	}
}

// Coffee 클래스를 상속받은 자식 클래스 Americano
class Americano extends Coffee {
	
	// 부모 클래스에는 없고 자식 클래스에만 존재하는 변수와 메서드 (새로운 기능 추가)
	int water;

	// 자식 클래스는 반드시 생성자에서 부모 클래스의 생성자를 가장 먼저 호출해야 한다
	// 부모 클래스에 기본 생성자가 존재하는 경우 super()를 생략할 수 있지만
	// 부모 클래스에 기본 생성자가 존재하지 않는 경우에는 생략이 불가능하다
	public Americano() {
		super(2, 1500, "아메리카노");
	}
	
	void putWater(int ml) {
		this.water += ml;
	}
	
	// 부모 클래스에는 이미 존재하는 기능을 마음대로 덮어써서 사용하기 (오버라이드, override)
	@Override
	void drink() {
		System.out.println("아메리카노는 물을 타서 밍밍합니다");
	}
	
	// 오버라이드 되었더라도 부모 클래스의 메서드를 불러다 사용하는 것이 가능하다
	void superDrink() {
		super.drink();
	}
	
	void thisDrink() {
		this.drink();
	}
	
	void check() {
		if(water < 100) {
			System.out.println("현재 상태는 매우 진한 아메리카노 입니다");
		} else if(water < 200) {
			System.out.println("현재 상태는 약간 진한 아메리카노 입니다");
		} else if(water < 300) {
			System.out.println("현재 상태는 평범한 아메리카노 입니다");
		} else if(water < 400) {
			System.out.println("현재 상태는 약간 연한 아메리카노 입니다");
		} else if(water < 500) {
			System.out.println("현재 상태는 연한 아메리카노 입니다");
		}
	}
}