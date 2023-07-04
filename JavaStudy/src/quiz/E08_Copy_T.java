package quiz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class E08_Copy_T {
	
	/*
	  	폴더 이름을 전달하면 폴더이름2에
	  	모든 내용을 복사하는 메서드를 만들어보세요
	*/
	
	public static void main(String[] args) {
		try {
			copy("files");
		} catch (FileNotFoundException e) {
			System.out.println("원본 파일의 이름이 잘못됨...");
		}
	}

	public static void copy(String path) throws FileNotFoundException {

		File src = new File(path);
		
		if(!src.exists()) {
			throw new FileNotFoundException("원본 파일이 존재하지 않습니다.");
		}
		
		// 모든 파일 목록을 보관할 리스트
		List<File> all = new ArrayList<>();
		getAllFiles(src, all);
		
		// 파일 목록에서 파일을 하나씩 꺼내면서
		for(File f : all) {
			// 스트링빌더로 목적지 경로를 만들어낸다 (원본폴더 바로 뒤에 2를 추가)
			StringBuilder sb = new StringBuilder(f.getPath());
			sb.insert(src.getPath().length(), "2");
			File dst = new File(sb.toString());
			
			// 만약 부모 경로에 필요한 폴더들이 없으면 mkdirs()로 다 생성
			if(!dst.getParentFile().exists()) {
				dst.getParentFile().mkdirs();
			}
			
			// 복사
			try(
				FileInputStream in = new FileInputStream(f);
				FileOutputStream out = new FileOutputStream(dst);
			) {
				int b;
				while((b = in.read()) != -1) {
					out.write(b);
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void getAllFiles(File src, List<File> list) {
		for(File f : src.listFiles()) {
			if(f.isDirectory()) {
				getAllFiles(f, list); 
			} else {
				list.add(f);
			}
		}
	}
	
}
