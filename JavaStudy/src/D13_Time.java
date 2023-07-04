import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class D13_Time {

	/*
		# java.time 패키지
		
		- Calendar의 여러가지 단점을 보완한 시간을 다루는 클래스들을 모은 패키지
		- Calendar가 set(), add()를 통해 원본 인스턴스를 변환하는 것이
		  큰 단점이라고 생각하여 새로운 시간 인스턴스를 생성하여 반환하는 방식을 사용한다
		 
	  	# java.time.LocalDate
	  	
	  	- 날짜만 다루는 클래스
	  	
	  	# java.time.LocalTime
	  	
	  	- 시간만 다루는 클래스
	  	
	  	# java.time.LocalDateTime
	  	
	  	- 날짜와 시간 모두 다루는 클래스
	*/

	public static void main(String[] args) {
		
		// now() : 현재 시간으로 인스턴스를 생성한다
		// now(ZoneID) : 해당 지역의 현재 시간으로 인스턴스를 생성하여 반환한다 
		LocalDate today = LocalDate.now();
		LocalDate todayEtc = LocalDate.now(ZoneId.of("Etc/GMT+9"));
		
		LocalTime thisTime = LocalTime.now();
		LocalTime thisTimeEtc = LocalTime.now(ZoneId.of("Etc/GMT+9"));

		// ZoneId.getAvailableZoneIds() : 사용가능한 ZoneId를 Set으로 반환해준다
		System.out.println(ZoneId.getAvailableZoneIds());
		
		System.out.println(today);
		System.out.println(todayEtc);
		
		System.out.println(thisTime);
		System.out.println(thisTimeEtc);
		
		// of() : 원하는 시간의 인스턴스를 생성하여 반환하는 메서드
		System.out.println(LocalDate.of(1995, 8, 23));
		System.out.println(LocalTime.of(10, 50, 59, 999_999_999));
		System.out.println(LocalDateTime.of(2002, 7, 16, 22, 59, 59, 999_999_999));
	
		// plusXXX(v) : 원하는 것을 원하는 만큼 더한 새 인스턴스를 반환
		// 			   (Calendar와 다르게 원본은 그대로 유지된다)
		// minusXXX(v) : "
		LocalDate after30days = today.plusDays(30);
		
		System.out.println("원본 : " + today);
		System.out.println("30일 후 : " + after30days);
		System.out.println("2만년 전 오늘" + today.minusYears(20000));
		
		LocalTime after900mins = thisTime.plusMinutes(900);
		
		System.out.println("원본 : " + thisTime);
		System.out.println("900분 후 : " + after900mins);
		System.out.println("5시간 전 : " + thisTime.minusHours(5));
		
		// getXXX() : 원하는 필드값을 꺼낼 수 있다
		System.out.println("월 : " + today.getMonth());
		System.out.println("월 : " + today.getMonthValue());
		System.out.println("요일 : " + today.getDayOfWeek());
		
		System.out.println(today.plusYears(1).plusMonths(13).isLeapYear());
		
		// DayOfWeek 클래스
		DayOfWeek dow = today.getDayOfWeek();
		
		System.out.println("요일값 : " + dow.getValue());
		
		// dow.getDisplayName(TextStyle, Locale)
		// - TextStyle : 길게 or 짧게
		// - Locale : 언어 설정
		System.out.println("요일이름: " +
			dow.getDisplayName(TextStyle.FULL, Locale.KOREAN));
		
		// Month 클래스
		Month mon = today.getMonth();
		
		System.out.println(mon.getValue());
		System.out.println(mon.getDisplayName(TextStyle.FULL, Locale.ENGLISH));
		
		// with() : 원하는 만큼 조정한 새 인스턴스를 반환
		LocalDate day1 = today.withDayOfMonth(20);
		System.out.println(day1);
		
		LocalDate day2 = today.withDayOfYear(250);
		System.out.println(day2);
		
		LocalDate day3 = today.withMonth(11).withDayOfMonth(20);
		System.out.println(day3);
		
		// TemporalAdjuster interface : 날짜 조정기능 인터페이스
		// TemporalAdjusters : 구현된 날짜 조정기들이 모여있는 클래스
		TemporalAdjuster 이번달첫번째로변경하는날짜조정기 =
				TemporalAdjusters.firstDayOfMonth();
		TemporalAdjuster 이번달의마지막날로변경하는날짜조정기 =
				TemporalAdjusters.lastDayOfMonth();
		TemporalAdjuster 세번째수요일로변경하는날짜조정기 =
				TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.WEDNESDAY);
				
		LocalDate firstDay = today.with(이번달첫번째로변경하는날짜조정기);
		LocalDate lastDay = today.withMonth(2).with(이번달의마지막날로변경하는날짜조정기);
		LocalDate wednesday = today.with(세번째수요일로변경하는날짜조정기);
		
		System.out.println(firstDay);
		System.out.println(lastDay);
		System.out.println(wednesday);
	}
	
}
