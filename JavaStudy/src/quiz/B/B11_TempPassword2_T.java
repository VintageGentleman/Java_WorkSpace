package quiz.B;

public class B11_TempPassword2_T {

	/*
	  	대문자, 소문자, 특수문자, 숫자로 구성된
	  	랜덤 비밀번호 6자리를 생성하여 출력하는 프로그램을 만들어보세요
	  	
	  	※ 사용 가능한 특수문자 - !@#$%^&*()-_+=:;
	*/
	
	public static void main(String[] args) {
		
		String PASSWORD_CHARSET = "ABCDEFGHIJKLMNOPQRSTUVXYZ" 
				+ "abcdefghijklmnopqrstuvwxyz"
				+ "0123456789!@#$%^&*()-_+=:;";
		
		String password = "";
		
		// 0 ~ length - 1 사이의 랜덤 숫자를 만들어야한다
		for (int i = 0; i < 6; ++i) {
			int randomIndex = 
					(int) (Math.random() * PASSWORD_CHARSET.length());
			password += PASSWORD_CHARSET.charAt(randomIndex);
		}
		
		System.out.println(password);
	}

}
