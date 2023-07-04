import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class E04_JavaIO {

	/*
	 	# Java I/O (Input/Output)
	 	
	 	- 자바는 스트림이라는 개념을 통해 프로그램의 입/출력을 다룬다
	 	- 프로그램으로 데이터가 들어오는 것을 입력(Input)이라고 한다
	 	- 프로그램에서 계산되어 나가는 모든 데이터들을 출력(Output)이라고 한다
	 	
	 	# Stream
	 	
	 	- 데이터들이 오고 가는 통로
	 	- 데이터들이 프로그램으로 들어오는 통로를 InputStream이라고 한다
	 	- 데이터들이 프로그램에서 계산되어 나가는 통로를 OutputStream이라고 한다
	 	- 데이터가 Stream을 지나가기 위해서는 해당 데이터를 byte타입으로 변환시켜야 한다
	 	  (byte타입이 가장 0과 1로 변환하기 쉽기 때문)
	*/
	
	public static void main(String[] args) {
		
		try {
			FileOutputStream out = new FileOutputStream("files/test.txt");
			
			// write(int) : 숫자를 하나 쓴다
			out.write('A');
			out.write('B');
			out.write('C');
			out.write(95);
			
			// "".getBytes() : 해당 문자열을 byte[]로 바꿔준다
			out.write("Hello, world!".getBytes());

			// 다 사용한 스트림은 반드시 수동으로 닫아줘야 한다 (자동으로 닫아주지 않는다)
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("해당 경로를 찾지 못함");
		} catch (IOException e) {
			System.out.println("쓰기 도중 에러 발생...");
			e.printStackTrace();
		}
		
	}
	
}
