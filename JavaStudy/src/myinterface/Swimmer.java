package myinterface;

public interface Swimmer {
	// abstract : 자식 클래스로 구현을 미룬다
	public abstract void swim();
	
	// abstract public을 생략해도 자동으로 abstract public 메서드가 된다
	// 아무것도 안붙여도 자식 클래스로 구현을 미룬다
	void dive(int meter);
	
}
