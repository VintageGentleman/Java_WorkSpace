package quiz.D;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;

public class D13_ParkingSystem_T {

	LocalDate today;
	private HashMap<String, LocalDate> holidays = new HashMap<>();
			
	public D13_ParkingSystem_T(LocalDate date) {
		today = date;
		
		int year = date.getYear();
		
		holidays.put("설날", LocalDate.of(year, 1, 1));
		holidays.put("삼일절", LocalDate.of(year, 3, 1));
		holidays.put("어린이날", LocalDate.of(year, 5, 5));
		holidays.put("석가탄신일", LocalDate.of(year, 5, 27));
		holidays.put("현충일", LocalDate.of(year, 6, 6));
		holidays.put("광복절", LocalDate.of(year, 8, 15));
		holidays.put("개천절", LocalDate.of(year, 10, 3));
		holidays.put("한글날", LocalDate.of(year, 10, 9));
		holidays.put("성탄절", LocalDate.of(year, 12, 25));
	}
	
	public boolean checkParkable(Car car) {
		if(holidays.containsValue(today) || 
				 today.getDayOfWeek().equals(DayOfWeek.SATURDAY) || 
				 today.getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
			System.out.println("공휴일 및 휴무일은 차량5부제가 적용되지 않습니다.");
			return true;
		}
		
		int dowValue = today.getDayOfWeek().getValue();
		int lastNum = car.num.charAt(car.num.length() - 1) - '0';
		
		// 주차 가능 타입 차량은 미리 통과
		if(car.type < 3) {
			System.out.printf("%s 차량은 차량5부제의 대상이 아닙니다.\n",
					car.getType());
			return true;
		}
		
		// 평일
		if(dowValue >= DayOfWeek.MONDAY.getValue()
				&& dowValue <= DayOfWeek.FRIDAY.getValue()){
			if(lastNum == dowValue || lastNum == (dowValue + 5) % 10) {
				System.out.printf("'%s'는 %s에 주차할 수 없습니다.\n",
						car, today.getDayOfWeek());
				return false;
			}
		}

		System.out.printf("'%s'는 오늘 주차할 수 있습니다.\n", car);

		return true;
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		D13_ParkingSystem_T sys1 =
				new D13_ParkingSystem_T(LocalDate.now());
		D13_ParkingSystem_T sys2 =
				new D13_ParkingSystem_T(LocalDate.of(1998, 5, 11));
		D13_ParkingSystem_T sys3 =
				new D13_ParkingSystem_T(LocalDate.of(1998, 5, 5));

		for(int i = 0; i < 10; ++i) {
			sys3.checkParkable(new Car());
		}
		
	}
	
	public static class Car {
		String num;
		int type;
		long parkStartTime;
		long parkEndTime;
		
		private static String[] types = {
				"장애인", "유아동승", "경차", "SUV", "화물차",
				"승합차",	"중장비", "렌트카", "영업용", "법인"
		};
		
		private static char[] symbols = {
				'가', '나', '다', '라', '마', '바',
				'사', '아', '자', '하', '호', '허'
		};
		
		public static String getRandomCarNumber() {
			StringBuilder num = new StringBuilder();
			
			num.append((int)(Math.random() * 990 + 10)); // 10 ~ 999
			num.append(symbols[(int)(Math.random() * symbols.length)]);
			num.append((int)(Math.random() * 9000 + 1000));
			
			return num.toString();
		}

		public Car() { 
			this(
				getRandomCarNumber(),
				(int)(Math.random() * types.length)
			);
		}
		
		public Car(String num, int type) {
			this.num = num;
			this.type = type;
		}
		
		public String getType() {
			return types[type];
		}
		
		@Override
		public String toString() {
			return String.format("[%s] %s", getType(), num);
		}
	}
	
}
