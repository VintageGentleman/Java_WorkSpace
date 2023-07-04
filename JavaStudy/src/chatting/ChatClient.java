package chatting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {

	public static void main(String[] args) {
		
		try(
			Socket s = new Socket("127.0.0.1", 8889);
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader in = new BufferedReader(isr)
		) {			
			System.out.println("연결 성공!");
			
			// 듣기 대기하는 곳
			new Thread() {
				@Override
				public void run() {
					try(
						InputStreamReader isr2 =
							new InputStreamReader(s.getInputStream());
						BufferedReader in2 = 
							new BufferedReader(isr2); 
					) {
						// 서버 소켓으로부터의 메세지를 기다리는 곳
						while(true) {
							String message = in2.readLine();
							
							if(message == null) {
								System.exit(0);
							}
							
							System.out.println(message);
						}
					} catch(IOException e) {
						e.printStackTrace();
					}
				}
			}.start();
			
			try(
				OutputStreamWriter osw = 
				new OutputStreamWriter(s.getOutputStream());
				BufferedWriter out =
						new BufferedWriter(osw);
			) {
				while(true) {
					System.out.print(">> ");
					out.write(in.readLine() + "\n");
					out.flush();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			
		} catch(UnknownHostException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
