package myobj;

public class Pirate {
	
	public boolean alive = true;
	public int count = 0;
	boolean[] boomSpot = new boolean[20]; 
	boolean[] pokedSpot = new boolean[20];
	
	/** 꽝 숫자를 지정하면 0 ~ 19 사이에 숫자만큼 랜덤하게 배치합니다*/
	public Pirate (int boomNumber) {
		for (int i = 0; i < boomNumber; ++i) {
			int random = (int)(Math.random() * boomSpot.length);
			if (boomSpot[random]) {
				--i;
			}
			boomSpot[random] = true;
		}
	}
	
	public void getBoomSpot() {
		this.viewScreen(boomSpot);
		System.out.println("꽝 자리는 : ");
		for (int i = 0; i < boomSpot.length; ++i) {
			if (boomSpot[i]) {
				System.out.print(i + "번 ");
			}
		}
		System.out.println("였습니다");
	}
	
	public void viewScreen() {
		for(int i = 0; i < pokedSpot.length; ++i) {
			if(!pokedSpot[i]) {
				System.out.print(" [O] ");
			} else {
				System.out.print(" [X] ");
			}
			if (i % 10 == 9) {
				System.out.println();		
			}
		}
	}
	
	void viewScreen(boolean[] boomSpot) {
		for(int i = 0; i < boomSpot.length; ++i) {
			if(!boomSpot[i]) {
				System.out.print(" [O] ");
			} else {
				System.out.print(" [꽝] ");
			}
			if (i % 10 == 9) {
				System.out.println();		
			}
		}
	}
	
	public void pokeSpot(int spotNumber) {
		if(spotNumber < 0 || spotNumber >= 20) {
			System.out.println("잘못된 곳을 찔렀습니다");
		} else {
			if (!pokedSpot[spotNumber]) {
				++count;
				System.out.println(spotNumber + "번째 지점을 찔렀습니다!");
				pokedSpot[spotNumber] = true;
			} else {
				System.out.println("이미 찔러본 곳입니다");
			}
			if (boomSpot[spotNumber]) {
				++count;
				System.out.println("정확한 곳을 찔렀습니다! 당신의 승리입니다");
				alive = false;
			}
		}
	}
	
}
