import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class N01_Network {

	/*
	  	# 자바로 통신 하기(Networking)
	  	
	  	- IP Address : 0.0.0.0 ~ 255.255.255.255 해당 컴퓨터의 네트워크상 주소
	  	- Protocol : 통신 규칙 (TCP, FTP, Telnet, SMTP, ...)
	  	- Port Number : 포트 번호 (각 애플리케이션을 구분하기 위한 용도)
	  	- MAC Address : 네트워크 카드에 설정된 물리주소
	  	- 연결지향형 프로토콜 : TCP, 확실한 연결을 보장하지만 느리다
	  	- 비연결 지향형 프로토콜 : UDP, 데이터를 그냥 뿌리지만 빠르다
	  	- Socket : 1 ~ 5번을 하나의 클래스로 조작하는 것
	  	
	  	# Socket 
	  	
	  	- 두 기계가 통신을 하기 위해 사용하는 클래스
	  	- 소켓을 생성하면서 IP주소와 포트번호를 지정해야 한다
	  	- 새 소켓을 생성하는 행위 자체가 서버로의 접속 시도를 의미한다
	  	
	  	# ServerSocket
	  	
	  	- 만들어놓고 클라이언트를 기다리기위해 사용하는 클래스
	  	- 해당 포트번호를 열고 접속을 대기할 수 있다
	*/
	
	public static void main(String[] args) {
		
		try	{
			ServerSocket ss = new ServerSocket(8888);
			System.out.println("Server IP: " + ss.getLocalSocketAddress());
			System.out.println("Server Port: " + ss.getLocalPort());
			
			// accept() : 다른 소켓의 연결을 기다린다. 여기서 프로그램이 멈춘다.
			System.out.println("연결을 기다리는 중입니다...");
			
			// 다른 클라이언트 소켓과의 연결이 수립된다
			Socket s = ss.accept();
			
			System.out.println("연결이 수립되었습니다. 이제부터 메세지를 기다립니다...");
			
			try(
				DataInputStream in = new DataInputStream(s.getInputStream());
				DataOutputStream out = new DataOutputStream(s.getOutputStream());
			){
				for(int i = 0; i < 10; ++i) {
					String message = in.readUTF();
					// System.out.println("message from client: " + message);
					out.writeUTF(message);
				}
			} catch(IOException e) {
				e.printStackTrace();
			}

			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("서버가 종료되었습니다.");
	}
	
}
