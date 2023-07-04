import java.io.File;

public class E08_File {

	/*
	  	# java.io.File
	  	
	  	- 파일에 대한 정보를 담을 수 있는 클래스
	  	- 인스턴스를 생성할 때 실제 파일로부터 정보를 받아온다
	  	- 해당 인스턴스에 담긴 정보를 통해 파일 시스템을 직접 제어할 수 있다
	  	
	  	# 파일 시스템
	  	
	  	- 하드 디스크에 저장된 파일을 손쉽게 관리할 수 있도록 설정한 일부 구역
	  	- 파일 시스템의 내용을 디렉토리 구조로 볼 수 있게 하는 것이 탐색기
	*/
	
	public static void main(String[] args) {
		
		File f1 = new File("files/test.txt");
		File f2 = new File("files/");
		File f3 = new File("C:/JavaFullStack_HGT/Java_WorkSpace/RemoteStudy/");
		
		// isDirectory() : 해당 파일 인스턴스가 디렉토리인지 검사한다
		System.out.println("f1 is dir? " + f1.isDirectory());
		System.out.println("f2 is dir? " + f2.isDirectory());
		System.out.println("f3 is dir? " + f3.isDirectory());
		
		// isAbsolute() : 해당 경로가 절대 경로인지 여부를 검사한다
		
		/*
		 	절대 경로 - 현재 위치와 상관없이 해당 파일을 무조건 찾을 수 있는 경로
		 	
		 		C:\Program Files\java\jdk\javac.exe
		 	
		 	상대 경로 - 현재 위치에 영향을 받는 경로
		 	
		 		/   : 현재 속해있는 드라이브의 최상위
		 		./  : 현재 위치부터 시작 (생략 가능) 
		 		../ : 상위 폴더 
		 	
		 		/JavaFullStack/java-workspace/JavaStudy/
		 		  - 현재 드라이브가 C드라이브일때만 올바르게 작동
		 		  
		 		./java-workspace/JavaStudy/
		 		  - 현재 위치가 JavaFullStack 폴더인 경우 올바르게 작동
		*/
		
		System.out.println("f1 is abspath? " + f1.isAbsolute());
		System.out.println("f2 is abspath? " + f2.isAbsolute());
		System.out.println("f3 is abspath? " + f3.isAbsolute());
		
		// isFile() : 파일인지 여부 검사
		System.out.println("Is f1 a file? " + f1.isFile());

		// isHidden() : 숨김 파일인지 여부 검사
		System.out.println("Is f1 a hidden file? " + f1.isHidden());
		
		// exists() : 존재 여부를 검사
		System.out.println("해당 파일이 있나요? " + f1.exists());
		System.out.println("해당 파일이 있나요? " + f2.exists());
		System.out.println("해당 파일이 있나요? " + new File("./log/").exists());
		
		// mkdir() : 해당 경로에 디렉토리를 생성, 성공 여부를 반환
		File logDir = new File("log");
		
		if(!logDir.exists()) {
			logDir.mkdir();
		}
		
		// mkdirs() : 해당 경로에 존재하는 모든 디렉토리를 생성
		File toMake = new File("log/system/2023-04-13/am/");
		boolean result = toMake.mkdirs();
				
		System.out.println("디렉토리 만드는데 성공했나요? " + result);
		
		// list() : 해당 디렉토리 내부의 파일명들을 String[]로 반환한다
		// listFile() : 해당 디렉토리 내부의 파일들을 File[]로 반환한다
		if(f3.isDirectory()) {
			for(String fname : f3.list()) {
				System.out.println(fname);
			}
			
			for(File f : f3.listFiles()) {
				System.out.println(f);
				System.out.println(f.isFile());
				f.getName();
			}
		}
		
	}
	
}
