package quiz;

public class E09_File_Cipher {

	final static String charSet = "ABCDEFGHIJKLNMOPQRSTVWXYZ"
			+ "abcdefghijklmnopqrstuvwxyz"
			+ "!@#$%^&*()-_=+\\|[]{};:'\"<>,./? ";
	
	final static int LEN = charSet.length(); 
	
	// 카이저암호 String 타입
	public static String encryption(String txt, int key) {
		
		StringBuilder sb = new StringBuilder(txt);
		
		int len = sb.length(); 
		
		key = key % LEN;
		
		for(int i = 0; i < len; ++i) {
			int index = charSet.indexOf(sb.charAt(i));
			
			if(index != -1) {
				sb.setCharAt(i,
						charSet.charAt((index + key) % LEN));
			}
		}
		
		return sb.toString();
	}
	
	// 카이저암호 char 타입
	public static char encryption(char txt, int key) {
		
		char target = txt;
		
		key = key % LEN;
		
		int index = charSet.indexOf(target);
			
		if(index != -1) {
			target = charSet.charAt((index + key) % LEN);
		}
		
		return target;
	}
	
	public static char[] encryption(char[] txt, int key) {
		
		key = key % LEN;
		
		for(int i = 0; i < txt.length; ++i) {
			int index = charSet.indexOf(txt[i]);

			if(index != -1) {
				txt[i] = charSet.charAt((index + key) % LEN);
			}
		}
		
		return txt;
	}
	
	public static String decryption(String message, int key) {
		StringBuilder sb = new StringBuilder(message);
		
		int len = sb.length();
		
		key = key % LEN;
		
		for(int i = 0; i < len; ++i) {
			int index = charSet.indexOf(sb.charAt(i));
			
			if(index != -1) {
				sb.setCharAt(i,
						charSet.charAt((index - key + LEN) % LEN));
			}
		}
		
		return sb.toString();
	}
	
	public static char[] decryption(char[] txt, int key) {
		
		key = key % LEN;
		
		for(int i = 0; i < txt.length; ++i) {
			int index = charSet.indexOf(txt[i]);

			if(index != -1) {
				txt[i] = charSet.charAt((index - key + LEN) % LEN);
			}
		}
		
		return txt;
	}
	
	public static char decryption(char txt, int key) {
		
		char target = txt;
		
		key = key % LEN;
		
		int index = charSet.indexOf(target);
			
		if(index != -1) {
			target = charSet.charAt((index - key + LEN) % LEN);
		}
		
		return target;
	}
	
}
