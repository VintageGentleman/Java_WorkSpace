import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class E06_CharacterStream {

	/*
	  	# InputStream/OutputStream
	  	
	  	- byte 단위로 데이터를 입/출력하는 클래스
	  	- 데이터를 byte로 분해해서 사용하기 때문에 다소 불편할 수 있음
	  	
	  	# Reader/Writter
	  	
	  	- char 단위로 데이터를 입/출력하는 클래스
	  	- byte를 char로 알아서 합치거나 char를 byte로 알아서 분해해준다
	*/
	
	public static void main(String[] args) {
		
		String filePath = "files/test.txt";
		
		FileOutputStream out = null;
		
		try {
			// FileOutputStream(String "파일이름", boolean append);
			// append를 true로 설정하면 내용을 계속 추가하기만 한다 (기존 내용 삭제 x)
			out = new FileOutputStream(filePath, false);
			
			for(int i = 0; i < 10; ++i) {
				out.write("한글도 쓸 수 있습니다.\n".getBytes());
			}
			
			System.out.println(
					Arrays.toString("한글도 쓸 수 있습니다.\n".getBytes())
			);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// close시 finally문을 활용하면 안닫힐 확률을 없앨 수 있다.
			try {
				if(out != null) out.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		// 읽기
		FileInputStream in = null;
		try {
			 in = new FileInputStream(filePath);
			 
			 // 2byte짜리 한글을 1byte씩 읽어서 깨지고 있다
//			 int ch;
//			 while((ch = in.read()) != -1){
//				 System.out.print((char)(ch));
//			 }
			 
			 // in.reset(); // 다 읽은 파일을 다시 원점으로 돌린다..?
//			 System.out.println("+++++++++++ 다시 읽기 ++++++++++++");

			 // ASCII코드는 byte로 읽어도 문제가 발생하지 않지만
			 // byte의 범위를 넘어가는 문자들은 문제들이 발생한다
			 byte[] buff = new byte[3];
			 int len;
			 while((len = in.read(buff)) != -1) {
				 System.out.print(new String(buff, 0, len));
			 }
			 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null) in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// Reader로 읽기
		FileReader in2 = null;
		try {
			in2 = new FileReader(filePath);
		
			// Reader는 한 char씩 읽기 때문에 한글이 깨지지 않는다
//			int ch;
//			while((ch = in2.read()) != -1) {
//				System.out.print((char) ch);
//			}
			
			// 여러개씩 읽을 때도 byte[]이 아닌 char[]을 전달해야 한다
			char[] buff = new char[300];
			int len = in2.read(buff);
			System.out.println(new String(buff, 0, len));
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(in2 != null) in2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
