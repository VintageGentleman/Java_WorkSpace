package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B00_AgeCalculater {

	/*
	  	사용자가 태어난 해를 입력하면 한국 나이를 알려주는 프로그램을 만들어보세요
	*/
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int birthYear = Integer.parseInt(br.readLine());
		int presentYear = 2023;
		
		bw.write(String.valueOf(presentYear - birthYear + 1));
		bw.flush();
		
		br.close();
		bw.close();
	}
}
