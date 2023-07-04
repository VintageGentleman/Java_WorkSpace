
public class C11_AccessModifier extends myobj.C11_ModifierTest {
	
	// protected가 붙은 자원은 다른 패키지에서 상속을 받으면 사용할 수 있다
	public C11_AccessModifier() {
		System.out.println("public value: " + super.i1);
		System.out.println("protected value: " + super.i2);
	}
	
	/*
	  	# 접근 제어자 (Access Modifier)
	  	
	  	- 다른 클래스에서 해당 자원을 사용하려고 할 때 허용 범위를 설정한다
	  	- 같은 패키지의 다른 클래스가 접근할 때
	  	- 다른 패키지의 다른 클래스가 접근할 때
	  	
	  	# 종류
	  	
	  	- public	: 다른 패키지의 다른 클래스에서도 해당 자원에 자유롭게 접근할 수 있다
	  	- protected	: 다른 패키지의 다른 클래스에서 해당 자원에 접근하려면 상속을 받아야 한다
	  	- default	: (접근 제어자 미설정) 다른 패키지에서는 접근할 수 없다
	  	- private	: 같은 패키지의 다른 클래스에서도 접근할 수 없다
	  				  현재 클래스에서만 사용할 수 있는 자원이 된다
	  				  
	  	# 용도
	  	
	  	- 내가 만든 클래스를 가져다 쓰는 사람이
	  	  public 접근 제어자를 지닌 자원에만 접근하는 것을 원하기 때문 
	  	- 클래스 내부의 모든 리소스에 접근 권한을 주게 되면
	  	  설계 의도대로 사용하지 않을 가능성이 있기 때문에 접근을 제한한다
	*/

	public static void main(String[] args) {
		// 같은 패키지의 다른 클래스에서 사용할 수 있는 자원은
		// public, protected, default이다
		C11_ModifierTest.m11();
		C11_ModifierTest.m12();
		C11_ModifierTest.m13();
		
		C11_ModifierTest instance = new C11_ModifierTest();
		
		instance.m1();
		instance.m2();
		instance.m3();
		
		// 다른 패키지의 다른 클래스에서 상속을 받지 않고 사용할 수 있는 자원은
		// public 밖에 없지만
		// 상속을 받으면 추가로 protected까지 사용할 수 있게 된다
		// main method는 static method이기 때문에 static 자원만 사용할 수 있다
		myobj.C11_ModifierTest.m11();
		myobj.C11_ModifierTest.m12(); // protected
		
		// 상속받은 클래스 내부에 있긴 하지만 상속받은 클래스의 인스턴스가 아님
		// (protected 못씀)
		myobj.C11_ModifierTest instance2 = new myobj.C11_ModifierTest();
		instance2.m1();
		// intstance2.m2();
		// intstance2.m3();
		// intstance2.m4();

		// 상속받은 클래스의 인스턴스임
		C11_AccessModifier instance3 = new C11_AccessModifier();
		instance3.m2();
	}

}
