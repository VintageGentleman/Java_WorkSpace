package quiz.D;

public class D09_CaesarCipher_T {
	
	/*
	  	# 시저 암호
	  	
	  	- 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 암호화하는 암호 알고리즘
	  	- 키 값만큼 평문의 모든 알파벳을 오른쪽으로 밀어주면 암호화가 되고
	  	  암호문을 다시 정해진 키 값만큼 왼쪽으로 밀어주면 복호화가 된다
	  	  
	        ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*0123456789
	        abcdefghijklmnopqrstuvwxyz
	    	    	
	  	    			   key : 7
	  	    HELLO     --------------->      OLSSV
	*/
	
	// 1. 평문과 키값이 전달되면 해당 평문을 암호문으로 만들어서 리턴해주는 메서드
		
	// 2. 암호문과 키값이 전달되면 해당 암호문을 평문으로 만들어주는 메서드
	
	static String charSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
			+ "!@#$%^&*0123456789"
			+ "abcdefghijklmnopqrstuvwxyz"
			+ "[]/?;'\" ";
	
	static int charSet_Length = charSet.length(); 
	
	public static String encryption(String message, int key) {
		StringBuilder sb = new StringBuilder(message); 

		int len = sb.length();

		key = key % charSet_Length;
		
		for(int i = 0; i < len; ++i) {
			int index = charSet.indexOf(sb.charAt(i));
			
			if(index != -1) {
				sb.setCharAt(i,
						charSet.charAt((index + key) % charSet_Length));
			}
		}
				
		return sb.toString();
	}
	
	public static char encryption(char ch, int key) {
		int index = charSet.indexOf(ch);
		
		if(index == -1) {
			return ch;
		}
		
		return charSet.charAt((index + key) % charSet_Length);
	}
	
	public static String decryption(String message, int key) {
		StringBuilder sb = new StringBuilder(message);
		
		int len = sb.length();
		
		key = key % charSet_Length;
		
		for(int i = 0; i < len; ++i) {
			int index = charSet.indexOf(sb.charAt(i));
			
			if(index != -1) {
				sb.setCharAt(i,
						charSet.charAt((index - key + charSet_Length) % charSet_Length));
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String result = encryption("My Message : Hello!!", 150);

		System.out.println("암호화결과: " + result);
		System.out.println(decryption(result, 150));
		
	}
}
