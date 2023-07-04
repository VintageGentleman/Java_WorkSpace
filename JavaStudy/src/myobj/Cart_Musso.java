package myobj;

public class Cart_Musso extends V6EngineCart {
	int skillAccel = 10;
	int calculationAccel = 7;
	String specialSkill = "급가속";
	String cartName;
	byte degree = 0;
	boolean wingUp = false;
	
	@Override
	public void accelerate() {
		presentSpeed += this.calculationAccel;
	}
	
	@Override
	public void break_Cart() {
		if(wingUp) {
			presentSpeed -= this.calculationAccel; 
		} else {
			presentSpeed -= super.calculationAccel;
		}
	}
	
	public void useSkill() {
		presentSpeed += skillAccel;
	}
	
	public void makeCartName(String cartName) {
		this.cartName = cartName;
	}
	
	public void buildUpWing(byte degree) {
		this.degree += degree;
		if(++this.degree >= 6) {
			wingUp = true;
		} else {
			System.out.println("강화수치 상승");
		}
	}
	
	public void getCartName() {
		System.out.println(super.engineType + specialSkill + cartName);
	}

}
