package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class E08_Copy_Practice {
	
	public static void main(String[] args) {

		String folderName = "files";

		try {
			copy(folderName);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage()); 
		}
		
	}

	public static void copy(String folderName)
			throws FileNotFoundException {
		
		File path = new File(folderName);
		
		if(!path.exists()) {
			throw new FileNotFoundException("폴더가 존재하지 않습니다.");
		}

		copyDir(path, folderName);
	}

	public static void copyDir(File src, String origin) {
		for(File f : src.listFiles()) {
			if(f.isDirectory()) {
				copyDir(f, origin);
			} else {
				copyFile(f, origin);
			}
		}
	}

	public static void copyFile(File f, String origin) {
		StringBuilder sb = new StringBuilder();
		sb.append(f.getPath());
		sb.insert(origin.length(), 2);
		File copyFile = new File(sb.toString());
		
		if(!copyFile.getParentFile().exists()) {
			copyFile.getParentFile().mkdirs();
		}
		
		try(
			FileInputStream in = new FileInputStream(f);	
			FileOutputStream out = new FileOutputStream(copyFile);	
		) {
			byte[] buff = new byte[1024];
			int len;
			while((len = in.read(buff)) != -1) {
				out.write(buff, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

