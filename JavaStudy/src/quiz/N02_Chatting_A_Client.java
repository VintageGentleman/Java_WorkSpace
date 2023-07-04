package quiz;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class N02_Chatting_A_Client {
	
	public static void main(String[] args) {
		
		try(
			Scanner sc = new Scanner(System.in);
			Socket s = new Socket("127.0.0.1", 1111);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			DataInputStream din = new DataInputStream(s.getInputStream());
		) {
			System.out.print("닉네임을 설정해주세요.\n>> ");
			dout.writeUTF(sc.nextLine());
			dout.flush();

			Thread read = new Thread(){
				@Override
				public void run() {
					while(true) {
						try {
							System.out.println(din.readUTF());
						} catch (IOException e) {
							e.printStackTrace();
							System.exit(0);
						}
					}
				}
			};
			
			read.start();
			
			while(true) {
				dout.writeUTF(sc.nextLine());
				dout.flush();
			}
			
		} catch(UnknownHostException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
