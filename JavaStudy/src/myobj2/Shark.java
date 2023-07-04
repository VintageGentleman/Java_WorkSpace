package myobj2;

import myinterface.Swimmer;

public class Shark implements Swimmer {

	int speed;
	
	@Override
	public void swim() {
		System.out.println("상어가 " + speed + "의 속도로 헤엄을 칩니다.");
	}

	@Override
	public void dive(int meter) {
		System.out.println("상어가 " + meter + "만큼 잠수했습니다.");
	}

}
