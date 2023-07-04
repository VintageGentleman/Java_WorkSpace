package quiz.C;

import java.util.Scanner;

import myobj.GiftList;

public class C11_PotterWheel_A {
	
	/*
	  	# 돌림판을 돌려서 경품을 추천하는 프로그램을 만들어보세요
	  	
	  	(1) 각 경품들은 한정된 수량이 있으며 이는 경품마다 다를 수 있다
	  	
	  	(2) 각 경품들이 나올 수 있는 확률이 모두 다르며 수량이 모두 소진된 상품은
			당첨될 수 없다
	*/

	public static void main(String[] args) {
		
		GiftList gl = new GiftList();
		Scanner sc = new Scanner(System.in);
		boolean running = true;
		
		while(running) {
			System.out.print("진행 [1]번 잔여상품 [2]번 당첨확률 [3]번 종료 [4]번\n입력>> ");
			switch(sc.nextInt()) {
			case 1:
				gl.drawGift();
				break;
			case 2:
				gl.getRemainGift();
				break;
			case 3:
				gl.calRate();
				break;
			case 4:
				running = false;
				break;
			}
		}
		
		System.out.println("종료");
		sc.close();
	}

}
