package quiz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class E08_Copy_A {

	/*
	  	폴더 이름을 전달하면 폴더이름2에
	  	모든 내용을 복사하는 메서드를 만들어보세요
	*/
	
	public static void main(String[] args) {

		File srcDirectory = new File("files"); 
		
		search(srcDirectory, "files");
		
	}
	
	// 재귀 (recursive)
	public static void search(File src, String copyName) {
		
		for(File f : src.listFiles()) {
			if(f.isDirectory()) {
				search(f, copyName); 
			} else {
				copyFile(f.getPath(), f.getParent(), copyName);
			}
		}
		
	}
	
	public static void copyFile(String filePath, String parentPath, String copyName) {
		
		File src = new File(filePath);
		File parent = new File(parentPath.replace(copyName, copyName + "2"));
		File dst = new File(filePath.replace(copyName, copyName + "2"));
		
		if(!parent.exists()) {
			parent.mkdirs();
		}
		
		try(
			FileInputStream in = new FileInputStream(src);
			FileOutputStream out = new FileOutputStream(dst);
		) {
			byte[] buff = new byte[1024];
			int len;
			while((len = in.read(buff)) != -1) {
				out.write(buff, 0, len);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
