package quiz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class E09_FileEncryption_A {
	
	/*
	 	frankenstein.txt를 시저 암호방식으로 암호화 한 파일
	 	frankenstein_encrypted.enc를 생성해보세요
	 	
	 	(1) byte 방식으로 한 글자씩 암호화하여 속도를 측정해보기
	 	
	 	(2) char 방식으로 한 글자씩 암호화하는 속도를 측정해보기
	 	
	 	(3) char[] 방식으로 암호호화하는 속도를 측정해보기
	 	
	 	(4) 버퍼 방식을 사용해 암호화하는 속도를 측정해보기
	*/
	
	public static void main(String[] args) {
		
		String src = "files/frankenstein.txt";
		
		try {
			System.out.println("byte 방식 : ");
			byteEncrypted(src);
			System.out.println("char 방식 : ");
			charEncrypted(src);
			System.out.println("char[] 방식 : ");
			charArrEncrypted(src);
			System.out.println("버퍼 방식 : ");
			bufferEncrypted(src);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	// 버퍼방식
	public static void bufferEncrypted(String src)
			throws FileNotFoundException {
		
		File f1 = new File(src);
		
		if(!f1.isFile()) {
			throw new FileNotFoundException("파일이 없습니다.");
		}

		long start = System.currentTimeMillis();
		
		String encryptedFile = src.replaceAll(".txt", "_encrypted_A.enc");
		
		try(
			BufferedReader in = new BufferedReader(new FileReader(src));
			BufferedWriter out = new BufferedWriter(new FileWriter(encryptedFile))
		) {
			String line;
			while((line = in.readLine()) != null) {
				out.write(E09_File_Cipher.encryption(line, 5) + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("경과시간 : " + (end - start) + "ms");
	}
	
	// char[] 방식
	public static void charArrEncrypted(String src)
			throws FileNotFoundException {
		
		File f1 = new File(src);
		
		if(!f1.isFile()) {
			throw new FileNotFoundException("파일이 없습니다.");
		}

		long start = System.currentTimeMillis();
		
		String encryptedFile = src.replaceAll(".txt", "_encrypted_A.enc");
		
		
		try(
			FileReader fin = new FileReader(src);
			FileWriter fout = new FileWriter(encryptedFile))
		{
			char[] buff = new char[1024];
			int len;
			while((len = fin.read(buff)) != -1) {
				fout.write(E09_File_Cipher.encryption(buff, 5), 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("경과시간 : " + (end - start) + "ms");
	}

	// char 방식
	public static void charEncrypted(String src)
			throws FileNotFoundException {
		
		File f1 = new File(src);
		
		if(!f1.isFile()) {
			throw new FileNotFoundException("파일이 없습니다.");
		}

		long start = System.currentTimeMillis();
		
		String encryptedFile = src.replaceAll(".txt", "_encrypted_A.enc");
		
		
		try(
			FileReader fin = new FileReader(src);
			FileWriter fout = new FileWriter(encryptedFile))
		{
			int len;
			while((len = fin.read()) != -1) {
				fout.write(E09_File_Cipher.encryption((char) len, 5));
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("경과시간 : " + (end - start) + "ms");
	}
	
	// byte방식
	public static void byteEncrypted(String src)
			throws FileNotFoundException {
		
		File f1 = new File(src);
		
		if(!f1.isFile()) {
			throw new FileNotFoundException("파일이 없습니다.");
		}

		long start = System.currentTimeMillis();
		
		String encryptedFile = src.replaceAll(".txt", "_encrypted_A.enc");
		
		try(
			FileInputStream fin = new FileInputStream(src);
			FileOutputStream fout = new FileOutputStream(encryptedFile))
		{
			int ch;
			while((ch = fin.read()) != -1) {
				fout.write(E09_File_Cipher.encryption((char) ch, 5));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("경과시간 : " + (end - start) + "ms");
	}

	
}
