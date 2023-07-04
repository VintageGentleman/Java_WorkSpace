package quiz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import myobj2.Game_RockPaperScissors;

public class E05_Save_A {

	/*
	  	컴퓨터와 진행하는 간단한 가위바위보 게임을 만든 후
	  	프로그램 종료시 전적을 파일에 저장하고
	  	프로그램 실행 시에는 파일에 저장된 전적 데이터를 읽어 예전 전적이
	  	그대로 이어지도록 만들어보세요
	*/
	
	public static void main(String[] args) {

		int[] previousRecord = new int[3];
		
		try {
			FileInputStream in = new FileInputStream("files/game_record");
			byte[] temp = in.readAllBytes();
			String tempRecord = new String(temp);
			String[] split = tempRecord.split("\\n");
			in.close();
			
			for(int i = 0; i < previousRecord.length; ++i) {
				previousRecord[i] = Integer.parseInt(split[i]);
			}
			
		} catch (FileNotFoundException e) {
			System.err.println("저장 파일을 불러오는데 실패했습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Scanner sc = new Scanner(System.in);

		Game_RockPaperScissors game =
				new Game_RockPaperScissors(
						previousRecord[0],
						previousRecord[1],
						previousRecord[2]);

		System.out.println("게임을 종료하시려면 '종료'라고 입력하세요.");
		
		boolean gameRunning = true;
		while(gameRunning) {
			while(true) {
				try {
					System.out.print("[가위/바위/보] 중에 입력하세요\n>> ");
					String answer = sc.nextLine();
					if(answer.equals("종료")) {
						gameRunning = false;
						break;
					} else {
						game.playGame(answer);
						System.out.println();
						
						game.showRecord();
						System.out.println();
						break;
					}
				} catch (InputMismatchException e) {
					System.err.println(e.getMessage());
				}
			}
			
			if(!gameRunning) {
				System.out.println("\n게임 전적을 저장하고 종료합니다.");
				sc.close();
				break;
			}
		}
		
		try {
			FileOutputStream out = new FileOutputStream("files/game_record");
			int[] result = game.saveRecord();
			out.write((result[0] + "\n").getBytes());
			out.write((result[1] + "\n").getBytes());
			out.write((result[2] + "\n").getBytes());
			out.close();
		} catch (FileNotFoundException e) {
			System.err.println("잘못된 파일 경로입니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
