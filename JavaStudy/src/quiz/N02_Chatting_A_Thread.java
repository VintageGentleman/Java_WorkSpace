package quiz;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class N02_Chatting_A_Thread extends Thread {

	Socket s1;
	Socket s2;
	Socket s3;
	
	String nick;
	
	public N02_Chatting_A_Thread(Socket s1, Socket s2, Socket s3) {
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
	}
	
	@Override
	public void run() {
		
		try(
			DataInputStream din = new DataInputStream(s1.getInputStream());
			DataOutputStream dout1 = new DataOutputStream(s1.getOutputStream());
			DataOutputStream dout2 = new DataOutputStream(s2.getOutputStream());
			DataOutputStream dout3 = new DataOutputStream(s3.getOutputStream());
		) {
			System.out.print("닉네임 설정 중\n");
			nick = din.readUTF();
			
			dout1.writeUTF("닉네임 설정 완료 : " + nick);
			
			while(true) {
				LocalTime timeNow = LocalTime.now();
				String timeDis = timeNow.format(DateTimeFormatter.ofPattern("hh:mm:ss"));
				String message = din.readUTF();
				String chat = String.format("%s >> %s - %s",
						nick, message, timeDis);
				
				dout1.writeUTF(chat);
				dout2.writeUTF(chat);
				dout3.writeUTF(chat);
			}
		} catch(SocketException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		

	}
	
}
