package database.quiz;

public class J03_PotterWheel_Prize {
	int prize_id;
	String name;
	double rate;
	int qty;
	
	public J03_PotterWheel_Prize(int prize_id, String name, double rate, int qty) {
		this.prize_id = prize_id;
		this.name = name;
		this.rate = rate;
		this.qty = qty;
	} 
	
	public int getPrize_id() {
		return prize_id;
	}
	
	public String getName() {
		return name;
	} 
	
	public double getRate() {
		return rate;
	}
	
	public int getQty() {
		return qty;
	}
	
	@Override
	public String toString() {
		return String.format("%d / %s / %.2f\n", 
				prize_id, name, rate);
	}
}
