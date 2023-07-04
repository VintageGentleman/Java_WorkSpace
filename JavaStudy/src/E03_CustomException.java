
public class E03_CustomException {

	/*
	  	# Exception
	  	
	  	- 반드시 처리해야 하는 예외
	  	- 처리하지 않으면 컴파일을 진행할 수 없다
	  	
	  	# RuntimeException
	  	
	  	- 처리하지 않아도 되는 예외
	*/

	public static void method() throws 반드시처리해야하는예외 {
		int ran = (int)(Math.random() * 10);
		
		if(ran == 7) {
			throw new 반드시처리해야하는예외();
		}
		
		System.out.println("살아남음");
	}
	
	public static void main(String[] args) {
		
		for(int i = 0; i < 10; ++i) {
			try {
				method();
			} catch (반드시처리해야하는예외 e) {
				System.out.println(i + "번째 사람이 사망했습니다.");
				break;
			}
		}
		
	}
	
}

@SuppressWarnings("serial")
class 반드시처리해야하는예외 extends Exception {
	public 반드시처리해야하는예외() {
		super("내가 만든 예외1");
	}
}

@SuppressWarnings("serial")
class 꼭처리하지않아도되는예외 extends RuntimeException {
	public 꼭처리하지않아도되는예외() {
		super("내가 만든 예외2");
	}
}