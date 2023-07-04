
public class C01_Function {
	
	/*
	  	# 함수 (Function)
	  	
	  	- 기능을 미리 정의해두고 나중에 불러다 쓰는 것
	  	- 함수를 정의한 시점에서는 아무것도 실행되지 않고
	      어딘가에서 불러다 써야 실행된다
	    - 나중에 재사용 할 가능성이 있는 코드들을 함수로 만들어두면
	      작업의 반복을 줄일 수 있다
	      
	    # 함수의 매개변수 (argument)
	    
	    - 함수를 호출할 때 해당 함수에 전달할 수 있는 값
	    - 함수를 호출할 때 ()에 전달하는 값을 인자라고 한다
	    - 함수를 정의할 때 ()에 선언하는 인자를 받을 수 있는 변수를
	      매개변수라고 한다
	    - 매개변수의 개수에는 제한이 없다
	    - 매개변수 타입에 ...을 찍으면 인자를 무한대로 받을 수 있다
	    
	    # 함수의 타입 (리턴 타입)
	    
	    - 함수의 타입은 함수 실행 결과 돌아오는 값의 타입을 의미한다
	    - void : 이 함수는 실행하고나면 아무 값도 돌아오지 않는다
	    - 그 외 : 이 함수는 실행하고 나면 해당 타입 값을 반드시 돌려준다  
	*/

	public static int getBasket(int apple) {
		if (apple % 10 == 0) {
			return apple / 10;
		} else {
			return apple / 10 + 1;
		}
	}
	
	public static void plusAll(int... nums) {
		// ...으로 받은 매개변수는 자동으로 배열이 되어 있다
		int sum = 0;
		for (int i = 0; i < nums.length; ++i) {
			sum += nums[i];
		}
		System.out.println("sum: " + sum);
	}
	
	/**
	 * 이 함수는 사과의 개수를 입력하면 필요한 바구니의 개수를 출력해주는 함수이다. 
	 * @param apple - 사과의 개수를 입력해주셈 (0 이상)
	 * @param size - 바구니의 크기를 입력해주셈 (1 이상)
	 */
	public static void howManyBasket(int apple, int size) {
		if (apple % size == 0) {
			System.out.println("basket : " + apple / size);
		} else {
			System.out.println("basket : " + (apple / size + 1));
		}
	}
	
	public static void plus(int a, int b) {
		System.out.println("plus 결과: " + a + b);
	}
	
	public static void rabbit() {
		System.out.println(" /)/)");
		System.out.println("(  ..)");
		System.out.println("(  >$)");
	}
	
	public static void main(String[] args) {
		rabbit();
		plus(33,30);
		plus(123,456789);
		howManyBasket(80,10);
		howManyBasket(81,10);
		
		// 매개변수 ...에는 인자값을 주고 싶은만큼 줄 수 있다
		plusAll(10, 99, 88, 123, 943324, 123123);
		plusAll(10, 323, 32323, 1123123);
		plusAll(10);
		plusAll();
		
		// 리턴 타입이 void가 아닌 함수는 실행 결과가 호출한 장소에 돌아온다 (return)
		int basket = getBasket(13) + getBasket(55) + getBasket(99);
		System.out.println(basket);
		
	}

}
