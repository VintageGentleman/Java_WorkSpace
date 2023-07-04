package myobj;

public class SoccerBall extends Ball {
	
	@Override
	public void kick() {
		System.out.println("축구공을 발로 찼습니다");
	}

	@Override
	public void throwing() {
		System.out.println("축구공은 손으로 던지면 반칙입니다.");
	}
}
