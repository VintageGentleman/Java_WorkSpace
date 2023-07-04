import java.util.InputMismatchException;
import java.util.Scanner;

public class E02_Throw {

	/*
	  	# throw
	  	
	  	- 원할 때 원하는 예외를 발생시킨다
	  	
	  	# throws
	  	
	  	- 해당 메서드 실행 도중 발생할 수 있는 예외를 적는 곳
	  	- 해당 메서드를 불러 사용하는 곳에서 그 예외를 처리할 수 있도록 미리 명시한다
	*/
	
	public static String shuffle(String text, int times)
			throws InputMismatchException {
		if(times < 0) {
			throw new InputMismatchException("섞으려면 1이상의 양수를 보내주세요");
		}
		
		StringBuilder sb = new StringBuilder(text);
		
		int len = text.length();
		for(int i = 0; i < times; ++i) {
			int ran = (int)(Math.random() * len);
			char ch = sb.charAt(ran);
			sb.setCharAt(ran, sb.charAt(0));
			sb.setCharAt(0, ch);
		}
		
		return sb.toString(); 
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
//		System.out.print(">> ");
//		int num = sc.nextInt();
		sc.close();
		
//		try {
//			if(num % 2 == 1) {
//				throw new InputMismatchException("홀수를 입력하시면 안됩니다.");
//			}
//		} catch (InputMismatchException e) {
//			num = num + 1;
//		}
//		
//		System.out.println(num + "은 짝수입니다.");
		
		try {
			String shuffleResult = shuffle("I am a hamburger", -80);
			System.out.println(shuffleResult);
		} catch (Exception e) {
			// Exception : 모든 예외의 부모이기 때문에 모든 예외를 받을 수 있다
			e.printStackTrace();
			System.out.println("문자를 섞는 것에 실패했습니다.");
		}
		
		System.out.println("프로그램이 계속 진행됩니다...");
		
	} 
	
}
