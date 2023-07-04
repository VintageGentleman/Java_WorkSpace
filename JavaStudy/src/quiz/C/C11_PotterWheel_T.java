package quiz.C;

import myobj.PotterWheel;

public class C11_PotterWheel_T {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		PotterWheel potterWheel = new PotterWheel();
		PotterWheel potterWheel2 = new PotterWheel();
						
		potterWheel.addPrize(new myobj.Prize("초코파이", 0, 1000, 0.053));
		
		int count = 0;
		while(true) {
			// 같은 패키지에 같은 이름의 클래스가 존재하는 경우 import를 사용할 수 없다
			// 이럴 때는 패키지명을 제대로 명시해 두 클래스를 구분해야 한다
			myobj.Prize prize = potterWheel.wheel(); 
			
			System.out.printf("%d번째: %s\n", count++, prize);
			
			if(prize != null && prize.getQty() == 0) {
				break;
			}
		}
	}

}
