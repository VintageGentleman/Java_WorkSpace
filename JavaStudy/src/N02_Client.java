import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.DataOutputStream;
import java.io.IOException;

public class N02_Client {

	public static void main(String[] args) {

		
		try(
			Scanner sc = new Scanner(System.in);
			Socket s = new Socket("127.0.0.1", 8888);
					
		) {
			DataOutputStream out = new DataOutputStream(s.getOutputStream());

			while(true) {
				out.writeUTF(sc.nextLine());
				out.flush(); // flush : 보내기
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
