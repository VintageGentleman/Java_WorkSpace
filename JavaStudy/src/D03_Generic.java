import myobj.FishBread;
import myobj2.MyFactory;

public class D03_Generic {

	/*
	  	# 제네릭 (Generic)
	  	
	  	- 클래스를 정의할 때 나중에 타입을 지정할 수 있도록 설계해두는 것
	  	- 해당 클래스의 인스턴스 생성 시 <>를 통해 제네릭 타입을 지정할 수 있다
	  	- 제네릭에는 기본 타입을 사용할 수 없다
	  	  (Integer, Character, Double, Float, Byte, Boolean, ...)
	  	- 제네릭은 여러개 지정할 수도 있다
	*/
	
	public static void main(String[] args) {
		
		MyFactory<Apple, FishBread> appleFactory = new MyFactory<>();
		
		appleFactory.putMaterial(new Apple());
		
		FishBread f = appleFactory.getProduct();
		
		System.out.println(f);
	}
}
