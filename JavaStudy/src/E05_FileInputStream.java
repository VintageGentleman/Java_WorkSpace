import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class E05_FileInputStream {

	public static void main(String[] args) {

		try {
			FileInputStream in =
					new FileInputStream("files/reporter_emails.txt");
			
			// readAllBytes() : 모든 데이터들을 byte[]로 읽는다
//			 byte[] allData = in.readAllBytes();
			
//			for(int i = 0; i < allData.length; ++i) {
//				System.out.printf("byte %d: %c\n", i, (char)allData[i]);
//			}

			// new String(byte[]) : 데이터들을 문자열로 재구성하여 인스턴스를 생성
//			String emails = new String(allData);
//			System.out.println(emails);
			
			// read() : 한 byte씩 읽는다. 더 읽을게 없으면 -1을 리턴한다.
			
//			while(true) {
//				int ch = in.read();
//				
//				if(ch == -1) {
//					break;
//				} else {
//					System.out.print((char)(ch));
//					try {
//						Thread.sleep(10);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
			
			// read(byte []) : 전달한 배열의 크기만큼 읽는다.
			// 기본적으로는 방금 몇 byte를 읽었는지 반환한다.
			// 더 읽을게 없으면 -1을 리턴한다.
			
			byte[] buff = new byte[100];
			
			// int count = 0;
			while(true) {
				int len = in.read(buff);
				
				if(len == -1) {
					break;
				} else {
					// System.out.printf("------- %d (%d) ------------\n", count++, len);
					
					// new String(byte[], start, end)
					// : 데이터 배열로부터 원하는 글자수만큼만 문자열로 변환하여 인스턴스를 생성
					System.out.print(new String(buff, 0, len));
					
					// System.out.println("----------------------------");
				}
			}
				
			// InputStream도 꼭 닫아주어야 한다 (안닫으면 메모리 누수 발생)
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("경로가 틀렸습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
