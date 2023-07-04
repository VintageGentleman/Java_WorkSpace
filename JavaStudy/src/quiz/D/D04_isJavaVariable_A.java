package quiz.D;

public class D04_isJavaVariable_A {

	/*
	  	문자열을 매개변수로 전달하면 해당 문자열이 자바 변수로 사용할 수 있는 문자열인지
	  	검사해주는 메서드를 만들어보세요.
	*/
	
	public static boolean check(String str) {
		boolean result = true;
		char[] charSet = str.toCharArray();
		for(int i = 0; result && i < charSet.length; ++i) {
			if(i == 0) {
				result &= Character.isJavaIdentifierStart(charSet[i]);
			} else {
				result &= Character.isJavaIdentifierPart(charSet[i]);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		String str1 = "Text";
		String str2 = "$ext";
		String str3 = "#ext";
		String str4 = "Te xt";
		
		System.out.println(check(str1));
		System.out.println(check(str2));
		System.out.println(check(str3));
		System.out.println(check(str4));
	}
}
