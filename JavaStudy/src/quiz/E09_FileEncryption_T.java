package quiz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import quiz.D.D09_CaesarCipher_T;

public class E09_FileEncryption_T {
	
	/*
	 	frankenstein.txt를 시저 암호방식으로 암호화 한 파일
	 	frankenstein_encrypted.enc를 생성해보세요
	 	
	 	(1) byte 방식으로 한 글자씩 암호화하여 속도를 측정해보기
	 	
	 	(2) char 방식으로 한 글자씩 암호화하는 속도를 측정해보기
	 	
	 	(3) char[] 방식으로 암호호화하는 속도를 측정해보기
	 	
	 	(4) 버퍼 방식을 사용해 암호화하는 속도를 측정해보기
	*/

	public static File src = new File("files/frankenstein.txt");
	public static File dst = new File("files/frankenstein_encrypted.enc");
	
	public static void encrypt1(int key) {
		try(
			FileInputStream in = new FileInputStream(src);
			FileOutputStream out = new FileOutputStream(dst);	
		) {
			int b;
			while((b = in.read()) != -1) {
				char ch = D09_CaesarCipher_T.encryption((char) b, key);
				out.write(ch);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void encrypt2(int key) {
		try(
			FileReader in = new FileReader(src);
			FileWriter out = new FileWriter(dst);	
		) {
			int ch;
			while((ch = in.read()) != -1) {
				ch = D09_CaesarCipher_T.encryption((char) ch, key);
				out.write(ch);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void encrypt3(int key) {
		try(
				FileReader in = new FileReader(src);
				FileWriter out = new FileWriter(dst);	
		) {
			char[] buff = new char[1024];
			int len;
			while((len = in.read(buff)) != -1) {
				for(int i = 0; i < len; ++i) {
					D09_CaesarCipher_T.encryption(buff[i], key);
				}
				out.write(buff, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void encrypt4(int key) {
		try(
			FileReader fin = new FileReader(src);	
			BufferedReader in = new BufferedReader(fin);
			FileWriter fout = new FileWriter(dst);
			BufferedWriter out = new BufferedWriter(fout);
		) {
			// Buffered 한 글자씩
			int ch;
			while((ch = in.read()) != -1) {
				out.append(D09_CaesarCipher_T.encryption((char) ch, key));
			}
			// Buffered 한 줄씩
//			String line;
//			while((line = in.readLine()) != null) {
//				out.append(
//					D09_CaesarCipher_T.encryption(line + "\n", key)
//				);
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		encrypt1(10);
		System.out.println("time1(byte): "
				+ (System.currentTimeMillis() - start) + "ms");
		
		start = System.currentTimeMillis();
		encrypt2(10);
		System.out.println("time2(char): "
				+ (System.currentTimeMillis() - start) + "ms");
		
		start = System.currentTimeMillis();
		encrypt3(10);
		System.out.println("time3(char[]): "
				+ (System.currentTimeMillis() - start) + "ms");
		
		start = System.currentTimeMillis();
		encrypt4(10);
		System.out.println("time4(buffered): "
				+ (System.currentTimeMillis() - start) + "ms");
	}
	
}
