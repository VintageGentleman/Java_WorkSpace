package quiz;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class N02_Chatting_A {

	/*
	  	# 간단한 채팅 프로그램을 만들어 보세요
	  	
	  	# 서버
	
	  	1. 최대 3명까지 접속이 가능하다
	  	2. 클라이언트가 메세지를 보내면 다른 클라이언트들에게 해당 메세지를 전달해줘야 한다
	  	3. 메세지는 닉네임 > 메세지 내용 - 보낸 시간 형식이어야 한다
	  	
	  	# 클라이언트

	  	1. 서버에 접속하고 메세지를 보낼 수 있다
	  	2. 클라이언트는 프로그램 시작시 처음 닉네임을 설정할 수 있다
	  	3. 서버에 접속한 다른 사람들과 채팅을 할 수 있다.
	  	4. 내가 메세지를 보낼 때 그동안 다른 사람들이 보낸 메세지를 한번에 확인할 수 있다
	*/
	
	public static void main(String[] args) {
		
		try(
			ServerSocket ss = new ServerSocket(1111);
		) {
			System.out.println("Server IP: " + ss.getInetAddress());
			System.out.println("Server Port: " + ss.getLocalPort());
			
			Socket s1 = ss.accept();
			Socket s2 = ss.accept();
			Socket s3 = ss.accept();
			
			N02_Chatting_A_Thread t1 = new N02_Chatting_A_Thread(s1, s2, s3);
			N02_Chatting_A_Thread t2 = new N02_Chatting_A_Thread(s2, s1, s3);
			N02_Chatting_A_Thread t3 = new N02_Chatting_A_Thread(s3, s1, s2);
			
			t1.start();
			t2.start();
			t3.start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
