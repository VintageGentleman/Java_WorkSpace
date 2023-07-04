package quiz.B;

public class B06_ForQuiz_A {

	/*
	 	1. 1000 ~ 2000 사이의 8의 배수를 모두 출력해보세요
	 	
	 	2. 100부터 300까지의 총합을 구해보세요
	 	
	 	3. 1000부터 1500까지 10의 배수를 한 줄에 7개씩 출력해보세요
	*/
	
	public static void main(String[] args) {
		
		for (int i = 1000; i <= 2000; i += 8) {
			System.out.println(i);
		}
		
		int sum = 0;
		
		for (int i = 100; i <= 300; ++i) {			
			sum += i;
		}
		
		System.out.println("2. : " + sum);
		
		for (int i = 1000; i <= 1500; i += 70) {
			
			System.out.print(i + " ");
			
			for (int j = 1; j <= 6; ++j) {
				
				if (i + 10 * j <= 1500) {
					System.out.print(i + 10 * j + " ");
				}
			}
			
			System.out.println();
			
		}		
	}
}
