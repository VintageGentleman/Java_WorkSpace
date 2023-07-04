package quiz.B;

public class B11_TempPassword2_A {

	/*
	  	대문자, 소문자, 특수문자, 숫자로 구성된
	  	랜덤 비밀번호 6자리를 생성하여 출력하는 프로그램을 만들어보세요
	  	
	  	※ 사용 가능한 특수문자 - !@#$%^&*()-_+=:;
	*/
	
	public static void main(String[] args) {
		
		// 대문자 65 90 , 소문자 97 122 숫자 48 57
		String letterPool = "";
		
		for (int i = 65; i <= 90; ++i) {
			char capital = (char) i;
			letterPool += capital;
			char lowercase = (char)(i + 32);
			letterPool += lowercase;
		}
		
		for (int i = 48; i <= 57; ++i) {
			char number = (char) i;
			letterPool += number;
		}
		
		String specialLetter = "!@#$%^&*()-_+=:;";
		letterPool += specialLetter;
		
		String tempPassword = "";
		for (int i = 0; i < 6; ++i) {
			int random = (int)(Math.random() * letterPool.length());
			tempPassword += letterPool.charAt(random);
		}

		System.out.println("임시비밀번호 : " + tempPassword);
	}

}
