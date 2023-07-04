package myobj;

public class V6EngineCart {
	int engineRoom = 6;
	int calculationAccel = 6;
	String engineType = "강화V6";
	int presentSpeed = 0;
	
	void accelerate() {
		presentSpeed += calculationAccel;
	}
	
	void break_Cart() {
		presentSpeed -= calculationAccel;
	}
	
}
