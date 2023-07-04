import java.util.InputMismatchException;
import java.util.Scanner;

public class E01_Exception {

	/*
	  	# 예외 (Exception)
	  	
	  	- 우리가 에러라고 생각했던 빨간 글씨들을 예외라고 부른다
	  	- 자바의 문법을 틀리는 것은 예외가 아니라 컴파일 에러라고 부른다
	  	  (실행이 아예 되지 않음, 자바 문법 오류)
	  	- 실행 도중 발생하는 여러 문제들만을 예외라고 부른다
	  	- 프로그래머는 발생할 수 있는 예외를 미리 예상하고 대비해둘 수 있다 (예외 처리)
	  	
	  	# 예외 처리 (try-catch)
	  	
	  	- 예외가 발생할 가능성이 있는 코드를 try문 내부에 포함시킨다
	  	- try문 내부에서 예외가 발생하지 않는다면 평소대로 정상 작동한다
	  	- try문 내부에서 예외가 발생하는 경우 즉시 try문을 중단하고
	  	  발생한 예외에 해당하는 catch문으로 이동한다
	  	- catch절은 여러번 사용할 수 있다
	  	- 예외가 발생하여 해당 catch문에 도착할 때
	  	  예외 발생에 대한 정보를 담고 있는 인스턴스가 함께 도착한다 
	  	- 예외 처리의 기본 동작은 e.printStackTrace() 후 프로그램 강제 종료이다
	  	
	  	# StackTrace
	  	
	  	- 현재 스택에서 일어나고 있던 일들을 기록해놓은 것
	  	- 예외 발생 시 스택 상태를 콘솔에 출력하여 예외가 발생한 위치를 찾는데 도움을 준다
	  	
	  	# finally
	  	
	  	- try문 내부에서 예외가 발생하던 안하던 무조건 실행하게 되는 구문
	*/
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			int[] a = new int[5];
			a[3] = 99;
			a[55] = 88;
			
			System.out.print("반드시 정수만 입력해주세요 >> ");
			sc.nextInt();
			
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 인덱스의 범위를 벗어나서 사용했습니다.");
			System.out.println("Message : " + e.getMessage());
			
			e.printStackTrace(); // StackTrace를 콘솔에 출력해주는 메서드
			
		} catch(InputMismatchException e) {
			System.err.println("내가 정수만 입력하라고 했을텐데?");
			
		} finally {
			System.out.println(" /)/)");
			System.out.println("(  ..)");
			System.out.println("(  >$");
		}
		
		System.out.println("프로그램이 계속 진행됩니다...");
		
		sc.close();
	}
}
