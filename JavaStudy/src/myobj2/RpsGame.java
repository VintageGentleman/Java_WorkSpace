package myobj2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class RpsGame {
	
	private static String[] shapes = {"바위", "보", "가위"};
	
	final public static int ROCK = 0;
	final public static int PAPER = 1;
	final public static int SCISSORS = 2;
	
	String savePath = "files/record.sav";
	
	int win;
	int draw;
	int lose;
	
	public RpsGame() {
		// 세이브 파일이 있는지 체크
		// - 있으면 전적을 불러온다
		// - 없으면 0 0 0으로 만든다
		
		try {
			FileInputStream in = new FileInputStream(savePath);
			
			String record = new String(in.readAllBytes());
			
			String[] recordArr = record.split("\n");
			
			win = Integer.parseInt(recordArr[0]);
			draw = Integer.parseInt(recordArr[1]);
			lose = Integer.parseInt(recordArr[2]);
			
			in.close();
		} catch (FileNotFoundException e) {
			System.err.println("파일을 찾지 못했습니다. 처음부터 다시 시작합니다.");
			win = 0;
			draw = 0;
			lose = 0;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void play(int user) {
		if(user < 0 || user > 2) {
			throw new NotRpsShapeException(user);
		}
		
		int com = (int)(Math.random() * 3);
		
		if(user == com) {
			// 비김
			System.out.printf("You [%s] vs AI [%s] : DRAW...\n",
					shapes[user], shapes[com]);
			++draw;
		} else if((user + 1) % 3 == com) {
			// 컴퓨터 승리
			System.out.printf("You [%s] vs AI [%s] : You Lose...\n",
					shapes[user], shapes[com]);
			++lose;
		} else {
			// 유저 승리
			System.out.printf("You [%s] vs AI [%s] : You Win!!\n",
					shapes[user], shapes[com]);
			++win;
		}
		
		System.out.printf("[%dw / %dd / %dl]\n", win, draw, lose);
	}
	
	public void close() {
		System.out.println("파일을 저장 중");
		try {
			FileOutputStream out = new FileOutputStream(savePath);
			String record = "";
			
			record += win + "\n";
			record += draw + "\n";
			record += lose + "\n";
			
			out.write(record.getBytes());
			out.close();
		} catch (FileNotFoundException e) {
			System.err.println("파일을 생성하지 못했습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("serial")
	class NotRpsShapeException extends RuntimeException {
		public NotRpsShapeException(int user) {
			super("유저가 입력한 값: " + user);
		}
	}
	
}
