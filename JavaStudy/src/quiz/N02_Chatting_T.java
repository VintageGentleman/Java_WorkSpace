package quiz;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import chatting.ListenChatThread;

public class N02_Chatting_T {

	public static void main(String[] args) {
		
		List<Socket> users = new ArrayList<>();
		
		try(ServerSocket ss = new ServerSocket(8889)) {
			while(true) {
				System.out.println("연결 대기중 ... (현재 인원 "
						+ users.size() + ")");
				Socket s = ss.accept();
				
				if(users.size() < 3) {
					users.add(s);
					new ListenChatThread(users, s).start();
				} else {
					s.getOutputStream()
						.write("접속인원이 가득 찼습니다...".getBytes());
					s.close(); // 소켓 연결 끊기
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
