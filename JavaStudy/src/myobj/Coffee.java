package myobj;

public class Coffee {
	String name;
	int degree;
	int price;
	
	public Coffee() {
		this("아메리카노", 5, 1500);
	}
	
	public Coffee(int price) {
		this("아메리카노", 5, price);
	}
	
	public Coffee(String name, int degree, int price) {
		this.name = name;
		this.degree = degree;
		this.price = price;
	}
	
	void addWater(int num) {
		degree -= num;
	}
	
	void addShot(int num) {
		degree += num;
	}
	
	public void info() {
		System.out.printf("커피명: %s\n맛의정도: %d\n가격: %d\n\n",
				name, degree, price);
	}
}
