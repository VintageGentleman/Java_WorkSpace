package myobj;

public class Orange {
	
	public String country;
	public int price;
	public char grade;
	
	// 생성자 : 클래스 이름과 똑같은 이름의 메서드, 리턴 타입이 없다
	// 해당 클래스의 인스턴스가 만들어질 때 가장 먼저 호출된다
	public Orange() {
		this("제주도", 2000, 'B');
	}
	
	// 생성자 오버로딩 : 클래스는 다양한 오버로딩의 생성자를 가질 수 있다
	public Orange(String country) {
		this(country, 2000, 'B'); // 다른 생성자 호출, 생성자 맨 윗줄에서만 사용 가능
	}
	
	// 생성자는 주로 인스턴스 생성과 동시에 인스턴스 변수를 초기화할 때 사용된다
	public Orange(String country, int price, char grade) {
		this.country = country; 
		this.price = price;
		this.grade = grade;
	}
	
	@SuppressWarnings("unused")
	public void info() {
		// 메서드 내부에 인스턴스 변수와 같은 이름의 변수가 존재할 때
		// this를 통해 정확하게 구분할 수 있다
		// 메서드 내부에 겹치는 이름의 변수가 없다면 this를 생략해도 무방하다
		
		// 사용하면 안되는 변수들
		int country = -1;
		double price = 123.123;
		String grade = "ABC";
		 
		// this를 통해 인스턴스 영역의 변수들을 가져올 수 있다
		System.out.printf("원산지: %s\n가격: %d\n등급: %c\n",
				this.country, this.price, this.grade);
	}

}
