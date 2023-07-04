package myobj2;

import java.util.regex.Pattern;

public class ParkingSystem_Car {
	
	static String[] types = {"일반", "장애인", "유아동승", "경차"};

	final public static int GENERAL = 0;
	final public static int DISABLED = 1;
	final public static int WITHCHILD = 2;
	final public static int SMALLCAR = 3;
	
	int typeNum;
	String type;
	String carNum;

	public ParkingSystem_Car() {
		this(randomNumGenerator(0, types.length), randomCarNum());
	}
	
	public ParkingSystem_Car(int typeNum, String carNum) {
		String regex = "\\d{2}.\\d{4}";
		carNum = carNum.trim();
		
		if(Pattern.matches(regex, carNum)) {
			this.type = types[typeNum];
			this.typeNum = typeNum;
			this.carNum = carNum;
		} else {
			System.out.println("차량번호가 올바르지 않습니다. 올바른 예) 00가0000\n"
					+ "차량번호에 임시 번호를 부여했습니다.");
			this.type = types[typeNum];
			this.typeNum = typeNum;
			this.carNum = "00가0000";
		}
	}
	
	@Override
	public String toString() {
		return String.format("[%s] %s", type, carNum);
	}
	
	/** 랜덤으로 7자리의 차량넘버를 만들어주는 메서드 EX> 00가0000 */
	private static String randomCarNum() {
		String temp = "";
		String charSet = "가나다라마바사아자차카타파하";
		
		for(int i = 0; i < 2; ++i) {
			temp += randomNumGenerator(0, 10);
		}
		
		temp += charSet.charAt(randomNumGenerator(0, charSet.length())); 
		
		for(int i = 0; i < 4; ++i) {
			temp += randomNumGenerator(0, 10);
		}
		
		return temp;
	}
	
	/** num부터 num2 - 1의 랜덤 정수를 구해주는 메서드 */
	private static int randomNumGenerator(int num, int num2) {
		return (int)(Math.random() * num2 + num);
	}
	
	// get 메서드들은 이 아래에
	
	public String getCarNum() {
		return carNum;
	}
	
	public int getTypeNum() {
		return typeNum;
	}
	
	public String getType() {
		return type;
	}
	
}
