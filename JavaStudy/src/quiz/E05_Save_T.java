package quiz;

import myobj2.RpsGame;

public class E05_Save_T {

	public static void main(String[] args) {
	
		RpsGame game = new RpsGame();
		
		for(int i = 0; i < 10; ++i) {
			game.play(i % 3);
		}
	
		game.close();
		
	}
	
}
