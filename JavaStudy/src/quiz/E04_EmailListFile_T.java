package quiz;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import quiz.D.D10_ReporterList_A;

public class E04_EmailListFile_T {
	
	// D10 문제 기자들의 이메일들로만 이루어진 파일을 생성해보세요.
	
	public static void main(String[] args) {
		
		// 정규표현식을 컴파일한 결과
		Pattern isEmail = Pattern.compile(".*@.*");
		
		// 패턴 인스턴스로 원하는 문자열을 검색
		Matcher matcher = isEmail.matcher(D10_ReporterList_A.data);
		
		try {
			FileOutputStream out = new FileOutputStream("files/reporter_emails.txt");
			
			while(matcher.find()) {
				out.write(matcher.group(0).getBytes());
				out.write('\n');
			}
			
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
