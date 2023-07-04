import java.util.Scanner;

public class B04_Switch {

	/*
	  	# switch-case문
	  	
	  	- ()안의 값에 따라 실행할 코드를 결정하는 문법
	  	- ()안에 boolean 타입 값은 사용할 수 없다
	  	- if문으로 완벽하게 대체 가능하기 때문에 자주 사용하는 문법은 아니다
	  	- default는 if문의 else같은 역할을 한다
	  	  ()안의 값에 해당하는 case가 없는 경우 default를 실행한다
	  	- break를 적지 않으면 다음 break를 만날때까지
	  	  밑에있는 모든 case를 실행한다
	*/
	
	public static void main(String[] args) {
		
		System.out.println("1. enter  2. menu  3. quit");
		System.out.print("> ");
		Scanner sc = new Scanner(System.in);
		int select = sc.nextInt();
		
		switch (select) {
		case 1: case 7:
			System.out.println("Welcome!");
			break;
		case 2:
			System.out.println("- Restaurant Menu -");
			break;	
		case 3:
			System.out.println("Good Bye!");
			break;
		default:
			System.out.println("올바르지 않은 선택입니다...");
			break;	
		}
		
		String cmd = "cd";
		
		switch (cmd) {
		case "cd":
			System.out.println("change directory");
			break;
		case "cls":
			System.out.println("clear screen");
			break;
		case "help":
			System.out.println("help menu");
			break;
		}
		sc.close();
	}
}
