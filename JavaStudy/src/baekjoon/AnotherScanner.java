package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnotherScanner {

	// BufferedReader : 입력을 좀 더 효율적으로 받을 수 있는 스캐너
	
	public static void main(String[] args) throws IOException {
		
		// 좀 더 효율적인 스캐너를 생성 (실행 시간이 스캐너보다 좀 더 빠르다)
		BufferedReader in =
				new BufferedReader(new InputStreamReader(System.in));
		
		// 스캐너보다 성능이 더 좋은 대신에 한 줄씩 밖에 입력받지 못 한다
		System.out.print("입력해보셈 > ");
		String line = in.readLine();
		
		System.out.println("input: " + line);
		
		// 입력받은 내용을 숫자로 변환시키는 방법 (* 숫자가 아닌경우 에러 발생)
		int value = Integer.parseInt(line);
		
		System.out.println(value);
	}
}
