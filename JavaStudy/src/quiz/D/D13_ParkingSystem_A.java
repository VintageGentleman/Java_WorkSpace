package quiz.D;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

import myobj2.ParkingSystem_Car;

public class D13_ParkingSystem_A {
	
	public static void main(String[] args) {
		
		ParkingSystem_Car cars = new ParkingSystem_Car(0, "57바1249");
		
		LocalDate dDay = LocalDate.of(2023, 4, 11);
		LocalDate effectDay = LocalDate.of(2018, 9, 1);
		DayOfWeek dDayofWeek = dDay.getDayOfWeek();
		
		String dayDisplay = dDayofWeek.getDisplayName(TextStyle.FULL, Locale.KOREA);
		String carNum = cars.getCarNum(); 
		char lastNum = carNum.charAt(carNum.length() - 1);
		
		if(dDay.isAfter(effectDay)) {
			
			System.out.println("차량 번호 : " + cars);
			System.out.printf("오늘 날짜 : %s [%s]\n" , dDay, dayDisplay);
			
			switch(cars.getTypeNum()) {
			
			case 0:
				boolean holiday = holiday(dDay);
				
				if(!holiday) {
					
					if(dDayofWeek == DayOfWeek.MONDAY) {
						if(lastNum == '1' || lastNum == '6') {
							System.out.println("차량 5부제에 따라 출입제한 대상입니다.");
						} else {
							System.out.println(carNum + " 출입 가능합니다.");
						}
					} 
					
					if(dDayofWeek == DayOfWeek.TUESDAY) {
						if(lastNum == '2' || lastNum == '7') {
							System.out.println("차량 5부제에 따라 출입제한 대상입니다.");
						} else {
							System.out.println(carNum + " 출입 가능합니다.");
						}
					}
					
					if(dDayofWeek == DayOfWeek.WEDNESDAY) {
						if(lastNum == '3' || lastNum == '8') {
							System.out.println("차량 5부제에 따라 출입제한 대상입니다.");
						} else {
							System.out.println(carNum + " 출입 가능합니다.");
						}
					}
					
					if(dDayofWeek == DayOfWeek.THURSDAY) {
						if(lastNum == '4' || lastNum == '9') {
							System.out.println("차량 5부제에 따라 출입제한 대상입니다.");
						} else {
							System.out.println(carNum + " 출입 가능합니다.");
						}
					}
					
					if(dDayofWeek == DayOfWeek.FRIDAY) {
						if(lastNum == '5' || lastNum == '0') {
							System.out.println("차량 5부제에 따라 출입제한 대상입니다.");
						} else {
							System.out.println(carNum + " 출입 가능합니다.");
						}
					}
					
				} else {
					System.out.println("공휴일, 휴무일엔 차량 5부제가 실시되지 않습니다.");
				}
				
				break;
				
			default :
				System.out.printf("[%s]은(는) 차량 5부제 대상이 아닙니다.\n", cars.getType());
				
				break;
			}
			
		} else {
			System.out.println("아직 차량 5부제가 시행되지 않았습니다.");
		}
		
	}

	public static boolean holiday(LocalDate dDay) {
		
		DayOfWeek dow = dDay.getDayOfWeek();
		
		if(dow == DayOfWeek.SATURDAY ||
				dow == DayOfWeek.SUNDAY) {
			return true;
		}
		
		if(dDay.getMonthValue() == 1 &&
				dDay.getDayOfMonth() == 1) {
			return true;
		}
		
		if(dDay.getMonthValue() == 3 &&
				dDay.getDayOfMonth() == 1) {
			return true;
		}
		
		if(dDay.getMonthValue() == 5 &&
				dDay.getDayOfMonth() == 5) {
			return true;
		}
		
		if(dDay.getMonthValue() == 6 &&
				dDay.getDayOfMonth() == 6) {
			return true;
		}
		
		if(dDay.getMonthValue() == 8 &&
				dDay.getDayOfMonth() == 15) {
			return true;
		}
		
		if(dDay.getMonthValue() == 10) {
			if(dDay.getDayOfMonth() == 3) {
				return true;
			}
			if(dDay.getDayOfMonth() == 9) {
				return true;
			}
		}
		
		if(dDay.getMonthValue() == 12 &&
				dDay.getDayOfMonth() == 25) {
			return true;
		}
		
		return false;
	}
	
}
