package myobj;

// 다른 패키지에서 다른 패키지의 무언가를 가져다 쓰기 위해서는
// 앞에 public이 붙어있어야 한다
public class Cart {
	
	public String name;
	public int acc;
	public int speed;
	public int max_speed;
	public int weight;
	public int break_power;
	
	public void plusSpeed() {
		speed += acc;
	}
	
	public void minusSpeed() {
		speed -= acc;
	}
	
}
