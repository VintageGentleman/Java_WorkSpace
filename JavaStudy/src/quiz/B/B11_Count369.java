package quiz.B;

public class B11_Count369 {
	
	/*
	  	10 ~ 30000 사이의 랜덤 양의 정수를 하나 생성하고
	  	해당 숫자까지 369 게임이 진행된다면 박수를 총 몇 번 쳐야 하는지 출력해보세요
	*/

	public static void main(String[] args) {
		
		// 0 ~ 29990 + 10;
		int ranNum = (int)(Math.random() * 29991) + 10;
		
		System.out.println("이번의 목표 숫자는 " + ranNum + "입니다.");
		
		int count = 0;
		System.out.println("총 박수 회수는" + count + "입니다.");
		
		for (int num = 1; num <= ranNum; ++num) {
			System.out.print(num + ": ");
			
			String check = "" + num;
			
			for (int index = 0; index < check.length(); ++index) {
				
				char ch = check.charAt(index);
				
				if (ch == '3' || ch == '6' || ch == '9') {
					System.out.print("짝");
					++count;
				}
			}
			System.out.println();
		}
		
		// 문자열 없이 계산
//		for (int num = 1; num <= ranNum; ++num) {
//			System.out.print(num + ": ");
//			
//			// num은 박수를 몇 번 치는지 검사
//			int check = num;
//			
//			while(check > 0) {
//				int ch = check % 10;
//				
//				if (ch == 3 || ch == 6 || ch == 9) {
//					System.out.print("짝");
//					++count;
//				}
//				
//				check /= 10; // 10으로 나누면서 일의 자리 삭제
//			}
//			System.out.println();
//		}

	}
}
