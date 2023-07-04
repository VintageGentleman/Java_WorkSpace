
public class C10_Object {
	
	/*
	  	# Object class
	  	
	  	- 모든 자바 클래스들의 최고 조상 클래스
	  	- 모든 클래스는 Object 클래스의 자식이다
	  	- Object 클래스의 메서드는 모든 클래스 내부에 상속받아져서 존재하고 있다
	  	- Object 클래스의 메서드는 주로 해당 클래스에 맞는 형태로
	  	  오버라이드 하여 사용하게끔 설계되어 있다
	  	  
	  	# toString()
	  	
	  	- '해당 객체를 문자열로 표현한다면 어떤 모양이어야 하는가'를 정의하는 메서드
	  	- 모든 객체는 toString()을 통해 문자열로 표현할 수 있다
	  	- Object 클래스에 정의 되어있는 toString() 메서드의 원형은
	  	  해당 클래스의 이름과 메모리상 주소를 출력하게 되어있다
	  	- 기본 동작이 싫다면 자식 클래스에서 해당 메서드를 오버라이드하여 사용하면 된다
	  	
	  	# equals(obj)
	  	
	  	- '해당 객체로 만들어진 두 인스턴스가 같은지 판정하려면 어떻게 해야하는가'
	  	  를 정의하는 메서드
	  	- 매개변수로 전달받은 인스턴스와 this를 비교하여 결과를 리턴한다
	  	- Object 클래스에 정의되어 있는 기본 동작은 해당 인스턴스의 
	  	  주소값을 비교하게 되어있다
	  	  
	  	# Hash 알고리즘
	  	
	  	  hello!	 	=>		A123D234FF63218796...
	  	  hello!		=>		A123D234FF63218796...
	  	  Hello! 		=>		FF124213...
	  	  hello			=>		DDA4123A...
	  	  apple			=> 		FF12341241...
	  	  
	  	- 같은 값을 넣으면 예측하기 힘든 일정한 값이 나와야 한다
	  	- 해쉬 알고리즘을 통해 얻어낸 해쉬 코드로는 원래 값을 알아낼 수 없어야 한다  
	  	- 쉬운 단어들로 미리 해쉬코드들을 제작해놓고 대조해보는 공격 기법에는 취약할 수 있다
	  	  (레인보우 테이블)
	  	  
	  	# hashCode()
	  	
	  	- 해당 인스턴스의 지문 역할을 하는 메서드
	  	- 해당 인스턴스의 고유 번호를 리턴해야 한다
	  	- hash: 같은 값을 넣으면 예측이 불가능한 같은 값이 나와야하는 알고리즘
	  	- Object 클래스의 기본 동작은 해당 인스턴스의 주소값을 리턴하는 것이다
	  	
	  	연습문제: 적당한 클래스를 하나 설계하고
	  	 	toString(), equals(), hashCode()를 모두 오버라이드 해보세요
	*/

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Apple a = new Apple();
		Coffee c = new Americano();
		Coffee c2 = new CafeLatte(1, 2, "a");
		
		Prize p = new Prize("경차", 500, 0.001);
		Prize p2 = new Prize("냉장고", 200, 0.002);
		Prize p3 = new Prize("커피포트", 10, 0.01);
		Prize p4 = new Prize("커피포트", 10, 0.01);
		Prize p5 = new Prize("커피포트", 10, 0.01);
		Prize p6 = new Prize("커피포트", 10, 0.01);
		Prize p7 = new Prize("커피포트", 10, 0.01);
		
		// 내가 만든적 없지만 Object는 모든 클래스의 부모이므로 
		// toString() 같은 Object 메서드들은 반드시 존재할 수밖에 없다
		String str = p.toString();
		
		// System.out.println()은 전달한 인스턴스의 toString()을
		// 호출한 후 그 결과를 콘솔에 찍어주는 메서드이다
		System.out.println(str);
		System.out.println(p2);
		System.out.println(p3);
		
		System.out.println(p3 == p7);
		System.out.println(p3.equals(p7));
		System.out.println("abc".equals("abc"));
		
		System.out.println(p3.hashCode());
		System.out.println(p4.hashCode());
		
	}

}

class Prize {
	// 인스턴스 변수들은 초기화하지 않아도 0, false, null등으로 초기화 된다
	String name;
	int price;
	double rate;
	
	public Prize(String name, int price, double rate) {
		this.name = name;
		this.price = price;
		this.rate = rate;
	}
	
	// 부모 타입의 메서드를 마음대로 내가 수정하여 사용하는 것
	@Override
	public String toString() {
		return price + "만원 상당의 가치를 지닌 " + name + "입니다."
				+ "(당첨확률" + rate * 100 + "%)";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Prize)) {
			return false;
		}
		
		// 현재 인스턴스와 전달받은 인스턴스가 같은 객체인지 여부를 리턴해야 한다
		Prize p1 = this;
		Prize p2 = (Prize) obj;
		
		// 당첨확률과 상품명이 같으면 같은 상품으로 인정하겠다
		return p1.rate == p2.rate && p1.name.equals(p2.name);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}