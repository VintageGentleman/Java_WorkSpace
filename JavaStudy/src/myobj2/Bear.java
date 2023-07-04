package myobj2;

import myinterface.Runner;
import myinterface.Swimmer;

public class Bear implements Swimmer, Runner{

	int runSpeed;
	int swimSpeed;
	
	@Override
	public void run() {
		System.out.printf("곰이 %d의 속도로 뜁니다.\n", runSpeed);
	}

	@Override
	public void swim() {
		System.out.printf("곰이 %d의 속도로 헤엄칩니다.\n", swimSpeed);
	}

	@Override
	public void dive(int meter) {
		System.out.println("곰은 잠수는 잘 못합니다...");
		System.out.println(meter * 0.3 + "만큼 잠수했습니다.");
	}

}
