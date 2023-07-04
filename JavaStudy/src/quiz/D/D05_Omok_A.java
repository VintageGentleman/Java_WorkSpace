package quiz.D;

import java.util.Scanner;

import omok.Omokboard;

public class D05_Omok_A {
	
	/*
	  	오목을 만들어주세요
	*/
	
	public static void main(String[] args) {
		boolean game = true;
		Scanner sc = new Scanner(System.in);
		Omokboard ob = new Omokboard();
		
		ob.showBoard();
		
		System.out.println("○(흰) 돌이 먼저입니다.");
		while(game) {
			int row = 0;
			int column = 0;
			
			System.out.println("○(흰) 돌이 둘 차례입니다.");
			boolean validPlay = true;
			while(validPlay) {
				System.out.print("몇 번째 행(가로)에 두시겠습니까?\n>> ");
				row = sc.nextInt();
				System.out.print("몇 번째 열(세로)에 두시겠습니까?\n>> ");
				column = sc.nextInt();
				validPlay = ob.playGostone(0, row, column);
			}
			ob.showBoard();
			game = ob.conclusion(row, column);
			if(!game) {
				break;
			}
			
			System.out.println("●(검은) 돌이 둘 차례입니다.");
			validPlay = true;
			while(validPlay) {
				System.out.print("몇 번째 행(가로)에 두시겠습니까?\n>> ");
				row = sc.nextInt();
				System.out.print("몇 번째 열(세로)에 두시겠습니까?\n>> ");
				column = sc.nextInt();
				validPlay = ob.playGostone(1, row, column);
			}
			ob.showBoard();
			game = ob.conclusion(row, column);
		}
		
		sc.close();
	}
	
}
