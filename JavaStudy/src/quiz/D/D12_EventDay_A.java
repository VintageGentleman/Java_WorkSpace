package quiz.D;

import java.util.Calendar;

public class D12_EventDay_A {

	/*
	  	실행하면 오늘로부터 앞으로 1년간의 이벤트 날짜를 모두 출력해주는 프로그램을 
	  	만들어보세요
	  	
	  	1+1 이벤트 : 매월 18일
	  	20% 할인 이벤트 : 홀수 번째 금요일
	  	
	  	※ 이벤트 날짜가 겹치는 날에는 둘 모두 적용됨을 알려줘야 한다
	*/
	
	public static void main(String[] args) {
		
		Calendar now = Calendar.getInstance();
		Calendar oneYearAfter = Calendar.getInstance();
		oneYearAfter.add(Calendar.YEAR, 1);
		
		while(now.before(oneYearAfter)) {
			boolean event1 = false;
			boolean event2 = false;
			
			if(now.get(Calendar.DATE) == 18) {
				event1 = true;
			}
			
			if(now.get(Calendar.WEEK_OF_MONTH) % 2 != 0 &&
					now.get(Calendar.DAY_OF_WEEK) == 6) {
				event2 = true;
			}
			
			if(event1 || event2) {
				System.out.println(now.getTime());
				if(event1) {
					System.out.println("1+1 이벤트 날입니다.");
				}
				if(event2) {
					System.out.println("20% 할인 이벤트 날입니다.");
				}
				System.out.println();
			}
			
			now.add(Calendar.DATE, 1);
		}
		
	}
	
}
