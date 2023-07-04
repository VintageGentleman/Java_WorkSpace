import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class E07_Charset {

	/*
	  	# Charset
	  	
	  	- ASCII 코드까지는 모든 Charset이 동일하지만 그 이후부터는 각 회사마다
	  	  다른 문자코드를 사용한다
	  	- MS949 : 윈도우즈에서 사용하는 마이크로소프트의 문자셋
	  	- EUC-KR : 이클립스가 기본적으로 사용하는 문자셋 (유효한 한국어만 사용, 뛿뙗뺋 금지)
	  	- UTF-8 : 가장 표준이 되는 문자셋으로 모든 문자를 포함하고 있다. 용량이 크다.
	  	- Writer는 해당 문자를 어떤 Charset으로 byte화(인코딩) 할지 설정해야 한다 
	  	- Reader는 파일의 데이터를 읽으면서 어떤 Charset으로 char화(디코딩) 할지
	  	  설정해야 한다 
	*/
	
	public static void main(String[] args) {
		
		String filePath = "files/encodingTest.txt";
		
		// try(Closable) - Autoclose
		// : try 소괄호 내부에 선언한 객체를 try문이 끝날 때 자동으로 닫아준다 
		try (FileWriter out =
					new FileWriter(filePath, Charset.forName("EUC-KR")))
		{
			for(int i = 0; i < 5; ++i) {
				out.write("안녕하세요 한글한번 써보겠습니다...");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// EUC-KR로 읽기
		try(FileReader in =
					new FileReader(filePath, Charset.forName("EUC-KR")))
		{
			char[] buff = new char[1024];
			
			int len;
			while((len = in.read(buff)) != -1) {
				System.out.println(new String(buff, 0, len));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
