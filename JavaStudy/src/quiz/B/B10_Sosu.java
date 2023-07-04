package quiz.B;

public class B10_Sosu {

	// while문만 사용해서 1000 미만의 소수를 모두 구해보세요
	
	public static void main(String[] args) {
		
		int number = 2;
		
		while (number < 1000) {
			
			boolean sosu = true;
			
			double numberRoot = Math.sqrt(number);
			
			int divider = 2;
			while(sosu && divider <= numberRoot) {
				sosu &= number % divider != 0;
				++divider;
			}
			
			if(sosu) {
				System.out.print(number + " ");
			}
			++number;
		}

	}

}
