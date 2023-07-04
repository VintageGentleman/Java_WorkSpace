import myobj.Card;

public class C06_StaticMethod {
	
	/*
	  	# 인스턴스 변수
	  	
	  	- 각 인스턴스 마다 다른 값을 지니는 변수
	  	- new를 통해 인스턴스가 생성된 이후부터 활용할 수 있다
	  	
	  	# 인스턴스 메서드
	  	
	  	- 인스턴스 변수를 활용하기 때문에 각 인스턴스 마다 다른 결과를 내는 메서드
	  	- new를 통해 인스턴스가 생성된 이후부터 활용할 수 있다
	  	
	  	# 스태틱 변수
	  	
	  	- 모든 인스턴스에서 함께 사용하는 변수
	  	- 한 클래스에 하나밖에 없다 (클래스 변수)
	  	- 해당 클래스의 인스턴스가 하나도 없는 상황에서도 사용할 수 있다 
	  	
	  	# 스태틱 메서드
	  	
	  	- 스태틱 변수만 활용할 수 있는 메서드 (인스턴스 변수는 활용할 수 없다)
	  	- 스태틱 변수만 활용할 수 있기 때문에 모든 인스턴스에서 같은 결과가 나온다
	  	- 해당 클래스의 인스턴스가 하나도 없는 상황에서도 사용할 수 있다
	*/

	@SuppressWarnings("static-access")
	public static void main(String[] args) {

		System.out.println("카드의 너비 : " + Card.width);
		System.out.println("카드의 높이 : " + Card.height);
		
		Card.changeCardSize(100, 200);
		
		System.out.println("카드의 너비 : " + Card.width);
		System.out.println("카드의 높이 : " + Card.height);
		
		Card c1 = new Card('★', 5);
		Card c2 = new Card('△', 123);
		
		// 인스턴스가 수천개 있어도 static 자원은 하나이기 때문에
		// 클래스 이름에 .을 찍고 접근하는 것이 올바른 방식이다
		System.out.println("c1의 너비: " + c1.width);
		System.out.println("c1의 너비: " + c2.width);
		
		// 인스턴스를 만들어주는 스태틱 메서드를 사용
		Card c3 = Card.getRandomCard();
		
		System.out.println(c3.shape);
	}

}
