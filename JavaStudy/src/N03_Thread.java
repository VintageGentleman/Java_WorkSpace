import java.time.LocalTime;
import java.util.Scanner;

public class N03_Thread {

	/*
	  	# 쓰레드
	  	
	  	- 우리가 사용하던 것은 main 쓰레드였다
	  	- main 쓰레드 말고도 여러 쓰레드를 추가해서
	  	  동시에 여러 작업을 진행하는 것이 가능하다
	*/
	
	public static void main(String[] args) {

		Thread timer = new Thread() {
			
			@Override
			public void run() {
				while(true) {
					System.out.println(LocalTime.now());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		};
		
		timer.start();
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("숫자를 입력해주세요 > ");
			int num = sc.nextInt();
			System.out.println(num);
			
			if(num == 0) {
				sc.close();
				break;
			}
		}
		
	}
	
}