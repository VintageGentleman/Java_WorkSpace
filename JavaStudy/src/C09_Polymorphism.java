import myobj.*;

public class C09_Polymorphism {
	
	/*
	  	# 객체의 다형성
	  	
	  	- 객체는 다양한 형태를 지닐 수 있다는 성질
	  	- 강아지는 강아지이기도 하고 동물이기도 하다
	  	- 아메리카노는 아메리카노이기도 하고 커피이기도 하다
	  	- 하지만, 커피는 아메리카노가 아니다
	  	
	  	# 업 캐스팅
	  	
	  	- 자식 타입은 아무런 문제 없이 부모 타입이 될 수 있다
	  	- 자식 타입은 이미 내부에 부모 타입의 모든 것을 지니고 있기 때문에 (super)
	  	  부모 타입으로 타입 캐스팅 되는 것은 아무런 문제가 없다
	  	- 업 캐스팅 된 상태에서는 자식 클래스 형태일 때 가지고 있던 기능을 
	  	  사용할 수 없다 
	  	  (ex: 아메리카노가 커피 형태일 때는 putWater()를 사용할 수 없다)
	  	  
	  	# 다운 캐스팅
	  	
	  	- 부모 타입은 일반적으로 자식 타입이 될 수 없다
	  	- 하지만, 부모 타입으로 업캐스팅 되어 있는 인스턴스의 경우
	  	  다시 원래의 타입으로 다운 캐스팅 될 수 있다
	  	  (ex: 일시적으로 커피가 되어있는 아메리카노는 다시 아메리카노로 변할 수 있다)
	  	  
	  	# instanceof 연산자
	  	
	  	- 해당 인스턴스가 특정 클래스의 인스턴스인지 검사해주는 연산자
	  	- 결과는 true/false로 알려준다
	  	- var instanceof ClassName
	  	
	  	ex: c1 instanceof Coffee, c2 instanceof Americano
	*/

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		// 아메리카노는 커피가 될 수 있다
		// (자식 클래스는 부모 클래스 타입으로 변할 수 있다, 업 캐스팅)
		Coffee c1 = new Americano();
		Americano c2 = new Americano();
		
		// c1.putWater(100);
		c2.putWater(100);
	
		// 커피는 아메리카노가 될 수 없다
		// (부모 클래스는 일반적으로 자식 클래스 타입으로 변할 수 없다, 다운 캐스팅)
		// Americano a1 = new Coffee(1, 2, "abc");
		
		// 업 캐스팅
		Ball b1 = new BasketBall();
		Ball b2 = new SoccerBall();
		
		// 가능한 다운 캐스팅
		// (원래 아메리카노 인스턴스였던 커피 인스턴스는 다시 아메리카노 인스턴스가 될 수 있다)
		Americano a2 = (Americano) c1;
		
		a2.putWater(111);
		a2.putWater(50);
		
		a2.check();

		// 불가능한 다운 캐스팅
		// 원래 커피였던 인스턴스를 아메리카노로 다운 캐스팅하는 것은 가능하지만
		// 에러가 발생한다 - class Coffee cannot be cast to class Americano
		// 강제 다운 캐스팅은 빨간줄 에러로 발견해주지 못하기 때문에 각별한 주의가 필요하다
		Coffee c3 = new Coffee(3, 1500, "Espresso");
		// Americano a3 = (Americano) c3;
		
		c3 = new Americano();
		
		System.out.println(c3 instanceof Coffee);
		System.out.println(c3 instanceof Americano);
		
		if(c3 instanceof Americano) {
			((Americano) c3).check();
		}
		
		// Coffee타입 매개 변수에는 Coffee타입이 될 수 있는 모든 것을 전달할 수 있다
		drinkCoffee(new Americano());
		drinkCoffee(c3);
		drinkCoffee(c1);
		drinkCoffee(c2);
	}
	
	// 매개 변수에 부모 타입을 사용하면 자식 타입 인스턴스를 전달할 수 있다
	public static void drinkCoffee(Coffee coffee) {
		// 업캐스팅 된 객체도 오버라이드 메서드를 실행한다
		coffee.drink();
	}

}
