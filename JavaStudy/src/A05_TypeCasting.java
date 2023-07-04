
public class A05_TypeCasting {

	/*
	  	#타입 크기순(실수 타입은 무조건 정수 타입보다 크다)
	  	
	  	byte < short = char < int < long(8) < float(4) < double
	  	
	  	- 큰 타입에 작은 타입의 값을 넣을 때는 타입이 자동으로 변환된다
		  (자연스러운 타입 캐스팅)
		  
		- 작은 타입에 큰 타입의 값을 넣을 때는 강제 타입 캐스팅이 필요하다
		  (값이 손상될 우려가 있지만 개발자가 직접 입력했으므로 책임진다는 뜻)  
	*/
	
	public static void main(String[] args) {
		
		byte b1 = 127;
		short s1 = b1;
		
		// 큰 타입에서 작은 타입으로 변할 때는 데이터 손상이 발생할 수 있기 때문에
		// 그냥은 넣을 수 없고 강제 형변환(타입 캐스팅)이 필요하다
		b1 = (byte)s1;
		
		// 큰 타입에서 작은 타입으로 강제 형변환하여 값이 이상해지는 경우
		short s2 = 200;
		
		b1 = (byte)s2;
		
		System.out.println(b1);
		
		double d1 = 123.123456789123456789;
		float f1 = (float)d1;
		
		System.out.println(d1);
		System.out.println(f1);
		
		// 실수 타입은 소수점 아래 값이 소실될 위험이 있으므로
		// 정수 타입에 들어갈 때 항상 타입 캐스팅이 필요하다
		long l1 = (long)f1;
		
		System.out.println(l1);
		
		// short, char 모두 2byte이지만
		// short에는 음수값이 존재할 위험이 있으므로 타입 캐스팅이 필요하다
		char c1 = (char)s1;
		
		System.out.println(c1);

		// char 타입에는 short의 범위를 넘어가는 양수 정수가 있을 위험이 있으므로
		// 타입 캐스팅이 필요하다	
		s1 = (short)c1;
				
		int ch1 = 65;
		char ch2 = 65;
		
		System.out.println((char)ch1);
		System.out.println((int)ch2);
		
	}
}
