package quiz;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import quiz.D.D10_ReporterList_A;

public class E04_EmailListFile_A {

	// D10 문제 기자들의 이메일들로만 이루어진 파일을 생성해보세요.
	
	public static void main(String[] args) {
		
		try {
			FileOutputStream fos = new FileOutputStream("files/email");
			
			String data = D10_ReporterList_A.data;
			
			Pattern emailRegex = Pattern.compile("\\w+@\\w+[.]\\w+([.]\\w+)?");
			
			Matcher m1 = emailRegex.matcher(data);
			
			while(m1.find()) {
				fos.write((m1.group() + "\n").getBytes());
			}
			
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
