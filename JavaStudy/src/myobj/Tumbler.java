package myobj;

public class Tumbler {
	String brand;
	String name;
	int price;
	
	@Override
	public String toString() {
		return "이 텀블러는 " + brand + "의 " + name +"입니다.";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Tumbler)){
			return false;
		}
		Tumbler t1 = this;
		Tumbler t2 = (Tumbler) obj;
		
		return t1.brand.equals(t2.brand) && t1.name.equals(t2.name);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
