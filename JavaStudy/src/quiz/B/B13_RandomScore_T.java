package quiz.B;

public class B13_RandomScore_T {
	
	/*
	  	1. 100개의 점수(0점 ~ 100점)를 랜덤으로 생성하여 배열에 저장
	  	
	  	2. 배열에 저장된 값을 한 줄에 10개씩 출력
	  	   (60점 미만인 점수는 X로 표시)
	  	   
	  	3. 모든 점수의 평균을 출력 (소수 둘째 자리까지 출력)
	  	
	  	4. 가장 높은 점수와 가장 낮은 점수를 출력
	*/

	public static void main(String[] args) {
		
		// 1.
		int[] scores = new int[100];
		
		for (int i = 0; i < scores.length; ++i) {
			scores[i] = (int)(Math.random() * 101);
		}
		
		// 2.
		for (int i = 0; i < scores.length; ++i) {
			
			if (scores[i] >= 60) {
				System.out.printf("%-4d", scores[i]);
			} else {
				System.out.printf("%-4c", 'X');
			}
			
			if(i % 10 == 9) {
				System.out.print("\n");
			}
		}
		
		// 3.
		int sum = 0; 
		for (int i = 0; i < scores.length; ++i) {
			sum += scores[i];
		}
		
		double avg = 
				Math.round(sum / (double) scores.length * 100) / 100.0;
		
		System.out.println("총점: " + sum);
		System.out.println("평균: " + avg);
		
		// 4.
		// 첫 번째 점수로 두 값을 초기화
		int best = scores[0];
		int worst = scores[0];
		
		//  두 번째 점수부터 체크를 시작한다
		for (int i = 1; i < scores.length; ++i) {
			// 현재 best에 들어있는 값보다 더 큰 점수가 있다면 best를 교체한다
			if (best < scores[i]) {
				best = scores[i];
			}
			
			// 현재 worst에 들어있는 값보다 더 작은 점수가 있다면 worst를 교체한다
			if (worst > scores[i]) {
				worst = scores[i];
			}
		}
		System.out.printf("최고점은 %d\n최하점은 %d", best, worst);
	}
}
