
public class A06_Print {

	/*
	  	# 콘솔에 출력하는 함수들
	  	
	  	1. println()
	  	
	  	 - () 안에 전달한 데이터를 콘솔에 출력하고 줄을 자동으로 바꿔준다
	  	 - 데이터 뒤에 자동으로 \n을 추가하여 출력한다
	  	 
	  	2. print()
	  	
	  	 - () 안에 전달한 데이터를 콘솔에 출력한다
	  	 
	  	3. printf()
	  	
	  	 - print format
	  	 - 원하는 서식대로 데이터를 출력할 수 있는 함수
	  	 - 서식에 서식 문자를 적고 해당 자리에 값을 순서대로 채워서 사용한다
	  	 
	  	 * 서식 문자의 종류
	  	  
	  	  %d : 해당 자리에 전달한 정수값을 10진수로 출력 (decimal)
	  	  %o : 해당 자리에 전달한 정수값을 8진수로 출력 (octal)
	  	  %x : 해당 자리에 전달한 정수값을 16진수로 출력 (hexa)
	  	  %f : 실수
	  	  %s : 문자열
	  	  %c : 문자
	  	  %% : 그냥 %를 출력하고 싶은 경우 (서식 문자의 Escape)
	  	  
	  	 * 서식 문자 옵션 - 서식 문자의 %와 문자 사이에 넣어서 사용
	  	  
	  	  	1. %숫자d : 숫자만큼 자릿수를 확보하면서 출력한다
	  	  	
	  	  	2. %-숫자d : 숫자만큼 자릿수를 확보한 후에 왼쪽 정렬하여 출력
	  	  	
	  	  	3. %0숫자d : 숫자만큼 자릿수를 확보한 후에 빈자리에 0을 채워 출력
	  	  	
	*/
	public static void main(String[] args) {
		String snack = "포스틱";
		
		System.out.println(snack);
		System.out.println(snack);
		System.out.println(snack);
		System.out.print(snack);
		System.out.print(snack);
		System.out.print(snack);
		System.out.println(); // \n만 콘솔에 출력
		
		int year = 2023, month = 2, date = 20;
		int hour = 19, minute = 17, second = 38;
		
		System.out.println(hour + "시 " + minute + "분 " + second + "초 ");
		
		// 서식을 먼저 지정한 후 값을 채우는 방식으로 콘솔에 문자열을 출력할 수 있다
		System.out.printf("%d년 %d월 %d일, %d:%d:%d\n",
				+ year, month, date, hour, minute, second);
		// %d, %o, %x, %X
		int value = 1000;
		
		System.out.printf("10진수 값 : %d\n", value);
		System.out.printf("8진수 값 : %o\n", value);
		System.out.printf("16진수 값 : %x\n", value);
		System.out.printf("16진수 값 : %X\n", value);
		
		// %f에서 소수점 자리에 제한을 걸 수 있다
		double weight = 88.88888888;
		
		System.out.printf("몸무게 : %f\n", weight);
		System.out.printf("몸무게 : %.5f\n", weight);
		System.out.printf("몸무게 : %.4f\n", weight);
		System.out.printf("몸무게 : %.3f\n", weight);
		System.out.printf("몸무게 : %.2f\n", weight);
		System.out.printf("몸무게 : %.1f\n", weight);
		
		// %s : 모든 타입은 문자열이 될 수 있기 때문에 아무거나 전달해도 된다
		System.out.printf("문자열 : %s\n", "Hello!!");
		System.out.printf("문자열 : %s\n", 123);
		System.out.printf("문자열 : %s\n", 123.123456789);
		
		// printf() 내부에서 %는 특수 기호이기 때문에 그냥 출력할 수 없다
		System.out.printf("성공확률 %.2f%%\n", 99.99);
		
		// 서식 문자 옵션
		int num = 12345;
		
		String label = "가격";
		
		System.out.printf("%d\n", num);
		System.out.printf("%10d%10d%10d%10d\n", num, num, num, num);
		System.out.printf("%-10d%-10d%-10d%-10d\n", num, num, num, num);
		System.out.printf("%-8s:%08d\n", label, num);
	}
}
