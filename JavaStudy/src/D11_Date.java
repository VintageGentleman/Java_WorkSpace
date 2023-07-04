import java.util.Date;

public class D11_Date {

	/*
	  	# java.util.date
	  	
	  	- 시간 및 날짜 정보를 보관할 수 있는 클래스
	  	- 오래된 클래스이기 때문에 데이터를 보관하는 용도로만 사용하고
	  	  메서드는 잘 사용하지 않는다
	*/
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		// 아무것도 안넣고 생성하면 현재 시간
		Date d1 = new Date();
		System.out.println(d1);
		
		// long타입 값을 전달하여 유닉스 타임으로 시간을 생성
		Date d2 = new Date(1000000000000L);
		System.out.println(d2);
		
		/*
		 	System.currentTimeMillis() : 시스템으로부터 현재 유닉스 타임을 받아온다
		  	※ Unix Time - 1970년 1월 1일 이후로 시간이 얼마나 흘렀는지 1/1000초로 센 것 
		*/
		
		System.out.println("현재 시간: " + System.currentTimeMillis());
		
		System.out.println("Unix Time 0 : " + new Date(0L));
		System.out.println("Unix Time -50000000 : " + new Date(-50000000L));
		System.out.println("Unix Time +50000000 : " + new Date(50000000L));
		System.out.println("Unix Time 현재 시간 : "
				+ new Date(System.currentTimeMillis()));
		
		Date now = new Date();
		Date lontTimeAgo = new Date(0L);
		
		// date.after(anotherDate) : 해당 시간이 전달한 시간보다 뒤인지 물어본다
		System.out.println(now.after(lontTimeAgo));
		
		// date.before(anotherDate) : 해당 시간이 전달한 시간보다 앞인지 물어본다
		System.out.println(now.before(lontTimeAgo));
		
		// date.getTime() : 해당 인스턴스로부터 유닉스 타임을 꺼낸다
		System.out.println(now.getTime());
	
		// date.setTime(long) : 전달한 유닉스 타임으로 시간을 변경한다
		
		Date children = new Date();
		
		// 5월 5일까지 반복 (month는 -1로 나옴)
		
		while(children.getMonth() != 4 || children.getDate() != 5) {
			long time = children.getTime();
			children.setTime(time + 1000 * 60 * 60 * 24);
		}
		
		System.out.println(children);
		
		// 연습 1970년 1월 1일 오전 9시 부터 10번째 일요일을 찾아서 출력해보세요
		
		System.out.println("==== 연습문제 ====");
		Date sunday10th = new Date(0L);
		
		System.out.println("기준일 : " + sunday10th);
		
		int oneDay = 1000 * 60 * 60 * 24;
		int oneWeek = 1000 * 60 * 60 * 24 * 7;
		
		while(sunday10th.getDay() != 0) {
			long time = sunday10th.getTime();
			sunday10th.setTime((time + oneDay));
		}
		
		System.out.println("1번째 일요일 : " + sunday10th);
		
		for(int i = 2; i <= 10; ++i) {
			long time = sunday10th.getTime();
			sunday10th.setTime((time + oneWeek));
		
			System.out.println(i + "번째 일요일 : " + sunday10th);
		}
		
		// 연습문제 해답
		System.out.println("==== answer ====");
		Date sunday10 = new Date(0L);
		
		int count = 0;
		while(sunday10.getDay() != 0 || count < 10) {
			sunday10.setTime(sunday10.getTime() + oneDay);
			
			if(sunday10.getDay() == 0) {
				System.out.println(count + "번째 일요일 발견 : " + sunday10);
				++count;
			}
		}

		// 일요일 번호 찾기...
//		for(int i = 0; i < 10; ++i) {
//			System.out.println(sunday10.getDay());
//			sunday10.setTime(sunday10.getTime() + oneDay);
//		}
		
	}
}
