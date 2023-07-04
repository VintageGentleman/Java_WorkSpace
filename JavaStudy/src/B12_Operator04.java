
public class B12_Operator04 {
	
	/*
	  	# 삼항 연산자
	  	
	  	- 간단한 if문을 한 줄로 사용할 수 있는 연산자
	  	- 비교 ? 예 : 아니오;
	  	- 비교의 결과가 true라면 : 왼쪽의 값을 사용한다
	  	- 비교의 결과가 false라면 : 오른쪽의 값을 사용한다
	*/

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		int result = false ? 1 : 10;
		
		System.out.println(result);
		
		// 사과의 개수가 나누어 떨어질 때는 1을 더하지 않은 값을 사용
		// 사과의 개수가 나누어 떨어지지 않을 때는 1을 더한 값을 사용
		int apple = 220;
		int basket = apple % 10 == 0 ? apple / 10 : apple / 10 + 1;
		// 비교 ? 예 : 아니오;
		
		System.out.println("필요한 바구니의 개수는 " + basket);
		
		// 삼항연산자를 if문으로 나타냈을 때
		if (apple % 10 == 0) {
			basket = apple / 10;
		} else {
			apple = apple / 10 + 1;
		}
	
		// type만 일치하면 String으로 표현도 가능. 한쪽이 다른 타입이어서는 안됨
		String message = apple % 10 == 0 ?
				"10으로 나누어 떨어집니다" : "안 떨어져서 1을 더합니다";
		
		System.out.println(message);
		
	}

}
