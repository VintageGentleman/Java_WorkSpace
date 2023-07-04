import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class E11_DataStream {

	/*
	  	# DataOutPutStream, DataInputStream
	  	
	  	- 자바의 데이터 타입을 전송할 수 있는 스트림
	  	- Java만 해석할 수 있는 데이터 타입이기 때문에
	  	  다른 언어로 만들어진 프로그램에서는 해당 파일을 사용할 수 없다는 단점이 있다
	  	- 데이터를 저장했던 순서대로 꺼내야 한다  
	*/
	
	public static void main(String[] args) {
		
		try(
			FileOutputStream fout = new FileOutputStream("files/data.abc");
			DataOutputStream dout = new DataOutputStream(fout);
		) {
			dout.writeBoolean(true);
			dout.writeDouble(123.1234);
			dout.writeUTF("리치치즈스파게티");
			dout.writeInt(65);
			dout.writeInt(66);
			dout.writeInt(67);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		try(
			FileInputStream fin = new FileInputStream("files/data.abc"); 
			DataInputStream din = new DataInputStream(fin);
		) {
			System.out.println("아까 쓴 거1 : " + din.readBoolean());
			System.out.println("아까 쓴 거2 : " + din.readDouble());
			System.out.println("아까 쓴 거3 : " + din.readUTF());
			System.out.println("아까 쓴 거4 : " + din.readInt());
			System.out.println("아까 쓴 거5 : " + din.readInt());
			System.out.println("아까 쓴 거6 : " + din.readInt());
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
