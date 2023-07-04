import java.util.Scanner;
import quiz.A.*;

public class B00_Scanner {

	/*
	 	# import
	 	
	 	 - java.util은 패키지의 이름이다
	 	 - java.util이라는 이름의 패키지 내부에 Scanner 클래스가 들어있다
	 	 - 자바에서 다른 패키지에 있는 다른 클래스를 가져다 사용하기 위해서는
	 	   import가 필요하다
	 	   
	   	# java.util.Scanner 클래스
	   	
	   	 - 사용자로부터 프로그램으로 입력을 받을 수 있는 여러 기능들이 모여있는 클래스
	   	 - 새 스캐너를 생성하면서 어느곳으로부터 입력 받을지 설정한다
	   	   (System은 콘솔을 뜻한다)
	   	   
	   	   System.out -> 콘솔로 데이터를 내보낸다는 뜻 (나가는 통로)
	   	   System.in -> 콘솔에서 데이터가 들어온다는 뜻 (들어오는 통로)
	*/
	public static void main(String[] args) {
		
		// 다른 패키지(quiz)의 다른 클래스를 가져다 사용해보기
		A00_Rabbit.main(null);
		// A01_DuesInfo.main(null);
	
		// 새 스캐너 생성(입력 통로 설정)
		Scanner sc = new Scanner(System.in);
		
		// Scanner sc2 = new Scanner(다른통로);
		
		System.out.print("반드시 숫자만 입력 > ");
		
		// sc.nextInt() : 스캐너에 딸려 있는 기능. 다음 정수 입력을 기다리는 기능
		int num = sc.nextInt(); // 데이터 처리는 오른쪽부터 이루어진다

		System.out.printf("입력하신 숫자*3은 %d입니다.\n", num * 3);
		
		/*
		 	# 스캐너의 대표적인 기능들
		 	
		 	(1) next타입() 메서드 - nextInt(), nextDouble(), nextFloat()
		 	
		 	 - 사용자가 입력하는 여러 값들 중 다음 값을 하나만 꺼낸 후
		 	   원하는 타입으로 변환하여 가져온다
		 	 - 공백, \t, \n을 통해 각 값을 구분할 수 있다
		 	 - 통로에 남아있는 값이 없는 경우 프로그램을 멈추고 새로운 입력을 기다린다
		 	 
		 	(2) next() 메서드 
		 	
		 	 - 통로에 있는 값을 문자열 타입으로 하나 꺼낸다
		 	 - 공백, \t, \n을 통해 각 값을 구분할 수 있다
		 	 - 통로에 남아있는 값이 없는 경우 프로그램을 멈추고 새로운 입력을 기다린다
		 	 
		 	(3) nextLine() 메서드
		 	
		 	 - 통로에 있는 값을 모두 문자열 타입으로 꺼낸다
		 	 - \n을 통해 값을 구분하기 때문에 모든 값을 꺼낸다
		 	   (문장을 입력받을 수 있다)
		 	 - 통로에 남아있는 값이 없는 경우 프로그램을 멈추고 새로운 입력을 기다린다
		*/
		
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		System.out.println("두 번째 값: " + num2);
		System.out.println("세 번째 값: " + num3);
		
		sc.close();
	}
}
