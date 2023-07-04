package quiz.B;

public class B11_TempPassword {
	
	/*
	  	알파벳 대문자로 구성된 랜덤 4자리 비밀번호를 생성하여 출력하는
	  	프로그램을 만들어보세요
	  	
	  	65 ~ 90의 랜덤 숫자를 만들어 보세요
	  	
	  	(1) Math.random()에 숫자의 개수를 곱한다 (26개, 90 - 65 + 1)
	  	
	  	(2) 해당 범위에서 가장 작은 숫자를 더한다 (+65)
	*/

	public static void main(String[] args) {
		
		String tempPassword = "";
		
		for (int i = 0; i < 4; ++i) {
			tempPassword += (char)(Math.random() * 26 + 65);
		}
		
		System.out.println("생성된 임시 비밀번호: " + tempPassword);
	}

}
