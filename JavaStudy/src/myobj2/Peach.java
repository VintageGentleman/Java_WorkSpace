package myobj2;

public class Peach implements Comparable<Peach> {
	int price;
	int taste;
	char grade;
	double weight;
	String farmName;
	
	public Peach(int price, int taste, char grade, double weight, String farmName) {
		this.price = price;
		this.taste = taste;
		this.grade = grade;
		this.weight = weight;
		this.farmName = farmName;
	}
	
	@Override
	public int compareTo(Peach o) {
		return (this.weight < o.weight)? -1 : (this.weight == o.weight)? 0 : 1;
	}
	
	@Override
	public String toString() {
		return String.format("가격%d/맛%d/등급%c/무게%.2f/%s\n",
				price, taste, grade, weight, farmName);
	}
}


