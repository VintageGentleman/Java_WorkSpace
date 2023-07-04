package database.quiz;

public class Coffee_A {
	private Integer coffee_id;
	private String coffee_name;
	private Integer coffee_price;
	
	// 0은 임시 번호입니다. id는 DB에서 자동으로 부여됨
	public Coffee_A(String coffee_name, Integer coffee_price) {
		this(0, coffee_name, coffee_price);
	}
	
	public Coffee_A(Integer coffee_id, String coffee_name, Integer coffee_price) {
		this.coffee_id = coffee_id;
		this.coffee_name = coffee_name;
		this.coffee_price = coffee_price;
	}
	
	@Override
	public String toString() {
		return String.format("%d번 / %s / %d\n", coffee_id,
				coffee_name, coffee_price);
	}
	
	// 이 아래는 get 메서드 모여있는 곳
	
	public Integer getCoffee_id() {
		return coffee_id;
	}
	
	public String getCoffee_name() {
		return coffee_name;
	}
	
	public Integer getCoffee_price() {
		return coffee_price;
	}
	
}
