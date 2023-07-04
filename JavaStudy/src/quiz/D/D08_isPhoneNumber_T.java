package quiz.D;

public class D08_isPhoneNumber_T {
	
	/*
	  	사용자로부터 입력받은 문자열이 유효한 핸드폰 번호인지 검사하는 메서드를 만들어보세요
	*/

	public static boolean isPhoneNumber(String str) {
		// - 안올때 : 01012341234 / 11자리
		// - 올때 : 010-1234-1234 / 13자리
		int len = str.length();
		
		if(len != 11 && len != 13) {
			System.out.println("문자열의 길이가 전화번호 길이가 아닙니다.");
			return false;
		}
		
		if(len == 13) {
			if(str.charAt(3) != '-' || str.charAt(8) != '-') {
				System.out.println("- 위치에 이상한 문자가 있습니다.");
				return false;
			}  
			
			str = str.replace("-", "");
			
			if((len = str.length()) != 11) {
				System.out.println("-를 제거 후 길이가 11이 아닙니다.");
				return false;
			}
		}
		
		if(!str.startsWith("010")) {
			System.out.println("010으로 시작하지 않는 번호입니다.");
			return false;
		}
		
		for(int i = 3; i < len; ++i) {
			if(!Character.isDigit(str.charAt(i))) {
				System.out.println("번호부분에 "
						+ "숫자가 아닌 문자가 있습니다.");
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		isPhoneNumber("123-123+-1234");
		isPhoneNumber("123+1234+1234");
		isPhoneNumber("123-123--1234");
		isPhoneNumber("010-1234--234");
		isPhoneNumber("010-abcd-abcd");
		System.out.println(isPhoneNumber("010-1234-1234"));
		
	}
	
}
