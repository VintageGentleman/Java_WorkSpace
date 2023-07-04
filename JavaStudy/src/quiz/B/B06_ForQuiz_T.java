package quiz.B;

public class B06_ForQuiz_T {

	/*
	 	1. 1000 ~ 2000 사이의 8의 배수를 모두 출력해보세요
	 	
	 	2. 100부터 300까지의 총합을 구해보세요
	 	
	 	3. 1000부터 1500까지 10의 배수를 한 줄에 7개씩 출력해보세요
	*/
	
	public static void main(String[] args) {
		
		// for문 안에 if문도 함께 사용할 수 있다
		for (int num = 1000; num <= 2000; ++num) {
			if(num % 8 == 0) {
				System.out.println(num);
			}
		}
		
		// 총합을 구할 때는 총합을 저장할 변수를 하나 선언하고 계속 더한다
		int total = 0;
		
		for (int num = 100; num <= 300; ++num) {
			total += num;
		}
		
		System.out.println("총합은 " + total + "입니다. ");
		
		// 10의 배수가 등장할때마다 개수를 세서 '\n'을 한번씩 출력해준다
		
		// 초기값 선언하는 장소에 한번에 여러 변수를 초기화 할 수 있다
		for (int num = 1000, count = 0; num <= 1500; ++num) {
			if (num % 10 == 0) {
				System.out.printf("%d[%d번째] ", num, count);
				
				// count가 10의 배수일때만 증가해야 한다..
				// 후위 표기법을 사용해서 비교를 먼저 한 뒤 count가 증가한다
				if (count++ == 6) {
					System.out.print("\n");
					count = 0; // 줄을 한 번 바꾸고나면 count를 다시 0으로 초기화
				}
			}
		}
	}
}
