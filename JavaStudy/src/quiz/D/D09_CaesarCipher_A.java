package quiz.D;

public class D09_CaesarCipher_A {

	/*
	  	# 시저 암호
	  	
	  	- 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 암호화하는 암호 알고리즘
	  	- 키 값만큼 평문의 모든 알파벳을 오른쪽으로 밀어주면 암호화가 되고
	  	  암호문을 다시 정해진 키 값만큼 왼쪽으로 밀어주면 복호화가 된다
	  	  
	        ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$^&*0123456789
	        abcdefghijklmnopqrstuvwxyz
	    	    	
	  	    			   key : 7
	  	    HELLO     --------------->      OLSSV
	*/
	
	// 1. 평문과 키값이 전달되면 해당 평문을 암호문으로 만들어서 리턴해주는 메서드
		
	// 2. 암호문과 키값이 전달되면 해당 암호문을 평문으로 만들어주는 메서드

	static String alphatbet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%%^&*0123456789"
								+"abcdefghijklmnopqrstuvwxyz[]/?;'\"";
	
	public static String encryption(String string, int key) {
		
		StringBuilder str = new StringBuilder(string);
		StringBuilder encryptedStr = new StringBuilder();
		
		for(int i = 0; i < str.length(); ++i) {
			int present = alphatbet.indexOf(str.charAt(i));
			if(present != -1) {
				int encrypted = (present + key) % alphatbet.length();
				encryptedStr.append(alphatbet.charAt(encrypted));
			} else {
				encryptedStr.append(str.charAt(i));
			}
		}
		
		return encryptedStr.toString();
	}
	
	public static String dencryption (String string, int key) {
		
		StringBuilder str = new StringBuilder(string);
		StringBuilder dencryptedStr = new StringBuilder();
		
		for(int i = 0; i < str.length(); ++i) {
			int present = alphatbet.indexOf(str.charAt(i));
			if(present != -1) {
				int gap = present - key;
				int dencrypted = gap >= 0 ? gap
						: alphatbet.length() + ((gap) % alphatbet.length());
				dencryptedStr.append(alphatbet.charAt(dencrypted));
			} else {
				dencryptedStr.append(str.charAt(i));
			}
		}
		
		return dencryptedStr.toString();
	}
	
	public static void main(String[] args) {
		
		String result = encryption("What a wonderful day", 5);

		System.out.println(result);
		
		System.out.println(dencryption(result, 5));
		
	}
	
}
