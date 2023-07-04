package myobj;

public class Prize {
	String name;
	int price;
	int qty;
	double rate;
	
	public Prize(String name, int price, int qty, double rate) {
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.rate = rate;
	}
	
	public int getQty() {
		return qty;
	}
	
	@Override
	public String toString() {
		// String.format() : 서식을 이용해 원하는 문자열을 만든다
		// out.printf() : 서식을 이용해 원하는 문자열을 콘솔에 출력한다
		return String.format("[%s/%d/%.3f]", name, qty, rate);
	}
}
