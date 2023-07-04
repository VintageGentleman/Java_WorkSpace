import java.text.SimpleDateFormat;
import java.util.Calendar;

public class D12_Calendar {

	/*
	  	# java.util.Calendar
	  	
	  	- 달력을 구현한 클래스
	  	- 날짜 및 시간을 손쉽게 계산할 수 있는 기능들이 있다
	  	- 생성자를 사용할 수 없게 막혀있어서 getInstance()라는
	  	  스태틱 메서드를 사용해야 한다
	*/
	
	public static void main(String[] args) {
		
		Calendar now = Calendar.getInstance();
		
		// get(field) : 생성한 해당 인스턴스로부터 특정 필드 값을 꺼내온다
		System.out.println(now);
		
		// 필드값들은 상수로 지정되어 있다
		System.out.println(now.get(Calendar.YEAR));
		// MONTH는 1 감소된 값으로 나오므로 주의해야 한다
		System.out.println(now.get(Calendar.MONTH));
		System.out.println(now.get(Calendar.DATE));
		System.out.println(now.get(Calendar.SECOND));
		System.out.println(now.get(Calendar.MILLISECOND));
		
		// getTime() : 해당 시간의 Date 타입 인스턴스를 반환한다
		System.out.println(now.getTime());
		
		// getTimeInMillis() : 해당 시간의 유닉스 타임을 반환한다
		System.out.println(now.getTimeInMillis());
		
		// Calendar.DAY_OF_WEEK : 날짜 필드
		System.out.println("오늘 : " + now.get(Calendar.DAY_OF_WEEK));
		
		// 요일 상수
		System.out.println("일요일: " + Calendar.SUNDAY);
		System.out.println("월요일: " + Calendar.MONDAY);
		System.out.println("화요일: " + Calendar.TUESDAY);
		System.out.println("수요일: " + Calendar.WEDNESDAY);
		System.out.println("목요일: " + Calendar.THURSDAY);
		System.out.println("금요일: " + Calendar.FRIDAY);
		System.out.println("토요일: " + Calendar.SATURDAY);
		
		// 달 상수 (원하는 달에 -1 EX> 1월 == 0)
		System.out.println("1월: " + Calendar.JANUARY);
		System.out.println("2월: " + Calendar.FEBRUARY);
		
		System.out.println("이번 달의 몇 번째 날인가? "
								+ now.get(Calendar.DAY_OF_MONTH));
		System.out.println("올 해의 몇 번째 날인가? "
								+ now.get(Calendar.DAY_OF_YEAR));
		System.out.println("이번 달의 몇 번째 요일인가? "
								+ now.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println("이번 달의 몇 번째 주인가? " 
								+ now.get(Calendar.WEEK_OF_MONTH));
		System.out.println("올 해의 몇 번째 주인가? "
								+ now.get(Calendar.WEEK_OF_YEAR));
		System.out.println("오전인가 오후인가? " 
								+ now.get(Calendar.AM_PM));
		System.out.println("오전 : " + now.get(Calendar.AM));
		System.out.println("오후 : " + now.get(Calendar.PM));
		
		// set(field, value) : 해당 필드의 값을 수정한다
		// : 해당 필드의 값을 수정한다. 다른 필드들도 알맞게 수정된다.
		now.set(Calendar.DATE, 11);
		
		System.out.println(now.get(Calendar.DATE));
		System.out.println(now.get(Calendar.DAY_OF_WEEK));

		// add(field, amount)
		// : 해당 필드에 원하는 만큼 값을 더한다. 다른 필드들도 알맞게 수정된다.
		now.set(Calendar.DATE, 100);
		System.out.println(now.getTime());
		
		/*
		  	# SimpleDateformat
		  	
		  	- Date 타입 인스턴스의 서식을 지정할 수 있는 클래스
		  	- y : 년
		  	- M : 월
		  	- d : 일
		  	- h : 12시간
		  	- H : 24시간
		  	- m : 분
		  	- s : 초
		  	- S : 밀리초
		  	- E : 요일 (짧게)
		  	- EEEE : 요일 (길게) 
		  	- a : 오전, 오후
		*/
		
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy-MM-dd [HH:mm:ss.SSS] EEEE a");
		
		String result = sdf.format(now.getTime());
		
		System.out.println(result);
	}
	
}
