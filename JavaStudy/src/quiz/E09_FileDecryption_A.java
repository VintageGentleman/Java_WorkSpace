package quiz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class E09_FileDecryption_A {

	/*
	  	암호화 된 파일(.enc)의 맨 위부터 10줄(공백 줄 제외)을 모든 키값으로
	  	복호화한 샘플을 보여준 후 사용자가 해당 키값을 선택하면 해당 키값으로 
	  	복호화한 파일을 생성하도록 만들어보세요
	  	(복호화한 파일의 확장자는 .dec이고 파일명 맨 뒤에 _decrypted를 추가할 것)
	*/
	
	public static File src = new File("files/frankenstein_encrypted_A.enc");
	public static File dst = new File("files/frnakenstein_decrypted_A.dec");
	
	public static void sample(int key) {
		try(
			BufferedReader in = new BufferedReader(new FileReader(src));
		) {
			System.out.printf("키값 %d일 때\n", key);
			String[] buff = new String[10];
			for(int j = 0; j < 10; ++j) {
				String decryptedStr = E09_File_Cipher.decryption(in.readLine() + "\n", key);
				if(!decryptedStr.equals("\n")) {
					buff[j] = decryptedStr;
				} else {
					--j;
				}
			}
			System.out.println(Arrays.toString(buff));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void dencrypt(int key) throws IndexOutOfBoundsException {
		if(key < 0 || key >= E09_File_Cipher.LEN) {
			throw new IndexOutOfBoundsException("key값은 0보다 작거나 전체 키값보다 커서는 안됩니다."
					+ "\n당신이 입력한 값 : " + key);
		}
		
		try(
			BufferedReader in = new BufferedReader(new FileReader(src));
			BufferedWriter out = new BufferedWriter(new FileWriter(dst));
		) {
			String line;
			while((line = in.readLine()) != null) {
				out.write(E09_File_Cipher.decryption(line + "\n", key));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < E09_File_Cipher.LEN; ++i) {
			sample(i);
		}
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			try {
				System.out.print("원하는 키값을 입력하세요.(0 - 81) \n>> ");
				dencrypt(sc.nextInt());
				break;
			} catch(InputMismatchException e) {
				System.out.println("숫자만 입력하세요.");
				sc.nextLine();
			} catch(IndexOutOfBoundsException e) {
				System.out.println(e.getMessage() + "\n");
			} 
		}
		
		sc.close();
		
		System.out.println("복호화 되었음.");
	}
	
}
