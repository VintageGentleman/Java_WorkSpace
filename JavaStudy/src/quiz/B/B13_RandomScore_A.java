package quiz.B;

public class B13_RandomScore_A {
	
	/*
	  	1. 100개의 점수(0점 ~ 100점)를 랜덤으로 생성하여 배열에 저장
	  	
	  	2. 배열에 저장된 값을 한 줄에 10개씩 출력
	  	   (60점 미만인 점수는 X로 표시)
	  	   
	  	3. 모든 점수의 평균을 출력 (소수 둘째 자리까지 출력)
	  	
	  	4. 가장 높은 점수와 가장 낮은 점수를 출력
	*/

	public static void main(String[] args) {
		
		int[] score = new int[100];
		
		for (int i = 0; i < 100; ++i) {
			int random = (int) (Math.random() * 101);
			score[i] = random;
		}
		
		int total = 0;
		
		for (int i = 0; i < 100; ++i) {
			String pass = score[i] < 60 ?
					"X\t" : score[i] + "\t";
			System.out.print(pass);
			
			total += score[i];
			
			if ((i + 1) % 10 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		
		System.out.println("전체 평균 : "
				+ Math.round((total / 100.0) * 100) / 100.0);
				
		int maxWinner = 0;
		int minWinner = 100;
		
		for (int i = 0; i < 100; ++i) {
			int winner = maxWinner > score[i] ?
					maxWinner : score[i];	
			maxWinner = winner;
			
			int winner2 = minWinner < score[i] ?
					minWinner : score[i];
			minWinner = winner2;
		}
		
		System.out.printf("최고점은 %d\n최하점은 %d",
				maxWinner, minWinner);

	}
}
