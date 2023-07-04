package database;

public class Coffee_T {
	private Integer coffee_id;
	private String coffee_name;
	private Integer coffee_price;
	
	// 우클릭 -> Source -> Generate Getters and Setters
	public Integer getCoffee_id() {
		return coffee_id;
	}
	public void setCoffee_id(Integer coffee_id) {
		this.coffee_id = coffee_id;
	}
	public String getCoffee_name() {
		return coffee_name;
	}
	public void setCoffee_name(String coffee_name) {
		this.coffee_name = coffee_name;
	}
	public Integer getCoffee_price() {
		return coffee_price;
	}
	public void setCoffee_price(Integer coffee_price) {
		this.coffee_price = coffee_price;
	}
}
